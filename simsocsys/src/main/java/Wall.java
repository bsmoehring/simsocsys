
public class Wall {
	
	private final int id;
	private final double xFrom;
	private final double yFrom;
	private final double xTo;
	private final double yTo;
	
	public Wall(double xFrom, double yFrom, double xTo, double yTo, int id){
		this.xFrom=xFrom;
		this.yFrom=yFrom;
		this.xTo=xTo;
		this.yTo=yTo;
		this.id=id;
	}
	
	public double getxFrom() {
		return xFrom;
	}
	public double getxTo() {
		return xTo;
	}
	public double getyFrom() {
		return yFrom;
	}
	public double getyTo() {
		return yTo;
	}

	public int getId() {
		return id;
	}

	

}
