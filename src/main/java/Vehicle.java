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


import java.util.List;

import processing.core.PVector;

/**
 * Created by laemmel on 18/04/16.
 */
public class Vehicle extends HasCoords{


    private List<Link> route;
    private final int id;
    private double vx = 0;
    private double vy = 0;
    private double speed = 1.34;
    private double maxSpeed = 2.0;
    private double tau = 0.5;
    private double weight = 80.0;
    private boolean isInside;
    private boolean leaving;

	//    abstoﬂende Kr‰fte
    private double r = 0.3;

	private double x;
    private double y;
    private double phi = 0;//radian!!
    
    private double viewX;
    private double viewY ;

    private int routeIndex = 0;

    public Vehicle(double x, double y, List<Link> route, int id) {
        this.id = id;
    	this.x = x;
        this.y = y;
        this.route = route;
    }

    public void update(List<Vehicle> vehs) {
    	
    	double dx = 0;
    	double dy = 0;
    	
//    	if (this.waiting){
//    		this.speed = 0.1;
//    	} else {
//    		this.speed = 1.34;
//    	}
    	
    	if (route != null){
	    	
	    	Link currentLink;
	    	currentLink = route.get(this.routeIndex);
	
	        dx = currentLink.getTo().getX() - this.x;
	        dy = currentLink.getTo().getY() - this.y;
	
	        double dist = Math.sqrt(dx*dx+dy*dy);
	        dx /= dist;
	        dy /= dist;
	        
	        if (this.leaving || freePath(vehs, dx, dy)){
	        	this.speed = 1.34;
	        } else {
	        	this.speed = 0.1;
	        }
	        
	        dx *= this.speed;
	        dy *= this.speed;
	        
	        dx -= vx;
	        dy -= vy;
    	}
        
        PVector repellingForceAgents = repellingForceAgents(vehs);
        PVector repellingForceWalls = repellingForceWalls();
        
        double fx = (this.weight * dx / this.tau) + repellingForceAgents.x + repellingForceWalls.x;
        double fy = (this.weight * dy / this.tau) + repellingForceAgents.y + repellingForceWalls.y;

        fx /= this.weight;
        fy /= this.weight;
        
        this.vx += fx * Simulation.H;
        this.vy += fy * Simulation.H;

        //TODO: geschwindigkeit limitieren
    	double s = Math.sqrt(this.vx*this.vx+this.vy*this.vy);
        if(s >this.maxSpeed){
    		double v = Math.abs(this.vx)+Math.abs(this.vy);
    		this.vx = (this.vx/v)*this.maxSpeed;
    		this.vy = (this.vy/v)*this.maxSpeed;
    	}
    
        this.phi = Math.atan2(this.vy,this.vx);

    }
    
    private boolean freePath(List<Vehicle> vehs, double dx, double dy) {
		
    	dx += this.x;
    	dy += this.y;
    	
    	HasCoords p = new HasCoords();
    	p.setX(dx);
    	p.setY(dy);
    	
    	for (Vehicle v : vehs){
    		if(v.leaving && pointDistance(v ,p)<2*v.getR()){
    			return false;
    		}
    	}
    	
		return true;
	}

	public PVector repellingForceAgents(List<Vehicle> vehs){
    	
    	double fx = 0;
    	double fy = 0;
    	
    	for(Vehicle veh : vehs){
    		
    		if ( veh != this){
    			    			
    			double dist =  pointDistance(veh, this);
    			double distR = (this.r + veh.r - dist);
    			
    			double f = Simulation.A * Math.pow(Math.E, (distR/Simulation.B));

    			if (this.r + veh.r >= dist)	{
    				
    				f = f + Simulation.K * distR;
    				
    			}
    			
    	        double dx = (this.x - veh.getX())/dist;
    	        double dy = (this.y - veh.getY())/dist;
    	        
    			fx += dx*f;
    			fy += dy*f;
    			
    			if (this.r + veh.r >= dist)	{
    				
    				double nx = this.x - veh.getX();
    				double ny = this.y - veh.getY();
    				double tx = -ny;
    				double ty = nx;
    				
    				double dvx = (veh.getVX()-this.vx)*tx;
    				double dvy = (veh.getVY()-this.vy)*ty;
    				
    				fx += Simulation.KAPPA * distR * dvx;
    				fy += Simulation.KAPPA * distR * dvy;
    				
    			}
    			
    		} 
    		
    	}
    	
    	PVector force = new PVector((float)(fx), (float)(fy));
    	
    	return force;
    	
    }
    
    public double pointDistance(HasCoords v1, HasCoords v2){
    	
        double dx = v1.getX() - v2.getX();
        double dy = v1.getY() - v2.getY();

        double dist = Math.sqrt(dx*dx+dy*dy);
    	
    	return dist;
    	
    }
    
