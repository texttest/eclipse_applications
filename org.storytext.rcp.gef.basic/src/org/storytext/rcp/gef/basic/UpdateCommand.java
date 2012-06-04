package org.storytext.rcp.gef.basic;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.storytext.rcp.gef.basic.model.BasicNode;

public class UpdateCommand extends Command {
	private BasicNode node;
	private Point newLocation;
	private Dimension newSize;

	public UpdateCommand(BasicNode node, Rectangle rectangle) {
		this.node = node;
		this.newLocation = rectangle.getLocation();
		this.newSize = rectangle.getSize();
	}

	public boolean canExecute() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		node.setLocation(newLocation);
		node.setSize(newSize);
	}

}
