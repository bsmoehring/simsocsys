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

    private final Vis vis;
    private static List<Vehicle> vehs = new ArrayList<>();
    public static Network net;
    public static Walls walls;

    public Simulation(Network net, Walls walls) {
    	Simulation.walls = walls;
        Simulation.net = net;
    	this.vis = new Vis(net, walls);
        
    }

    public static void main(String[] args) {
    	
    	int pLeave = 1;
    	int pEnter = 1;

        Network net = new Network();
              
        
//        Node n0 = net.createNode(1,1,1);
//        Node n1 = net.createNode(7,1,2);
//        Node n2 = net.createNode(7,3,3);
//        Node n3 = net.createNode(2,3,4);
//        Node n4 = net.createNode(1,5,5);
//        Node n5 = net.createNode(7,5,6);
//        Link l0 	= net.createLink(n0, n1, 1, 1);
//        Link l0_rev = net.createLink(n1, n0, 2, 1);
//        Link l1 	= net.createLink(n1, n2, 3, 1);
//        Link l1_rev = net.createLink(n2, n1, 4, 1);
//        Link l2 	= net.createLink(n2, n3, 5, 1);
//        Link l2_rev = net.createLink(n3, n2, 6, 1);
//        Link l3 	= net.createLink(n3, n4, 7, 1);
//        Link l3_rev = net.createLink(n4, n3, 8, 1);
//        Link l4 	= net.createLink(n4, n5, 9, 1);
//        Link l4_rev = net.createLink(n5 ,n4, 10, 1);
//        Link l5 	= net.createLink(n0, n3, 11, 1);
//        Link l5_rev = net.createLink(n3 ,n0, 12, 1);
//        List<Link> route = new ArrayList<>();
//        route.add(l0);
//        route.add(l1);
//        route.add(l2);
//        route.add(l3);
//        route.add(l4);
//        route.add(l2);
//        List<Link> route2 = new ArrayList<>();
        
        Walls walls = new Walls();
        Wall w1 = walls.createWall(00.35, 1.00, 01.88, 1.00, 1);
        Wall w2 = walls.createWall(03.18, 1.00, 05.80, 1.00, 2);
        Wall w3 = walls.createWall(07.10, 1.00, 09.72, 1.00, 3);
        Wall w4 = walls.createWall(11.02, 1.00, 12.55, 1.00, 4);
        Wall w5 = walls.createWall(00.35, 3.30, 01.88, 3.30, 5);
        Wall w6 = walls.createWall(03.18, 3.30, 05.80, 3.30, 6);
        Wall w7 = walls.createWall(07.10, 3.30, 09.72, 3.30, 7);
        Wall w8 = walls.createWall(11.02, 3.30, 12.55, 3.30, 8);
        
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
        List<Link> route3 = dijkstra.findRoute(02.53, 01.50, net.getNodes().get(7)); 
        List<Link> route4 = dijkstra.findRoute(03.18, 02.15, net.getNodes().get(7));

        
        Vehicle v1 = new Vehicle(0, 2.15, route3, 1);
        Vehicle v2 = new Vehicle(4, 2.15, route4, 2);
        sim.add(v1);
        sim.add(v2);
        sim.run();

    }

    private void run() {
        double time = 0;

        double maxTime = 1000;
        while (time < maxTime) {
            for (Vehicle v : this.vehs) {
                v.update(this.vehs);
            }
            Iterator<Vehicle> it = this.vehs.iterator();
            while (it.hasNext()) {
                Vehicle v = it.next();
                if(!v.move()){
                	it.remove();
                }
            }

            //
            List<VehicleInfo> vInfos = new ArrayList<>();
            for (Vehicle v : this.vehs) {
                VehicleInfo vi = new VehicleInfo(v.getX(), v.getY(), v.getPhi(), v.getLength(), v.getWidth());
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
        this.vehs.add(v1);
    }
}
