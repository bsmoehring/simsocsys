
public class Counts {
	
	private static int entering;
	private static int leaving;
	
	private static double doorsOpeningTime;
	private static double doorsClosingTime;
	private static double allPLeft;
	private static double allPEntered;

	
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
	public static void checkEnterLeave(Vehicle v) {
		
//		if(v.getX())
		
	}

}
