package simulation;

public class Wall {
	
	private final int id;
	private final double xFrom;
	private final double yFrom;
	private final double xTo;
	private final double yTo;
	private final boolean door;
	private boolean open = false;
	
	public Wall(double xFrom, double yFrom, double xTo, double yTo, boolean door, int id){
		this.xFrom=xFrom;
		this.yFrom=yFrom;
		this.xTo=xTo;
		this.yTo=yTo;
		this.id=id;
		this.door=door;
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

	public boolean isDoor() {
		return door;
	}
	
	public boolean isOpen(){
		return open;
	}
	
	public void setOpen(boolean o){
		this.open = o;
	}

	

}
