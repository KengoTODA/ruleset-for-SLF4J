package jp.skypencil.pmd.slf4j;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.pmd.AbstractJavaRule;
import net.sourceforge.pmd.ast.ASTArgumentList;
import net.sourceforge.pmd.ast.ASTClassOrInterfaceType;
import net.sourceforge.pmd.ast.ASTExpression;
import net.sourceforge.pmd.ast.ASTFieldDeclaration;
import net.sourceforge.pmd.ast.ASTLiteral;
import net.sourceforge.pmd.ast.ASTPrimaryExpression;
import net.sourceforge.pmd.ast.ASTPrimarySuffix;
import net.sourceforge.pmd.ast.ASTType;
import net.sourceforge.pmd.ast.ASTVariableDeclaratorId;

import org.slf4j.Logger;

public class BracketWithoutArgument extends AbstractJavaRule {
	private Set<String> loggerFields = new HashSet<String>();

	@Override
	public Object visit(ASTFieldDeclaration node, Object data) {
		ASTType fieldType = node.getFirstChildOfType(ASTType.class);
		if (fieldType == null) {
			return super.visit(node, data);
		}
		ASTClassOrInterfaceType fieldClass = fieldType.getFirstChildOfType(ASTClassOrInterfaceType.class);
		if (fieldClass != null && Logger.class.equals(fieldClass.getType())) {
			String fieldName = node.getFirstChildOfType(ASTVariableDeclaratorId.class).getNameDeclaration().getImage();
			loggerFields.add(fieldName);
		}
		return super.visit(node, data);
	}

	@Override
	public Object visit(ASTPrimaryExpression node, Object data) {
		ASTPrimarySuffix suffix = node.getFirstChildOfType(ASTPrimarySuffix.class);
		if (suffix == null) {
			return super.visit(node, data);
		}
		ASTArgumentList argumentList = suffix.getFirstChildOfType(ASTArgumentList.class);
		if (argumentList == null) {
			return super.visit(node, data);
		}

		List<ASTExpression> arguments = argumentList.findChildrenOfType(ASTExpression.class);
		if (arguments.size() > 0) {
			ASTLiteral literal = arguments.get(0).getFirstChildOfType(ASTLiteral.class);
			if (literal != null) {
				String format = literal.getImage();
				int expectedArguments = countDelimiter(format);
				if (expectedArguments != arguments.size() - 1 && expectedArguments != arguments.size() - 2) {
					// last argument may Throwable
					addViolation(data, node);
				}
			}
		}
		return super.visit(node, data);
	}

	int countDelimiter(String format) {
		Matcher matcher = Pattern.compile("(.?)(\\\\\\\\)*\\{\\}").matcher(format);
		int count = 0;
		while (matcher.find()) {
			if (!"\\".equals(matcher.group(1))) {
				++count;
			}
		}
		return count;
	}
}
