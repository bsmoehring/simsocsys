import java.util.HashMap;
import java.util.Map;

import processing.core.PApplet;

public class Walls {
	
	private final Map<Integer,Wall> walls = new HashMap<Integer,Wall>();
	
	public Walls(){
		
		Wall w1 = this.createWall(00.35, 1.00, 01.88, 1.00, false, 1); 
        Wall w2 = this.createWall(03.18, 1.00, 05.80, 1.00, false, 2);
        Wall w3 = this.createWall(07.10, 1.00, 09.72, 1.00, false, 3);
        Wall w4 = this.createWall(11.02, 1.00, 12.55, 1.00, false, 4);
        Wall w5 = this.createWall(00.35, 3.30, 01.88, 3.30, false, 5);
        Wall w6 = this.createWall(03.18, 3.30, 05.80, 3.30, false, 6);
        Wall w7 = this.createWall(07.10, 3.30, 09.72, 3.30, false, 7);
        Wall w8 = this.createWall(11.02, 3.30, 12.55, 3.30, false, 8);
        Wall w9 = this.createWall(00.35, 1.00, 00.35, 3.30, false, 9);
        
//        Wall w00= this.createWall(12.55, 3.30, 999.0, 3.30, false, 10);
//        Wall w01= this.createWall(12.55, 1.00, 999.9, 1.00, false, 11);
        
        Wall d1 = this.createWall(01.88, 1.00, 03.18, 1.00, true, 101);
        Wall d2 = this.createWall(01.88, 3.30, 03.18, 3.30, false, 102);
        Wall d3 = this.createWall(05.80, 1.00, 07.10, 1.00, true, 103);
        Wall d4 = this.createWall(05.80, 3.30, 07.10, 3.30, false, 104);
        Wall d5 = this.createWall(09.72, 1.00, 11.02, 1.00, true, 105);
        Wall d6 = this.createWall(09.72, 3.30, 11.02, 3.30, false, 106);
	}
   	
   	public Map<Integer, Wall> getWalls() {
   		return walls;
   	}
   	
   	
   	public Wall createWall(double xFrom, double yFrom, double xTo, double yTo, boolean door, int id){
   		
   		Wall w = new Wall( xFrom, yFrom+3, xTo, yTo+3, door, id);
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
