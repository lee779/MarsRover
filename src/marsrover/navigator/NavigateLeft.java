package marsrover.navigator;


import marsrover.datastructure.Location;
import marsrover.datastructure.Orientation;

/**
 * executes the face left movement of the rover. implements {@code marsrover.navigator.INavigator}
 * @author Amy Lee
 *
 */
public class NavigateLeft implements INavigator{

	/**
	 * executes when {@link marsrover.datastructure.Instruction} = {@code Instruction.LEFT}, sets the orientation depending on its initial orientation.
	 */
	@Override
	public void execute(Location location) {
		switch(location.getOrientation()){
		case NORTH:
			location.setOrientation(Orientation.WEST);
			break;
		case SOUTH:
			location.setOrientation(Orientation.EAST);
			break;
		case EAST:
			location.setOrientation(Orientation.NORTH);
			break;
		case WEST:
			location.setOrientation(Orientation.SOUTH);
			break;
		}
	}
}
