package simulation;
import java.util.HashMap;
import java.util.Map;

import processing.core.PApplet;

public class Walls {
	
	private final Map<Integer,Wall> walls = new HashMap<Integer,Wall>();
	
   	
   	public Map<Integer, Wall> getWalls() {
   		return walls;
   	}
   	
   	
   	public Wall createWall(double xFrom, double yFrom, double xTo, double yTo, boolean door, int id){
   		
   		Wall w = new Wall( xFrom, yFrom, xTo, yTo, door, id);
   		this.walls.put(id, w);
   		return w;
   	}
   	
	public void draw(PApplet p) {
		
		p.stroke((float)0.5);
		p.strokeWeight(4);
   	    for (Wall wall : this.walls.values()) {
   	    	if(!wall.isDoor() || !wall.isOpen()){
   	    		p.line((float)(wall.getxFrom()*Simulation.SCALE),(float)(wall.getyFrom()*Simulation.SCALE),(float)(wall.getxTo()*Simulation.SCALE),(float)(wall.getyTo()*Simulation.SCALE));
   	    	}
   	    }

	}


}
