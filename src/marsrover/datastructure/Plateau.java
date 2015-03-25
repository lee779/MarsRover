package marsrover.datastructure;

/**
 * Describes Plateau world in xCoordinate and yCoordinate
 * @author Amy Lee
 *
 */
public class Plateau {
	private int xCoordinate;
	private int yCoordinate;
	
	public Plateau(int xCoord, int yCoord) {
		xCoordinate = xCoord;
		yCoordinate = yCoord;
	}
	
	public int getXcoordinate() {
		return xCoordinate;
	}
	
	public void setXcoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	
	public int getYcoordinate() {
		return yCoordinate;
	}
	
	public void setYcoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
}
