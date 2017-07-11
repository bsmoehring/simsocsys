/* *********************************************************************** *
 * project: simsocsys
 *
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2016 by the members listed in the COPYING,        *
 *                   LICENSE and WARRANTY file.                            *
 * email           : gregor dot laemmel at gmail dot org                                *
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *   See also COPYING, LICENSE and WARRANTY file                           *
 *                                                                         *
 * *********************************************************************** */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by laemmel on 24/04/16.
 */
public class Simulation {

    public static final double SCALE = 100;

    public static final double H = 0.01;
    
    public static final double A = 2000;
    public static final double B = 0.08;
    public static final double K = 120000;
    public static final double KAPPA = 240000;
	
	public static double trainMinX;
	public static double trainMaxX;
	public static double trainMinY;
	public static double trainMaxY;
	
    private final Vis vis;
    private static List<Vehicle> vehs = new ArrayList<>();
    public static Network net;
    public static Walls walls;
    public boolean doorsOpen = false;

    public Simulation(Network net, Walls walls) {
    	Simulation.walls = walls;
        Simulation.net = net;
    	this.vis = new Vis(net, walls);
        
    }

    public static void main(String[] args) {
    	
    	int pLeave = 10;
    	int pEnter = 10;

        Network net = new Network();
        
        Walls walls = new Walls();
        Wall w1 = walls.createWall(00.35, 1.00, 01.88, 1.00, false, 1); 
        Wall w2 = walls.createWall(03.18, 1.00, 05.80, 1.00, false, 2);
        Wall w3 = walls.createWall(07.10, 1.00, 09.72, 1.00, false, 3);
        Wall w4 = walls.createWall(11.02, 1.00, 12.55, 1.00, false, 4);
        Wall w5 = walls.createWall(00.35, 3.30, 01.88, 3.30, false, 5);
        Wall w6 = walls.createWall(03.18, 3.30, 05.80, 3.30, false, 6);
        Wall w7 = walls.createWall(07.10, 3.30, 09.72, 3.30, false, 7);
        Wall w8 = walls.createWall(11.02, 3.30, 12.55, 3.30, false, 8);
        Wall w9 = walls.createWall(00.35, 1.00, 00.35, 3.30, false, 9);
        
        Wall d1 = walls.createWall(01.88, 1.00, 03.18, 1.00, true, 101);
        Wall d2 = walls.createWall(01.88, 3.30, 03.18, 3.30, false, 102);
        Wall d3 = walls.createWall(05.80, 1.00, 07.10, 1.00, true, 103);
        Wall d4 = walls.createWall(05.80, 3.30, 07.10, 3.30, false, 104);
        Wall d5 = walls.createWall(09.72, 1.00, 11.02, 1.00, true, 105);
        Wall d6 = walls.createWall(09.72, 3.30, 11.02, 3.30, false, 106);
        
        walls.getBoundaries();
        
//        Rooms rooms = new Rooms();
//        List<Link> roomLinks = new LinkedList<Link>();
//        List<Wall> roomWalls = new LinkedList<Wall>();
//        TODO walls and links only for specified rooms
//        for (Link link : net.getLinks().values()){
//        	roomLinks.add(link);
//        }
//        for (Wall wall : walls.getWalls().values()){
//        	roomWalls.add(wall);
//        }
//        Room room = new Room(1, roomLinks, roomWalls);
//	    rooms.addRoom(room);
       
        
        Dijkstra dijkstra = new Dijkstra();
        Simulation sim = new Simulation(net, walls);

        for (int i = 1 ; i <= pLeave; i++){
        	double xFrom = Math.random()*(0.9*Simulation.trainMaxX-Simulation.trainMinX)+1.1*Simulation.trainMinX;
        	double yFrom = Math.random()*(0.9*Simulation.trainMaxY-Simulation.trainMinY)+1.1*Simulation.trainMinY;
        	Vehicle v = new Vehicle(xFrom, yFrom, dijkstra.findRoute(xFrom, yFrom, 7), i);
        	v.setIsInside(true);
        	v.setLeaving(true);
        	Counts.leaving++;
        	sim.add(v);
        }
        for (int i = 1 ; i <= pEnter; i++){
        	double xFrom = Math.random()*(0.9*Simulation.trainMaxX-Simulation.trainMinX)+1.1*Simulation.trainMinX;
        	double yFrom = Math.random()*(0.9*Simulation.trainMinY);
        	Vehicle v = new Vehicle(xFrom, yFrom, dijkstra.findRoute(xFrom, yFrom, 8), 1000+i);
        	v.setIsInside(false);
        	v.setLeaving(false);
        	Counts.entering++;
        	sim.add(v);
        }
        
        sim.run();

    }

    private void run() {
    	
    	double time = 0;
        double maxTime = 1000;
        
        while (time < maxTime) {
        	
        	if (time > 10 && !doorsOpen) {
        		for (Wall w : Simulation.walls.getWalls().values()){
        			if (w.isDoor()){
        				w.setOpen(true);
        			}
    			}
    			this.doorsOpen = true;
    			Counts.setDoorsOpeningTime(time);
    			System.out.println("doors open at: " + time);
        	} 	        	
        	
            for (Vehicle v : Simulation.vehs) {
                v.update(Simulation.vehs);
            }
            Iterator<Vehicle> it = Simulation.vehs.iterator();
            while (it.hasNext()) {
                Vehicle v = it.next();
                if(!v.move()){
                	it.remove();
                }
            }
            
            Counts.checkPositions(Simulation.vehs, time);

            //
            List<VehicleInfo> vInfos = new ArrayList<>();
            for (Vehicle v : Simulation.vehs) {
                VehicleInfo vi = new VehicleInfo(v.getX(), v.getY(), v.getR(), v.getId(), v.getViewX(), v.getViewY());
                vInfos.add(vi);
            }
            this.vis.update(time, vInfos);

            time += H;

            try {
                Thread.sleep((long) (H * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void add(Vehicle v1) {
        Simulation.vehs.add(v1);
    }
}
