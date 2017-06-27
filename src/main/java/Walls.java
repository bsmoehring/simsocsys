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


	public void getBoundaries() {
		double minX = Double.POSITIVE_INFINITY;
		double minY = Double.POSITIVE_INFINITY;
		double maxX = Double.NEGATIVE_INFINITY;
		double maxY = Double.NEGATIVE_INFINITY;
		for(Wall w : this.walls.values()){
			if(!w.isDoor()){
				if(w.getxFrom()<minX)	minX = w.getxFrom();
				if(w.getxTo()<minX)		minX = w.getxTo();
				if(w.getxFrom()>maxX)	maxX = w.getxFrom();
				if(w.getxTo()>maxX)		maxX = w.getxTo();
				if(w.getyFrom()<minY)	minY = w.getyFrom();
				if(w.getyTo()<minY)		minY = w.getyTo();
				if(w.getyFrom()>maxY)	maxY = w.getyFrom();
				if(w.getyTo()>maxY)		maxY = w.getyTo();
				
			}
		}
		Simulation.trainMinX = minX;
		Simulation.trainMaxX = maxX;
		Simulation.trainMinY = minY;
		Simulation.trainMaxY = maxY;
		System.out.println("Simulation.trainMinX " + Simulation.trainMinX);
		System.out.println("Simulation.trainMaxX " + Simulation.trainMaxX);
		System.out.println("Simulation.trainMinY " + Simulation.trainMinY);
		System.out.println("Simulation.trainMaxY " + Simulation.trainMaxY);
		
	}


}
