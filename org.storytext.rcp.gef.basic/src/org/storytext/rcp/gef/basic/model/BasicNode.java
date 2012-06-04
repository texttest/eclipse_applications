package org.storytext.rcp.gef.basic.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

public class BasicNode {
	private String name;
	private List<BasicConnection> sourceConnections = new ArrayList<BasicConnection>();
	private List<BasicConnection> targetConnections = new ArrayList<BasicConnection>();
	private Point location;
	private Dimension size;
	transient protected PropertyChangeSupport listeners = new PropertyChangeSupport(
			this);

	public BasicNode(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<BasicConnection> getSourceConnections() {
		return sourceConnections;
	}

	public List<BasicConnection> getTargetConnections() {
		return targetConnections;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
		firePropertyChange("location", null, location);
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
		firePropertyChange("size", null, size);
	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		listeners.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		listeners.removePropertyChangeListener(l);
	}

	protected void firePropertyChange(String prop, Object old, Object newValue) {
		listeners.firePropertyChange(prop, old, newValue);
	}

}
