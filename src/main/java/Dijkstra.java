import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Dijkstra {
	
	public Dijkstra() {
		
	}
	
	public List<Link> findRoute(double xFrom, double yFrom, boolean leaving){
		if (leaving){
			return this.findRoute(xFrom, yFrom, this.getLeavingDestination(xFrom, yFrom));
		} else {
			return this.findRoute(xFrom, yFrom, this.getEnteringDestination(xFrom, yFrom));
		}
	}

	public List<Link> findRoute(double xFrom, double yFrom, Node dest){
		
		Node start = getClosestNode(xFrom, yFrom);
		Node destination = dest;
		
		List<Link> route = new ArrayList<>();
		
		if (start==destination){
			
			route.add(destination.getInLinks().get(0));
			return route;
		}
		
//		create Maps for costs and predecessor. add all nodes with maximum costs but without predecessors. start node with costs 0.
		List<NodeInfo> nodeInfos = new LinkedList<NodeInfo>();
		for (Entry<Integer, Node> entry : Simulation.net.getNodes().entrySet()){
			NodeInfo nodeInfo = new NodeInfo();
			nodeInfo.cost = Double.POSITIVE_INFINITY;
			nodeInfo.node = entry.getValue();
			entry.getValue().setNodeInfo(nodeInfo);
			nodeInfos.add(nodeInfo);
		}
		
		start.getNodeInfo().cost = 0;
		Node nodeCurrent = start;
		
		while(nodeCurrent != destination){
			
			expandGraph(nodeCurrent);
//			System.out.println(nodeCurrent.getId() + "  " + nodeCurrent.getNodeInfo().cost + " " + nodes.get(6).getNodeInfo().cost);
			
			Collections.sort(nodeInfos);
			nodeInfos.remove(nodeCurrent.getNodeInfo());
			nodeCurrent = nodeInfos.get(0).node;	
		}
		
		List<Node> predecessors = new ArrayList<>();
		nodeCurrent = destination;
		while(nodeCurrent != start){
//			System.out.println("pre:" + nodeCurrent.getId());
			predecessors.add(nodeCurrent);
			nodeCurrent = nodeCurrent.getNodeInfo().predecessor;
		}
		predecessors.add(start);
		
		Node nodeFrom = predecessors.get(predecessors.size()-1);
		while (nodeFrom != destination){
			route.add(nodeFrom.getLinkToNode(predecessors.get(predecessors.size()-2)));
			predecessors.remove(nodeFrom);
			nodeFrom = predecessors.get(predecessors.size()-1);
		}
		
//		System.out.println(route);
		
		return route;
		
	}
	
	private Node getClosestNode(double xFrom, double yFrom) {

		Node closest = null; 
		double closestDistance = Double.POSITIVE_INFINITY;
		for (Node n : Simulation.net.getNodes().values()){
			double nodeDistance = (xFrom-n.getX())*(xFrom-n.getX())+(yFrom-n.getY())*(yFrom-n.getY());
			if (nodeDistance<closestDistance){
				closestDistance = nodeDistance;
				closest = n;
			}
		}
		
		return closest;
	}
	
	private Node getLeavingDestination(double xFrom, double yFrom){
		Node closest = null; 
		double closestDistance = Double.POSITIVE_INFINITY;
		for (Node n : Simulation.net.getNodes().values()){
			if(n.getId() == 10 ||n.getId() == 11 ||n.getId() == 410 ||n.getId() == 411 ||n.getId() == 510 ||n.getId() == 511){
				double nodeDistance = (xFrom-n.getX())*(xFrom-n.getX())+(yFrom-n.getY())*(yFrom-n.getY());
				if (nodeDistance<closestDistance){
					closestDistance = nodeDistance;
					closest = n;
				}
			}
		}
		
		return closest;
	}
	private Node getEnteringDestination(double xFrom, double yFrom){
		Node closest = null; 
		double closestDistance = Double.POSITIVE_INFINITY;
		for (Node n : Simulation.net.getNodes().values()){
			if(n.getId() == 14 ||n.getId() == 414 ||n.getId() == 514 ||n.getId() == 614 ){
				double nodeDistance = (xFrom-n.getX())*(xFrom-n.getX())+(yFrom-n.getY())*(yFrom-n.getY());
				if (nodeDistance<closestDistance){
					closestDistance = nodeDistance;
					closest = n;
				}
			}
		}
		
		return closest;
	}

	private void expandGraph(Node nodeCurrent) {
		
		for(Link entry : nodeCurrent.getOutLinks()){

			double costUpdated = nodeCurrent.getNodeInfo().cost + entry.getLength();
				
			if(costUpdated < entry.getTo().getNodeInfo().cost){
				
				entry.getTo().getNodeInfo().cost = costUpdated;
				entry.getTo().getNodeInfo().predecessor = nodeCurrent;
				
			}		
			
		}
	}

	public static final class NodeInfo implements Comparable<NodeInfo>{
		Node node;
		double cost;
		Node predecessor;
		@Override
		public int compareTo(NodeInfo arg0) {
			if(cost<arg0.cost){
				return -1;
			} else if (cost > arg0.cost){
				return 1;
			}
			return 0;
		}
	}

}
