import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Dijkstra {
	
	private Map<Integer,Node> nodes = new HashMap<Integer,Node>();
	
	public Dijkstra(Map<Integer, Node> nodes) {
		
		this.nodes = nodes;
	}

	public List<Link> findRoute(Node start, Node destination){
		
//		create Maps for costs and predecessor. add all nodes with maximum costs but without predecessors. start node with costs 0.
		List<NodeInfo> nodeInfos = new LinkedList<NodeInfo>();
		for (Entry<Integer, Node> entry : nodes.entrySet()){
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
		
		List<Link> route = new ArrayList<>();
		Node nodeFrom = predecessors.get(predecessors.size()-1);
		while (nodeFrom != destination){
			route.add(nodeFrom.getLinkToNode(predecessors.get(predecessors.size()-2)));
			predecessors.remove(nodeFrom);
			nodeFrom = predecessors.get(predecessors.size()-1);
		}
		
//		System.out.println(route);
		
		return route;
		
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
