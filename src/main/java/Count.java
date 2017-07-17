import java.util.List;

import processing.core.PVector;

public class Count {
	
	private int run;
	private int pEnter = 0;
	private int pLeave = 0;
	
	private double doorsOpeningTime;
	private double doorsClosingTime;
	private double pLeft = 0;
	private double pEntered = 0;
	private double firstLeavingTime;
	private double lastLeavingTime;
	private double firstEnteringTime;
	private double lastEnteringTime;
	
	private double speed;
	
	public Count(int run, int pEnter, int pLeave, double speed){
		this.run = run;
		this.pEnter = pEnter;
		this. pLeave = pLeave;
		this.speed = speed;
	}
	
	public int getRun(){
		return this.run;
	}
	
	public int getPEnter() {
		return pEnter;
	}
	public int getPLeave() {
		return pLeave;
	}	
	public void setDoorsOpeningTime(double time){
		this.doorsOpeningTime = time;
	}
	public double getDoorsOpeningTime(){
		return this.doorsOpeningTime;
	}
	public double getDoorsClosingTime(){
		return this.doorsClosingTime;
	}
	public void setDoorsClosingTime(double time){
		this.doorsClosingTime = time;
	}
	public void checkPositions(List<Vehicle> vehs, double time) {

		for (Vehicle v : vehs){
			boolean isInside = checkInside(v);
			boolean wasInside = v.isInside();
			if(isInside == wasInside){
				// vehicle is where it was before -> same position
				
			} else if (isInside && !wasInside){
				// vehicle is inside but was outside -> entered
				v.setIsInside(true);
				this.pEntered ++;
				if (pEntered == 1){
					this.firstEnteringTime = time;
				} else if (pEntered == pEnter){
					this.lastEnteringTime = time;
				}
//				System.out.println(time + " " + v.getId() + " entered.");
			} else if (!isInside && wasInside){
				// vehicle is outside but was inside -> left
				v.setIsInside(false);
				this.pLeft++;
				if (pLeft == 1){
					this.firstLeavingTime = time;
				} else if (pLeft == pLeave){
					this.lastLeavingTime = time;
				}
//				System.out.println(time + " " + v.getId() + " left.");
			}
		}

		
//		if (Counts.pLeft >= Counts.leaving){
//			for (Vehicle v : vehs){
//				v.setWaiting(false);
//			}
//			
//		}
	}
	
	private boolean checkInside(Vehicle v) {
		
		if (v.getX() > Simulation.trainMinX && v.getX() < Simulation.trainMaxX && 
				v.getY() > Simulation.trainMinY && v.getX() < Simulation.trainMaxX){
			
			return true;
			
		} else {
			return false;
		}
	}
	
	public boolean allDestinationsReached(){
		return false;
	}

	public String getResult() {
		double leavingTime = (lastLeavingTime-firstLeavingTime);
		double enteringTime = (lastEnteringTime - firstEnteringTime);
		String result = getRun() + ";" + getPEnter() + ";" + getPLeave() + ";" + this.speed + ";" + getDoorsOpeningTime() + ";" 
				+ firstLeavingTime + ";" + lastLeavingTime + ";" + leavingTime + ";" + (leavingTime/pLeave) + ";" +  
				+ firstEnteringTime + ";" + lastEnteringTime + ";" + enteringTime + ";" + (enteringTime/pEnter) + ";";
		return result;
	}
//	public String getResult(){
//		String result = Double.toString(this.maxX);
//		return result;
//	}

}
