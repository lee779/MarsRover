package marsrover.navigator;

import marsrover.datastructure.Location;

/**
 * manages how the Rover moves and turns
 * @author Amy Lee
 *
 */
public interface INavigator {
	/**
	 * executes a movement and updates the given Rover's location.
	 * @param location
	 */
	void execute(Location location); 
}
