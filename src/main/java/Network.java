import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by laemmel on 27.04.17.
 */
public class Network {
    
	private final Map<Integer,Node> nodes = new HashMap<Integer,Node>();
	private final Map<Integer,Link> links = new HashMap<Integer,Link>();
	private final List<LinkInfo> linkInfos = new ArrayList<>();

	public Network(){
		Node n1 = createNode(02.53, 01.00, 1);
        Node n2 = createNode(02.53, 01.50, 2);
        Node n3 = createNode(01.88, 02.15, 3);
        Node n4 = createNode(02.53, 02.80, 4);
        Node n5 = createNode(02.53, 03.30, 5);
        Node n6 = createNode(03.18, 02.15, 6);
        Node n7 = createNode(02.53, -9.00, 7);
        Node n8 = createNode(01.00, 02.15, 8);
        Node n9 = createNode(04.06, 02.15, 9);
        
        Node n10 = createNode(4.50, -9.00, 10);
        
        Node n11 = createNode(06.45, 01.00, 11);
        Node n12 = createNode(06.45, 01.50, 12);
        Node n13 = createNode(05.80, 02.15, 13);
        Node n14 = createNode(06.45, 02.80, 14);
        Node n15 = createNode(06.45, 03.30, 15);
        Node n16 = createNode(07.10, 02.15, 16);
        Node n17 = createNode(06.45, -9.00, 17);
        Node n18 = createNode(04.95, 02.15, 18);
        Node n19 = createNode(07.88, 02.15, 19);
      
        Link l0 	= createLink(n1, n7, 1, 0);
        Link l0_rev = createLink(n7, n1, 2, 0);
        Link l1 	= createLink(n1, n2, 3, 1);
        Link l1_rev = createLink(n2, n1, 4, 1);
        Link l2 	= createLink(n2, n3, 5, 1);
        Link l2_rev = createLink(n3, n2, 6, 1);
        Link l3 	= createLink(n2, n6, 7, 1);
        Link l3_rev = createLink(n6, n2, 8, 1);
        Link l4 	= createLink(n2, n4, 9, 1);
        Link l4_rev = createLink(n4 ,n2, 10, 1);
        Link l5 	= createLink(n4, n6, 11, 1);
        Link l5_rev = createLink(n6 ,n4, 12, 1);
        Link l6 	= createLink(n4, n5, 13, 1);
        Link l6_rev = createLink(n5 ,n4, 14, 1);
        Link l7 	= createLink(n3, n6, 15, 1);
        Link l7_rev = createLink(n6 ,n3, 16, 1);
        Link l8 	= createLink(n3, n4, 17, 1);
        Link l8_rev = createLink(n4 ,n3, 18, 1);
        Link l9 	= createLink(n3, n8, 17, 1);
        Link l9_rev = createLink(n8 ,n3, 18, 1);
        Link l91 	= createLink(n6, n9, 17, 1);
        Link l91_rev= createLink(n9 ,n6, 18, 1);
        Link l92 	= createLink(n9, n18, 17, 1);
        Link l92_rev= createLink(n18 ,n9, 18, 1);
        
        
        Link l10 		= createLink(n11, n17, 1, 0);
        Link l10_rev 	= createLink(n17, n11, 2, 0);
        Link l11 		= createLink(n11, n12, 3, 1);
        Link l11_rev	= createLink(n12, n11, 4, 1);
        Link l12 		= createLink(n12, n13, 5, 1);
        Link l12_rev	= createLink(n13, n12, 6, 1);
        Link l13 		= createLink(n12, n16, 7, 1);
        Link l13_rev	= createLink(n16, n12, 8, 1);
        Link l14 		= createLink(n12, n14, 9, 1);
        Link l14_rev	= createLink(n14 ,n12, 10, 1);
        Link l15 		= createLink(n14, n16, 11, 1);
        Link l15_rev	= createLink(n16 ,n14, 12, 1);
        Link l16 		= createLink(n14, n15, 13, 1);
        Link l16_rev	= createLink(n15 ,n14, 14, 1);
        Link l17 		= createLink(n13, n16, 15, 1);
        Link l17_rev	= createLink(n16 ,n13, 16, 1);
        Link l18 		= createLink(n13, n14, 17, 1);
        Link l18_rev	= createLink(n14 ,n13, 18, 1);
        Link l19 		= createLink(n13, n18, 17, 1);
        Link l19_rev 	= createLink(n18 ,n13, 18, 1);
        Link l191 		= createLink(n16, n19, 17, 1);
        Link l191_rev	= createLink(n19 ,n16, 18, 1);
//        Link l192 		= createLink(n19, n28, 17, 1);
//        Link l192_rev	= createLink(n28 ,n19, 18, 1);
        Link l100 		= createLink(n7, n10, 100, 1);
        Link l100_rev 	= createLink(n10 ,n7, 1001, 1);
        Link l101 		= createLink(n10, n17, 101, 1);
        Link l101_rev	= createLink(n17 ,n10, 1011, 1);
	}
	
   	public Map<Integer, Link> getLinks() {
		return links;
	}
   	
   	public Map<Integer, Node> getNodes() {
		return nodes;
	}

   	public Node createNode(double x, double y, int id) {
   		Node n = new Node(x,y,id);
   		this.nodes.put(id,n);
   		return n;
   	}

   	public Link createLink(Node from, Node to, int id, int room) {
   		Link l = new Link(from,to,id,room);
   		this.links.put(id,l);
   		from.addOutLink(l);
   		to.addInLink(l);
        LinkInfo li = new LinkInfo();
        li.x0 = (float)(from.getX()*Simulation.SCALE);
        li.y0 = (float)(from.getY()*Simulation.SCALE);
        li.x1 = (float)(to.getX()*Simulation.SCALE);
        li.y1 = (float)(to.getY()*Simulation.SCALE);
        linkInfos.add(li);
   		return l;
   	}

	public void draw(PApplet p) {
		p.stroke(0,255);
		p.strokeWeight(1);
   	    for (LinkInfo linkInfo : this.linkInfos) {
   	        p.line(linkInfo.x0,linkInfo.y0,linkInfo.x1,linkInfo.y1);
        }

	}

	private static final class LinkInfo {
   	    float x0;
   	    float y0;
   	    float x1;
   	    float y1;
    }
	
}
