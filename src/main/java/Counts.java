import java.util.List;

import processing.core.PVector;

public class Counts {
	
	static int entering;
	static int leaving;
	
	private static double doorsOpeningTime;
	private static double doorsClosingTime;
	private static double pLeft;
	private static double pEntered;

	
	public int getEntering() {
		return entering;
	}
	public void setEntering(int entering) {
		Counts.entering = entering;
	}
	public int getLeaving() {
		return leaving;
	}
	public void setLeaving(int leaving) {
		Counts.leaving = leaving;
	}
	
	public static void setDoorsOpeningTime(double time){
		doorsOpeningTime = time;
	}
	
	public static void setDoorsClosingTime(double time){
		doorsClosingTime = time;
	}
	public static void checkPositions(List<Vehicle> vehs, double time) {
		
		for (Vehicle v : vehs){
			boolean isInside = checkInside(v);
			boolean wasInside = v.isInside();
			if(isInside == wasInside){
				// vehicle is where it was before -> same position
				
			} else if (isInside && !wasInside){
				// vehicle is inside but was outside -> entered
				v.setIsInside(true);
				Counts.pEntered ++;
				System.out.println(time + " " + v.getId() + " entered.");
			} else if (!isInside && wasInside){
				// vehicle is outside but was inside -> left
				v.setIsInside(false);
				Counts.pLeft++;
				System.out.println(time + " " + v.getId() + " left.");
			}
		}
		if (Counts.pLeft >= Counts.leaving){
			for (Vehicle v : vehs){
				v.setWaiting(false);
			}
			
		}
	}
	
	public static boolean checkInside(Vehicle v) {
		
		if (v.getX() > Simulation.trainMinX && v.getX() < Simulation.trainMaxX && 
				v.getY() > Simulation.trainMinY && v.getX() < Simulation.trainMaxX){
			
			return true;
			
		} else {
			return false;
		}
	}

}
