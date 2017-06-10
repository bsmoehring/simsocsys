import java.util.LinkedList;
import java.util.List;

public class Room {
	
	private int id;
	private List<Link> links = new LinkedList<Link>();
	private List<Wall> walls = new LinkedList<Wall>();
	
	public Room(int id, List<Link> links, List<Wall> walls){
		this.id = id;
		this.links = links;
		this.walls= walls;
	}
	
	public int getId(){
		return id;
	}
	
	public List<Wall> getWalls() {
		return walls;
	}
	public List<Link> getLinks() {
		return links;
	}
	
	

}
