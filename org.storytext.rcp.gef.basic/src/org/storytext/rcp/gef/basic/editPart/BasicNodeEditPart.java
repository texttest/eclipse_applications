package org.storytext.rcp.gef.basic.editPart;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.storytext.rcp.gef.basic.model.BasicConnection;
import org.storytext.rcp.gef.basic.model.BasicNode;

public class BasicNodeEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener, NodeEditPart {
	private ChopboxAnchor anchor;
	private static int counter;

	@Override
	protected IFigure createFigure() {		
		counter++;
		RectangleFigure rect = new RectangleFigure();
		rect.setBackgroundColor(ColorConstants.lightGreen);
		Point p = new Point(0, 0);
		if (counter > 1) {
			p = new Point(counter * 70,  2*60);
		} else {
			p = new Point(70,  60);
		}
		
		rect.setLocation(p);
		rect.setSize(new Dimension(55, 30));
		((BasicNode) getModel()).setLocation(p);
		((BasicNode) getModel()).setSize(rect.getSize());
		anchor = new ChopboxAnchor(rect);
		return rect;
	}

	@Override
	protected void createEditPolicies() {

	}

	/**
	   * @see java.beans.PropertyChangeListener#propertyChange(PropertyChangeEvent)
	  **/
	  public void propertyChange(PropertyChangeEvent evt)
	  {
	  	String prop = evt.getPropertyName();	  	
		if (prop.equals("size") || prop.equals("location")) {
			refreshVisuals();
		}
	  }
	  
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#activate()
	 */
	@Override
	public void activate() {
		if (!isActive()) {
			super.activate();
			((BasicNode)getModel()).addPropertyChangeListener(this);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#deactivate()
	 */
	@Override
	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			((BasicNode)getModel()).addPropertyChangeListener(this);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelSourceConnections()
	 */
	@Override
	protected List<BasicConnection> getModelSourceConnections() {
		return ((BasicNode) getModel()).getSourceConnections();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getModelTargetConnections()
	 */
	@Override
	protected List<BasicConnection> getModelTargetConnections() {
		return ((BasicNode) getModel()).getTargetConnections();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createConnection(java.lang.Object)
	 */
	@Override
	protected ConnectionEditPart createConnection(Object model) {
		BasicConnectionEditPart cep = (BasicConnectionEditPart) getRoot()
				.getViewer().getEditPartRegistry().get(model);
		if (cep == null) {
			cep = new BasicConnectionEditPart();
			cep.setModel(model);
		}
		return cep;
	}

	@Override
	protected void refreshVisuals() {
		Point location = ((BasicNode) getModel()).getLocation();
		Dimension size = ((BasicNode) getModel()).getSize();
		Rectangle constraint = new Rectangle(location, size);
		((GraphicalEditPart) getParent()).setLayoutConstraint(this,
				getFigure(), constraint);
	}

	public ConnectionAnchor getSourceConnectionAnchor(
			ConnectionEditPart connection) {
		return anchor;
	}

	/**
	 * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(Request)
	 **/
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return null;
	}

	/**
	 * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(ConnectionEditPart)
	 **/
	public ConnectionAnchor getTargetConnectionAnchor(
			ConnectionEditPart connection) {
		return anchor;
	}

	/**
	 * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(Request)
	 **/
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return null;
	}

}
