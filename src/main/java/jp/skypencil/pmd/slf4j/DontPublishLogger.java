package jp.skypencil.pmd.slf4j;

import net.sourceforge.pmd.AbstractJavaRule;
import net.sourceforge.pmd.ast.ASTClassOrInterfaceType;
import net.sourceforge.pmd.ast.ASTFieldDeclaration;

public final class DontPublishLogger extends AbstractJavaRule {
	@Override
	public Object visit(ASTFieldDeclaration node, Object data) {
		ASTClassOrInterfaceType field = node.getFirstChildOfType(ASTClassOrInterfaceType.class);
		if (field != null && field.getType().equals(org.slf4j.Logger.class) && !node.isPrivate()) {
			addViolation(data, node);
		}

		return super.visit(node, data);
	}
}