    public PVector repellingForceWalls(){
    	
    	PVector force 	= new PVector(0, 0);
    	
    	PVector veh 	= new PVector((float)this.x, (float) this.y);
    	
    	for(Wall wall : Simulation.walls.getWalls().values()){
    		
    		if (!wall.isDoor() || !wall.isOpen()){
	    		
	    		PVector wFrom 	= new PVector((float)wall.getxFrom(), (float) wall.getyFrom());
	    		PVector wTo 	= new PVector((float)wall.getxTo(), (float) wall.getyTo());
	    		PVector closest = new PVector();    		
	    		
				float vx = veh.x-wFrom.x; 
				float vy = veh.y-wFrom.y;   // v = wFrom->veh
				float ux = wTo.x-wFrom.x;
				float uy = wTo.y-wFrom.y;   // u = wFrom->wTo
				float det = vx*ux + vy*uy; 
				float len = ux*ux + uy*uy;    // len = u^2
				
				boolean endpoint = false;
				if (det <= 0){ 	// its outside the line segment near wFrom
				  closest.set(wFrom); 
				  endpoint = true;
				} else if (det >= len){ // its outside the line segment near wTo
				  closest.set(wTo);  
				  endpoint = true;
				} else {// its near line segment between wFrom and wTo
					float ex = (float) (ux / Math.sqrt(len));    	// e = u / |u^2|
					float ey = (float) (uy / Math.sqrt(len));
					float f = ex * vx + ey * vy;  					// f = e . v
					closest.set(wFrom.x + f * ex, wFrom.y + f * ey);           				// S = wFrom + f * e
				}
				double distance = Math.sqrt(Math.pow(closest.x-veh.x, 2) + Math.pow(closest.y-veh.y, 2));
//				DecimalFormat df = new DecimalFormat("#.##");
//		    	System.out.println(this.getId() + " " + wall.getId() + " " + df.format(distance) + " " + closest.x + " " + closest.y);
				double distR = this.r - distance;
				double dx = (veh.x - closest.x) / distance;
				double dy = (veh.y - closest.y) / distance;
				double f = Simulation.A * Math.pow(Math.E, (distR / Simulation.B));
				if (distance <= this.r) {
					f = f + (Simulation.K * distR);
				}
				
				PVector ff = new PVector((float)(f * dx), (float)(f * dy));
//				double fx = f * (dx);
//				double fy = f * (dy);
				if (distance <= this.r) {
					double tx = -dy;
					double ty = dx; 
					ff.add((float)(- Simulation.KAPPA * distR * this.vx * tx * tx ),
							(float)(- Simulation.KAPPA * distR * this.vy * ty * ty), 0);
				}
				if (endpoint){
					ff.div(20);
				}
				
				force.add(ff);
				
//				force.setFx(force.getFx()+fx);
//				force.setFy(force.getFy()+fy);
    		}
    	}	    	
    	
    	return force;
    }

    public boolean move() {
        this.x = this.x + Simulation.H * this.vx;
        this.y = this.y + Simulation.H * this.vy;

        if (this.route != null){
	        Link currentLink = this.route.get(this.routeIndex);
	        
	        if (currentLink.hasVehicleReachedEndOfLink(this) 
	        		//possible way to ease destination mistakes by focusing on a node in a wrong direction
	        		|| pointDistance(this.route.get(this.routeIndex).getTo(), this) < this.r
	        		) {
	            this.routeIndex++;
	            if (this.routeIndex == this.route.size() ){
	            	return false;
	            }
	        }
        }    
        return true;
    }

    public double getX() {
        return x;
    }
    
    public void setX(double x){
    	this.x = x;
    }
    
    public void setY(double y){
    	this.y = y;
    }

    public double getY() {
        return y;
    }
    
    public double getVX() {
        return vx;
    }

    public double getVY() {
        return vy;
    }

    public double getPhi() {
        return phi;
    }

	public int getId() {
		return id;
	}
    
    public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public boolean hasRoute(){
		if(this.route != null){
			return true;
		} else{
			return false;
		}
	}

	public boolean isInside() {
		return isInside;
	}
	
	public void setIsInside(boolean isInside){
		this.isInside = isInside;
	}

	public boolean isLeaving() {
		return leaving;
	}

	public void setLeaving(boolean leaving) {
		this.leaving = leaving;
	}

	public double getViewX() {
		return viewX;
	}

	public void setViewX(double viewX) {
		this.viewX = viewX;
	}

	public double getViewY() {
		return viewY;
	}

	public void setViewY(double viewY) {
		this.viewY = viewY;
	}
	
}
