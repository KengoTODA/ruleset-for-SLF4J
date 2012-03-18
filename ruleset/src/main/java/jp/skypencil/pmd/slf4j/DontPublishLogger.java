package jp.skypencil.pmd.slf4j;

import net.sourceforge.pmd.AbstractJavaRule;
import net.sourceforge.pmd.ast.ASTClassOrInterfaceType;
import net.sourceforge.pmd.ast.ASTFieldDeclaration;
import net.sourceforge.pmd.ast.ASTImportDeclaration;
import net.sourceforge.pmd.ast.ASTName;

public final class DontPublishLogger extends AbstractJavaRule {
	private static final String LOGGER_CLASS_NAME = org.slf4j.Logger.class.getName();
	private static final String LOGGER_SIMPLE_CLASS_NAME = org.slf4j.Logger.class.getSimpleName();

	private boolean loggerIsImported;

	@Override
	public Object visit(ASTImportDeclaration node, Object data) {
		String fqcn = node.getFirstChildOfType(ASTName.class).getImage();
		if (fqcn.equals(LOGGER_CLASS_NAME)) {
			loggerIsImported = true;
		}
		return super.visit(node, data);
	}

	@Override
	public Object visit(ASTFieldDeclaration node, Object data) {
		ASTClassOrInterfaceType field = node.getFirstChildOfType(ASTClassOrInterfaceType.class);
		if (field != null && !node.isPrivate()) {
			if (field.getImage().equals(LOGGER_CLASS_NAME)) {
				addViolation(data, node);
			} else if (loggerIsImported && field.getImage().equals(LOGGER_SIMPLE_CLASS_NAME)) {
				addViolation(data, node);
			}
		}

		return super.visit(node, data);
	}
}
