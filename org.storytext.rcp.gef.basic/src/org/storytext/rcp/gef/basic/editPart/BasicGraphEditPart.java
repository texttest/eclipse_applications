package org.storytext.rcp.gef.basic.editPart;

import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.tools.MarqueeDragTracker;
import org.storytext.rcp.gef.basic.BasicXYLayoutEditPolicy;
import org.storytext.rcp.gef.basic.model.BasicGraph;
import org.storytext.rcp.gef.basic.model.BasicNode;

public class BasicGraphEditPart extends AbstractGraphicalEditPart {

	DragTracker tracker = new MarqueeDragTracker();
	@Override
	protected IFigure createFigure() {
		Figure freeformLayer = new FreeformLayer();
		freeformLayer.setLayoutManager(new FreeformLayout());
		freeformLayer.setOpaque(true);
		return freeformLayer;
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new BasicXYLayoutEditPolicy());

	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getDragTracker(org.eclipse.gef.Request)
	 */
	@Override
	public DragTracker getDragTracker(Request request) {
		return tracker;
	}

	@Override
	public List<BasicNode> getModelChildren() {
		return ((BasicGraph) getModel()).getNodes();
	}
	

}
