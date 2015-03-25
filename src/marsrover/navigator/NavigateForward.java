package marsrover.navigator;

import marsrover.datastructure.Location;

/**
 * executes the forward movement of the rover. implements {@code marsrover.navigator.INavigator}
 * @author Amy Lee
 *
 */
public class NavigateForward implements INavigator{

	/**
	 * executes when {@link marsrover.datastructure.Instruction} = {@code Instruction.MOVE}, sets the orientation depending on its initial orientation.
	 */
	public void execute(Location location) {
		switch(location.getOrientation()){
		case NORTH:
			location.setYpos(location.getYpos()+1);
			break;
		case SOUTH:
			location.setYpos(location.getYpos()-1);
			break;
		case EAST:
			location.setXpos(location.getXpos()+1);
			break;
		case WEST:
			location.setXpos(location.getXpos()-1);
			break;
		}
	}
}
