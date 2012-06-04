package org.storytext.rcp.gef.basic.model;

import java.util.ArrayList;
import java.util.List;

public class BasicGraph {
	List<BasicNode> nodes = new ArrayList<BasicNode>();

	public BasicGraph() {		
		nodes.add(new BasicNode("Node1"));

		for (int i = 1; i < 4; i++){
			nodes.add(new BasicNode("Node2"));
			BasicConnection connection = new BasicConnection();
			connection.setSource(nodes.get(0));
			connection.setTarget(nodes.get(i));
			nodes.get(0).getSourceConnections().add(connection);
			nodes.get(i).getTargetConnections().add(connection);
		}		
		
	}

	public List<BasicNode> getNodes() {
		return nodes;
	}

}
