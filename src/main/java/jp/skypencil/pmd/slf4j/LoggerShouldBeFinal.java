package jp.skypencil.pmd.slf4j;

import net.sourceforge.pmd.AbstractJavaRule;
import net.sourceforge.pmd.ast.ASTClassOrInterfaceType;
import net.sourceforge.pmd.ast.ASTFieldDeclaration;

public final class LoggerShouldBeFinal extends AbstractJavaRule {
	@Override
	public Object visit(ASTFieldDeclaration node, Object data) {
		Class<?> fieldType = node.getFirstChildOfType(ASTClassOrInterfaceType.class).getType();
		if (fieldType.equals(org.slf4j.Logger.class) && !node.isFinal()) {
			addViolation(data, node);
		}

		return super.visit(node, data);
	}
}
