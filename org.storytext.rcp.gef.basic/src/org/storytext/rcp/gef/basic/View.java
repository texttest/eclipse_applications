package org.storytext.rcp.gef.basic;

import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.FreeformGraphicalRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.storytext.rcp.gef.basic.model.BasicGraph;

public class View extends ViewPart {
	public static final String ID = "org.pyusecase.rcp.gef.draw2d.view";

	private DefaultEditDomain editDomain;
	private GraphicalViewer viewer;

	public void createPartControl(Composite parent) {
		editDomain = new DefaultEditDomain(null);
		GraphicalViewer sgviewer = new ScrollingGraphicalViewer();
		editDomain.addViewer(sgviewer);
		viewer = sgviewer;
		viewer.createControl(parent);
		viewer.setRootEditPart(new FreeformGraphicalRootEditPart());
		viewer.setEditPartFactory(new BasicEditPartFactory());
		viewer.setContents(new BasicGraph());
	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}
}
