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
    
    private final int r;

    public VehicleInfo(double x, double y, double r, int id, double viewX, double viewY, double viewR) {
        this.x = (int) (Simulation.SCALE * x);
        this.y = (int) (Simulation.SCALE * y);
        this.viewX = (int) (Simulation.SCALE * viewX);
        this.viewY = (int) (Simulation.SCALE * viewY);
        this.viewR = (int) (Simulation.SCALE * viewR);
        
        this.id = id;

        this.r = (int) (Simulation.SCALE * r);
    }

    public void draw(PApplet p) {
        p.pushMatrix();
        
        p.pushMatrix();
        p.translate(viewX, viewY);
        p.fill(255, 255, 255);
        p.ellipse(0, 0, this.viewR, this.viewR);
        p.popMatrix();
        
        p.translate(x, y);
        p.fill(0, 0, 255);
        p.ellipse(0, 0, this.r, this.r);
        p.popMatrix();


    }
}
