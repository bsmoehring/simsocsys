import java.util.LinkedList;
import java.util.List;

/**
 * Created by laemmel on 27.04.17.
 */
public class Node extends HasCoords{
    private final double x;
   	private final double y;
   	private final int id;

   	private final List<Link> outLinks = new LinkedList<Link>();
	private final List<Link> inLinks = new LinkedList<Link>();

	private Dijkstra.NodeInfo nodeInfo;

   	public Dijkstra.NodeInfo getNodeInfo() {
		return nodeInfo;
	}

	public Node(double x, double y, int id) {
   		this.x = x;
   		this.y = y;
   		this.id = id;
   	}
	
	public Link getLinkToNode(Node nodeTo){
		
		for (int i = 0; i < this.outLinks.size(); i++){
		
			if (nodeTo.equals(outLinks.get(i).getTo())){
				return outLinks.get(i);
			}
		} 
		
		return null;
		
	}

   	public void addOutLink(Link l) {
   		this.outLinks.add(l);
   	}
   	
   	public List<Link> getOutLinks() {
		return outLinks;
	}

   	public void addInLink(Link l) {
   		this.inLinks.add(l);
   	}

   	public double getX() {
   		return this.x;
   	}

   	public double getY() {
   		return this.y;
   	}
   	
   	public int getId(){
   		return this.id;
   	}

	public void setNodeInfo(Dijkstra.NodeInfo nodeInfo) {
		this.nodeInfo = nodeInfo;
		
	}
}
