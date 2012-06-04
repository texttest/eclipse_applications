package org.storytext.rcp.gef.basic.editPart;

import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;

public class BasicConnectionEditPart extends AbstractConnectionEditPart {

	@Override
	protected void createEditPolicies() {		

	}

	@Override
	protected IFigure createFigure() {
		PolylineConnection c = new PolylineConnection();
		c.setConnectionRouter(ConnectionRouter.NULL);
		c.setTargetDecoration(new PolylineDecoration());
		return c;
	}

}
