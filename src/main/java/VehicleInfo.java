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


import processing.core.PApplet;
import processing.core.PConstants;



/**
 * Created by laemmel on 24/04/16.
 */
public class VehicleInfo {

	private final int id;
	
    private final int x;
    private final int y;    

    private final int viewX;
    private final int viewY;  
    private final int viewR;
    
    private final boolean leaving;
    
    private final int r;

    public VehicleInfo(double x, double y, double r, int id, double viewX, double viewY, double viewR, boolean leaving) {
        this.x = (int) (Simulation.SCALE * x);
        this.y = (int) (Simulation.SCALE * y);
        this.viewX = (int) (Simulation.SCALE * viewX);
        this.viewY = (int) (Simulation.SCALE * viewY);
        this.viewR = (int) (Simulation.SCALE * viewR);
        this.leaving = leaving;
        
        this.id = id;

        this.r = (int) (Simulation.SCALE * r);
    }

    public void draw(PApplet p) {
        
        
//        p.pushMatrix();
//        p.translate(viewX, viewY);
//        p.fill((float)(255), (float)(255), (float)(255), (float)(0));
//        p.ellipse(0, 0, this.viewR*2, this.viewR*2);
//        p.popMatrix();
    	
    	p.pushMatrix();
        p.translate(x, y);
        if(this.leaving){
        	p.fill(0,0,255);
        } else {
        	p.fill(255, 0, 0);
        }
        p.ellipse(0, 0, this.r, this.r);
        p.popMatrix();


    }
}
