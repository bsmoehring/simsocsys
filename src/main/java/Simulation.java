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


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by laemmel on 24/04/16.
 */
public class Simulation {
	private static final String FILENAME = "D:/Wichtiges/TUBerlin/SS17/SimulationSozialerSysteme/output/output1.csv";
	
    public static final double SCALE = 70;

    public static final double H = 0.01;
    
    public static final double A = 2000;
    public static final double B = 0.08;
    public static final double K = 120000;
    public static final double KAPPA = 240000;
	
    public static final double SPEED = 1.25;
    public static double waitingSpeed = 0.1;
    
    public static double viewR;
    
	public static double trainMinX;
	public static double trainMaxX;
	public static double trainMinY;
	public static double trainMaxY;
	
//    private static Vis vis;
    private static List<Vehicle> vehs;
    public static Network net;
    public static Walls walls;
    public boolean doorsOpen = false;
    
    public static double time = 0;

    public Simulation(Network net, Walls walls) {
    	Simulation.walls = walls;
        Simulation.net = net;
//    	this.vis = new Vis(net, walls);
    	Simulation.vehs = new ArrayList<>();
        
    }

    public static void main(String[] args) throws IOException {

        Network net = new Network();
        
        FileWriter fw = null;
        BufferedWriter bw = null;
        
		fw = new FileWriter(FILENAME);
	    bw = new BufferedWriter(fw);
	    bw.write("Run;" + "waitingSpeed;" + "pEnter;" + "pLeave;" + "DoorsOpening;" 
	    		+ "FirstLeaving;" + "LastLeaving;" + "LeaveTime;" + "Sec/Pers;" 
	    		+ "FirstEntering;" + "LastEntering;" + "EnterTime;" + "Sec/Pers;");
//		bw.write("Radius;"+"Länge;"+"Vehs;");
        
	    int run = 1;
        int pLeave = 34;
        int pEnter = 34;
        
        for (int j = 1 ; j<=10 ; j++){
//        	pLeave ++;
//        	pEnter ++;
        	Simulation.viewR = 3.0;
        	Simulation.waitingSpeed = 0.05 + 0.05*j; 
	        for (run = 1; run <= 5; run++){
        	
//	        	Simulation.viewR += 0.1;
//    			pLeave += 2;
        	
	            Walls walls = new Walls();
	            walls.getBoundaries();
		        Simulation sim = new Simulation(net, walls);
		        Dijkstra dijkstra = new Dijkstra();
		        		
		    	for (int i = 1 ; i <= pLeave; i++){
		        	double xFrom = Math.random()*(0.9*Simulation.trainMaxX-Simulation.trainMinX)+1.1*Simulation.trainMinX;
//		        	double xFrom = Math.random()*(0.9*8-Simulation.trainMinX)+1.1*Simulation.trainMinX;
		        	double yFrom = Math.random()*(0.9*Simulation.trainMaxY-Simulation.trainMinY)+1.1*Simulation.trainMinY;
//		        	Vehicle v = new Vehicle(xFrom, yFrom, dijkstra.findRoute(xFrom, yFrom, net.getNodes().get(10)), i, true);
		        	Vehicle v = new Vehicle(xFrom, yFrom, dijkstra.findRoute(xFrom, yFrom, true), i, true);
		        	v.setIsInside(true);
		        	sim.add(v);
		        }
		        for (int i = 1 ; i <= pEnter; i++){
		        	double xFrom = Math.random()*(0.9*Simulation.trainMaxX-Simulation.trainMinX)+1.1*Simulation.trainMinX;
//		        	double xFrom = Math.random()*(0.9*8-Simulation.trainMinX)+1.1*Simulation.trainMinX;
		        	double yFrom = Math.random()*(0.9*Simulation.trainMinY);
//		        	Vehicle v = new Vehicle(xFrom, yFrom, dijkstra.findRoute(xFrom, yFrom, net.getNodes().get(14)), 1000+i, false);
		        	Vehicle v = new Vehicle(xFrom, yFrom, dijkstra.findRoute(xFrom, yFrom, false), 1000+i, false);
		        	v.setIsInside(false);
		        	sim.add(v);
		        }
		        
		        String result = sim.run(run, pEnter, pLeave);
		        System.out.println(result);
		        
		        bw.newLine();
		        bw.write(result);
	        }
//	        bw.flush();
    	}
        
        bw.close();
        fw.close();
        
        System.out.println("output written to: " + FILENAME);
        
    }

	private String run(int run, int pEnter, int pLeave) {
    	
    	double time = 0;
        double maxTime = 100;
        Count count = new Count(run, pEnter, pLeave);
        
        while (time < maxTime) {
        	
        	if (time > 10 && !doorsOpen) {
        		for (Wall w : Simulation.walls.getWalls().values()){
        			if (w.isDoor()){
        				w.setOpen(true);
        			}
    			}
    			this.doorsOpen = true;
    			count.setDoorsOpeningTime(time);
    			System.out.println("doors open at: " + time);
        	} 	        	
        	
//        	for (Vehicle v : Simulation.vehs){
//        		if(!v.isLeaving()){
//        			v.checkFreePath(vehs);
//        		}
//        	}
        	
            for (Vehicle v : Simulation.vehs) {
                v.update(Simulation.vehs);
            }
            count.checkPositions(Simulation.vehs, time);
            
            Iterator<Vehicle> it = Simulation.vehs.iterator();
            while (it.hasNext()) {
                Vehicle v = it.next();
                if(!v.move()){
                	it.remove();
                	System.out.println(vehs.size());
                }
            }
            
            if (vehs.size() == 0){
            	String result = count.getResult();
            	return result;
            }

            //
            List<VehicleInfo> vInfos = new ArrayList<>();
            for (Vehicle v : Simulation.vehs) {
                VehicleInfo vi = new VehicleInfo(v.getX(), v.getY(), v.getR(), v.getId(), v.getViewX(), v.getViewY(), v.getViewR(), v.isLeaving());
                vInfos.add(vi);
            }
//            this.vis.update(time, vInfos);

            time += H;
            this.time = time;

            try {
                Thread.sleep((long) (H * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        return count.getResult();
        
        return "Simulation failed... Time is over without all agents reaching their destination.";
    }

    private void add(Vehicle v1) {
        Simulation.vehs.add(v1);
    }
}
