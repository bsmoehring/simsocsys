import java.util.HashMap;
import java.util.Map;

import processing.core.PApplet;

public class Walls {
	
	private final Map<Integer,Wall> walls = new HashMap<Integer,Wall>();
	
	public Walls(){
		
		createWall(00.35, 1.00, -9.99, 1.00, false, 998); 
		createWall(24.31, 1.00, 99.99, 1.00, false, 999); 
		
        createWall(00.35, 1.00, 00.35, 3.30, false, 0);

		createWall(00.35, 1.00, 01.88, 1.00, false, 1); 
		createWall(01.88, 1.00, 03.18, 1.00, true, 101);
		
//		createWall(01.88, 1.00, 01.88, -1.00, false, 1001);
//		createWall(03.18, 1.00, 03.18, -1.00, false, 1002);
		
        createWall(03.18, 1.00, 05.80, 1.00, false, 2);
        createWall(05.80, 1.00, 07.10, 1.00, true, 102);
        
//        createWall(05.80, 1.00, 05.80, -1.00, false, 1003);
//		createWall(07.10, 1.00, 07.10, -1.00, false, 1004);
        
        createWall(07.10, 1.00, 09.72, 1.00, false, 3);
        createWall(09.72, 1.00, 11.02, 1.00, true, 103);
        
//        createWall(09.72, 1.00, 09.72, -1.00, false, 1005);
//		createWall(11.02, 1.00, 11.02, -1.00, false, 1006);
        
        createWall(11.02, 1.00, 13.64, 1.00, false, 4);
        createWall(13.54, 1.00, 14.94, 1.00, true, 104);
        
//        createWall(13.54, 1.00, 13.54, -1.00, false, 1007);
//		createWall(14.94, 1.00, 14.94, -1.00, false, 1008);
        
        createWall(14.94, 1.00, 17.56, 1.00, false, 5);
        createWall(17.56, 1.00, 18.86, 1.00, true, 105);
        
//        createWall(17.56, 1.00, 17.56, -1.00, false, 1009);
//		createWall(18.86, 1.00, 18.86, -1.00, false, 1010);
        
        createWall(18.86, 1.00, 21.48, 1.00, false, 6 );
        createWall(21.48, 1.00, 22.78, 1.00, true, 106);
        
//        createWall(21.48, 1.00, 21.48, -1.00, false, 1011);
//		createWall(22.78, 1.00, 22.78, -1.00, false, 1012);
        
        createWall(22.78, 1.00, 24.31, 1.00, false, 7 );
        
        createWall(24.31, 1.00, 24.31, 3.30, false, 10);
        
        createWall(00.35, 3.30, 01.88, 3.30, false, 21); 
		createWall(01.88, 3.30, 03.18, 3.30, false, 201);
        createWall(03.18, 3.30, 05.80, 3.30, false, 22);
        createWall(05.80, 3.30, 07.10, 3.30, false, 202);
        createWall(07.10, 3.30, 09.72, 3.30, false, 23);
        createWall(09.72, 3.30, 11.02, 3.30, false, 203);
        createWall(11.02, 3.30, 13.64, 3.30, false, 24);
        createWall(13.54, 3.30, 14.94, 3.30, false, 204);
        createWall(14.94, 3.30, 17.56, 3.30, false, 25);
        createWall(17.56, 3.30, 18.86, 3.30, false, 205);
        createWall(18.86, 3.30, 21.48, 3.30, false, 26 );
        createWall(21.48, 3.30, 22.78, 3.30, false, 206);
        createWall(22.78, 3.30, 24.31, 3.30, false, 27 );
        
        

        
//        Wall w5 = this.createWall(00.35, 3.30, 01.88, 3.30, false, 5);
//        Wall w6 = this.createWall(03.18, 3.30, 05.80, 3.30, false, 6);
//        Wall w7 = this.createWall(07.10, 3.30, 09.72, 3.30, false, 7);
//        Wall w8 = this.createWall(11.02, 3.30, 13.64, 3.30, false, 8);
//        
//        Wall w9 = this.createWall(00.35, 1.00, 00.35, 3.30, false, 9);
//        Wall w10 = this.createWall(14.94, 1.00, 16.47, 1.00, false, 10);
//        Wall w11 = this.createWall(14.94, 3.30, 16.47, 3.30, false, 11);
//        Wall w11 = this.createWall(00.35, 1.00, 00.35, 3.30, false, 11);
//        Wall w12 = this.createWall(11.02, 3.30, 12.55, 3.30, false, 12);
//        Wall w13 = this.createWall(00.35, 1.00, 00.35, 3.30, false, 13);
        
//        Wall w00= this.createWall(12.55, 3.30, 999.0, 3.30, false, 10);
//        Wall w01= this.createWall(12.55, 1.00, 999.9, 1.00, false, 11);
        
        
//        Wall d2 = this.createWall(01.88, 3.30, 03.18, 3.30, false, 102);
//        Wall d4 = this.createWall(05.80, 3.30, 07.10, 3.30, false, 104);
//        Wall d5 = this.createWall(09.72, 1.00, 11.02, 1.00, true, 105);
	}
   	
   	public Map<Integer, Wall> getWalls() {
   		return walls;
   	}
   	
   	public void createWall(double xFrom, double yFrom, double xTo, double yTo, boolean door, int id){
   		
   		Wall w = new Wall( xFrom, yFrom+3, xTo, yTo+3, door, id);
   		this.walls.put(id, w);
//   		return w;
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
			if(!w.isDoor() && w.getId()<900){
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
