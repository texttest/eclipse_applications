package org.storytext.rcp.gef.basic;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.storytext.rcp.gef.basic.editPart.BasicGraphEditPart;
import org.storytext.rcp.gef.basic.editPart.BasicNodeEditPart;
import org.storytext.rcp.gef.basic.model.BasicGraph;
import org.storytext.rcp.gef.basic.model.BasicNode;

public class BasicEditPartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart editPart = null;
		if (model instanceof BasicGraph) {
			editPart = new BasicGraphEditPart();
		} else if (model instanceof BasicNode) {
			editPart = new BasicNodeEditPart();
		}

		if (editPart != null) {
			editPart.setModel(model);
		}

		return editPart;
	}

}
