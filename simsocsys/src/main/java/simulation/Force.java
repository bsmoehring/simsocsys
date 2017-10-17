package simulation;

public class Force {
	
	double fx;
	double fy;
	
	public Force(double fx, double fy){
		
		this.fx=fx;
		this.fy=fy;
	}
	
	public Force(){
		
		this.fx=0;
		this.fy=0;
	}
	
	public double getFx(){
		
		return this.fx;
		
	}
	
	public double getFy(){
		
		return this.fy;
		
	}
	
	public void setFx(double fx){
		
		this.fx = fx;
		
	}
	
	public void setFy(double fy){
		
		this.fy = fy;
		
	}

}
