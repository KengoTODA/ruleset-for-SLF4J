package jp.skypencil.pmd.slf4j;

import net.sourceforge.pmd.AbstractJavaRule;
import net.sourceforge.pmd.ast.ASTClassOrInterfaceType;
import net.sourceforge.pmd.ast.ASTImportDeclaration;
import net.sourceforge.pmd.ast.ASTName;

abstract class AbstractSlf4jRule extends AbstractJavaRule {
	private static final String LOGGER_CLASS_NAME = org.slf4j.Logger.class.getName();
	private static final String LOGGER_SIMPLE_CLASS_NAME = org.slf4j.Logger.class.getSimpleName();

	private boolean loggerIsImported;

	@Override
	public Object visit(ASTImportDeclaration node, Object data) {
		if (node.isStatic()) {
			return super.visit(node, data);
		}

		String fqcn = node.getFirstChildOfType(ASTName.class).getImage();
		if (fqcn.equals(LOGGER_CLASS_NAME)) {
			loggerIsImported = true;
		}
		return super.visit(node, data);
	}

	protected boolean fieldIsLogger(ASTClassOrInterfaceType field) {
		assert field != null;

		String typeName = field.getImage();
		if (typeName.equals(LOGGER_CLASS_NAME)) {
			return true;
		} else if (loggerIsImported && typeName.equals(LOGGER_SIMPLE_CLASS_NAME)) {
			return true;
		}
		return false;
	}
}
