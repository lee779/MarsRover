package marsrover.datastructure;

/**
 * Describes the location of Rover: xpos, ypos and {@code marsrover.datastructure.Orientation}
 * @author Amy Lee
 *
 */
public class Location {
	private int xPos;
	private int yPos;
	private Orientation orientation;
	
	public Location (int xpos, int ypos, Orientation orientation) {
		this.setXpos(xpos);
		this.setYpos(ypos);
		this.setOrientation(orientation);
	}

	public Orientation getOrientation() {
		return orientation;
	} 

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public int getXpos() {
		return xPos;
	}

	public void setXpos(int xPos) {
		this.xPos = xPos;
	}

	public int getYpos() {
		return yPos;
	}

	public void setYpos(int yPos) {
		this.yPos = yPos;
	}
}
