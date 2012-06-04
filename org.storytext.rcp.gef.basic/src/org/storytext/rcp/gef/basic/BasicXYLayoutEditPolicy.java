package org.storytext.rcp.gef.basic;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.storytext.rcp.gef.basic.model.BasicNode;

public class BasicXYLayoutEditPolicy extends XYLayoutEditPolicy {

	@Override
	protected Command createChangeConstraintCommand(EditPart child,
			Object constraint) {
		return new UpdateCommand((BasicNode) child.getModel(),
				(Rectangle) constraint);
	}

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#
	 * createChildEditPolicy(org.eclipse.gef.EditPart)
	 */
	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		return new ResizableEditPolicy();
	}

}
