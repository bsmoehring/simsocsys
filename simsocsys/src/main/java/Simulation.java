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
        this.vis = new Vis(net, walls);
    }

    public static void main(String[] args) {

        Network net = new Network();
        Node n1 = net.createNode(02.53, 01.00, 1);
        Node n2 = net.createNode(02.53, 01.50, 2);
        Node n3 = net.createNode(01.88, 02.15, 3);
        Node n4 = net.createNode(02.53, 02.80, 4);
        Node n5 = net.createNode(02.53, 03.30, 5);
        Node n6 = net.createNode(03.18, 02.15, 6);
        Node n7 = net.createNode(02.53, -9.00, 7);
        Node n8 = net.createNode(01.00, 02.15, 8);
        Node n9 = net.createNode(04.06, 02.15, 9);
        
        Node n11 = net.createNode(06.45, 01.00, 11);
        Node n12 = net.createNode(06.45, 01.50, 12);
        Node n13 = net.createNode(05.80, 02.15, 13);
        Node n14 = net.createNode(06.45, 02.80, 14);
        Node n15 = net.createNode(06.45, 03.30, 15);
        Node n16 = net.createNode(07.10, 02.15, 16);
        Node n17 = net.createNode(06.45, -9.00, 17);
        Node n18 = net.createNode(04.95, 02.15, 18);
        Node n19 = net.createNode(07.88, 02.15, 19);
      
        Link l0 	= net.createLink(n1, n7, 1, 0);
        Link l0_rev = net.createLink(n7, n1, 2, 0);
        Link l1 	= net.createLink(n1, n2, 3, 1);
        Link l1_rev = net.createLink(n2, n1, 4, 1);
        Link l2 	= net.createLink(n2, n3, 5, 1);
        Link l2_rev = net.createLink(n3, n2, 6, 1);
        Link l3 	= net.createLink(n2, n6, 7, 1);
        Link l3_rev = net.createLink(n6, n2, 8, 1);
        Link l4 	= net.createLink(n2, n4, 9, 1);
        Link l4_rev = net.createLink(n4 ,n2, 10, 1);
        Link l5 	= net.createLink(n4, n6, 11, 1);
        Link l5_rev = net.createLink(n6 ,n4, 12, 1);
        Link l6 	= net.createLink(n4, n5, 13, 1);
        Link l6_rev = net.createLink(n5 ,n4, 14, 1);
        Link l7 	= net.createLink(n3, n6, 15, 1);
        Link l7_rev = net.createLink(n6 ,n3, 16, 1);
        Link l8 	= net.createLink(n3, n4, 17, 1);
        Link l8_rev = net.createLink(n4 ,n3, 18, 1);
        Link l9 	= net.createLink(n3, n8, 17, 1);
        Link l9_rev = net.createLink(n8 ,n3, 18, 1);
        Link l91 	= net.createLink(n6, n9, 17, 1);
        Link l91_rev= net.createLink(n9 ,n6, 18, 1);
        Link l92 	= net.createLink(n9, n18, 17, 1);
        Link l92_rev= net.createLink(n18 ,n9, 18, 1);
        
        
        Link l10 		= net.createLink(n11, n17, 1, 0);
        Link l10_rev 	= net.createLink(n17, n11, 2, 0);
        Link l11 		= net.createLink(n11, n12, 3, 1);
        Link l11_rev	= net.createLink(n12, n11, 4, 1);
        Link l12 		= net.createLink(n12, n13, 5, 1);
        Link l12_rev	= net.createLink(n13, n12, 6, 1);
        Link l13 		= net.createLink(n12, n16, 7, 1);
        Link l13_rev	= net.createLink(n16, n12, 8, 1);
        Link l14 		= net.createLink(n12, n14, 9, 1);
        Link l14_rev	= net.createLink(n14 ,n12, 10, 1);
        Link l15 		= net.createLink(n14, n16, 11, 1);
        Link l15_rev	= net.createLink(n16 ,n14, 12, 1);
        Link l16 		= net.createLink(n14, n15, 13, 1);
        Link l16_rev	= net.createLink(n15 ,n14, 14, 1);
        Link l17 		= net.createLink(n13, n16, 15, 1);
        Link l17_rev	= net.createLink(n16 ,n13, 16, 1);
        Link l18 		= net.createLink(n13, n14, 17, 1);
        Link l18_rev	= net.createLink(n14 ,n13, 18, 1);
        Link l19 		= net.createLink(n13, n18, 17, 1);
        Link l19_rev 	= net.createLink(n18 ,n13, 18, 1);
        Link l191 		= net.createLink(n16, n19, 17, 1);
        Link l191_rev	= net.createLink(n19 ,n16, 18, 1);
//        Link l192 		= net.createLink(n19, n28, 17, 1);
//        Link l192_rev	= net.createLink(n28 ,n19, 18, 1);
        
        
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
       
        
        Dijkstra dijkstra = new Dijkstra(net.getNodes());
        List<Link> route3 = dijkstra.findRoute(n2, n7);
        List<Link> route4 = dijkstra.findRoute(n6, n7);

        Simulation sim = new Simulation(net, walls);
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
            for (Vehicle v : this.vehs) {
                v.move();
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
