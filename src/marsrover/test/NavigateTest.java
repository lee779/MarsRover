package marsrover.test;

import static org.junit.Assert.*;
import marsrover.datastructure.Location;
import marsrover.datastructure.Orientation;
import marsrover.navigator.INavigator;
import marsrover.navigator.NavigateForward;
import marsrover.navigator.NavigateLeft;
import marsrover.navigator.NavigateRight;

import org.junit.Test;

/**
 * tests the implemented INavigator in {@code marsrover.Rover}, see {@code marsrover.navigator.INavigate} for the interface
 * @author Amy Lee
 *
 */
public class NavigateTest {

	private final INavigator FORWARD_STRATEGY = new NavigateForward();
	private final INavigator FACE_RIGHT_STRATEGY= new NavigateRight();	
	private final INavigator FACE_LEFT_STRATEGY = new NavigateLeft();
	
	private int xpos, ypos;
	private Orientation orientation;
	private Location expectedLocation;
	private Location actualLocation;

	/**
	 * tests the forwardStrategy in facing North
	 */
	@Test
	public void testExecuteForwardStrategyNorth() {
		//location @ (1,1) facing North 
		xpos = 1; ypos = 1; orientation = Orientation.NORTH;
		expectedLocation = new Location(xpos, ypos + 1, orientation);
		actualLocation = new Location(xpos, ypos, orientation);
		FORWARD_STRATEGY.execute(actualLocation);
		compareLocation(expectedLocation, actualLocation);
	}
	
	/**
	 * tests the forwardStrategy facing South
	 */
	@Test
	public void testExecuteForwardStrategySouth() {
		//location @(1,1) facing South
		xpos = 1; ypos = 1; orientation = Orientation.SOUTH;
		expectedLocation = new Location(xpos, ypos - 1, orientation);
		actualLocation = new Location(xpos, ypos, orientation);
		FORWARD_STRATEGY.execute(actualLocation);
		compareLocation(expectedLocation, actualLocation);
	}
	
	/**
	 * tests the forwardStrategy facing West
	 */
	@Test
	public void testExecuteForwardStrategyWest() {
		//location @(1,1) facing WEST
		xpos = 1; ypos = 1; orientation = Orientation.WEST;
		expectedLocation = new Location(xpos - 1, ypos, orientation);
		actualLocation = new Location(xpos, ypos, orientation);
		FORWARD_STRATEGY.execute(actualLocation);
		compareLocation(expectedLocation, actualLocation);
	}
	
	/**
	 * tests the forwardStrategy facing East
	 */
	@Test
	public void testExecuteForwardStrategyEast() {
		//location @(1,1) facing EAST
		xpos = 1; ypos = 1; orientation = Orientation.EAST;
		expectedLocation = new Location(xpos + 1, ypos, orientation);
		actualLocation = new Location(xpos, ypos, orientation);
		FORWARD_STRATEGY.execute(actualLocation);
		compareLocation(expectedLocation, actualLocation);		 
	}
	
	/**
	 * tests the rightStrategy in facing North
	 */
	@Test
	public void testExecuteRightStrategyNorth() {
		//location @ (1,1) facing North 
		xpos = 1; ypos =1; orientation = Orientation.NORTH;
		expectedLocation = new Location(xpos, ypos, Orientation.EAST);
		actualLocation = new Location(xpos, ypos, orientation);
		FACE_RIGHT_STRATEGY.execute(actualLocation);
		compareLocation(expectedLocation, actualLocation);
	}
	
	/**
	 * tests the rightStrategy facing South
	 */
	@Test
	public void testExecuteRightStrategySouth() {
		//location @(1,1) facing South
		xpos = 1; ypos = 1; orientation = Orientation.SOUTH;
		expectedLocation = new Location(xpos, ypos, Orientation.WEST);
		actualLocation = new Location(xpos, ypos, orientation);
		FACE_RIGHT_STRATEGY.execute(actualLocation);
		compareLocation(expectedLocation, actualLocation);
	}
	
	/**
	 * tests the rightStrategy facing West
	 */
	@Test
	public void testExecuteRightStrategyWest() {
		//location @(1,1) facing WEST
		xpos = 1; ypos = 1; orientation = Orientation.WEST;
		expectedLocation = new Location(xpos, ypos, Orientation.NORTH);
		actualLocation = new Location(xpos, ypos, orientation);
		FACE_RIGHT_STRATEGY.execute(actualLocation);
		compareLocation(expectedLocation, actualLocation);
	}
	
	/**
	 * tests the rightStrategy facing East
	 */
	@Test
	public void testExecuteRightStrategyEast() {
		//location @(1,1) facing EAST
		xpos = 1; ypos = 1; orientation = Orientation.EAST;
		expectedLocation = new Location(xpos, ypos, Orientation.SOUTH);
		actualLocation = new Location(xpos, ypos, orientation);
		FACE_RIGHT_STRATEGY.execute(actualLocation);
		compareLocation(expectedLocation, actualLocation);		 
	}
	
	/**
	 * tests the leftStrategy in facing North
	 */
	@Test
	public void testExecuteLeftStrategyNorth() {
		//location @ (1,1) facing North 
		xpos = 1; ypos = 1; orientation = Orientation.NORTH;
		expectedLocation = new Location(xpos, ypos, Orientation.WEST);
		actualLocation = new Location(xpos, ypos, orientation);
		FACE_LEFT_STRATEGY.execute(actualLocation);
		compareLocation(expectedLocation, actualLocation);
	}
	
	/**
	 * tests the leftStrategy facing South
	 */
	@Test
	public void testExecuteLeftStrategySouth() {
		//location @(1,1) facing South
		xpos = 1; ypos = 1; orientation = Orientation.SOUTH;
		expectedLocation = new Location(xpos, ypos, Orientation.EAST);
		actualLocation = new Location(xpos, ypos, orientation);
		FACE_LEFT_STRATEGY.execute(actualLocation);
		compareLocation(expectedLocation, actualLocation);
	}
	
	/**
	 * tests the leftStrategy facing West
	 */
	@Test
	public void testExecuteLeftStrategyWest() {
		//location @(1,1) facing WEST
		xpos = 1; ypos = 1; orientation = Orientation.WEST;
		expectedLocation = new Location(xpos, ypos, Orientation.SOUTH);
		actualLocation = new Location(xpos, ypos, orientation);
		FACE_LEFT_STRATEGY.execute(actualLocation);
		compareLocation(expectedLocation, actualLocation);
	}
	
	/**
	 * tests the leftStrategy facing East
	 */
	@Test
	public void testExecuteLeftStrategyEast() {
		//location @(1,1) facing EAST
		xpos = 1; ypos = 1; orientation = Orientation.EAST;
		expectedLocation = new Location(xpos, ypos, Orientation.NORTH);
		actualLocation = new Location(xpos, ypos, orientation);
		FACE_LEFT_STRATEGY.execute(actualLocation);
		compareLocation(expectedLocation, actualLocation);		 
	}
	
	/**
	 * Helps with expected to actual location assertion check
	 * @param expected {@link marsrover.datastructure.Location}
	 * @param actual {@link marsrover.datastructure.Location}
	 */
	private void compareLocation(Location expected, Location actual) {
		assertEquals("X position should be " + expected.getXpos(), expected.getXpos(), actual.getXpos());
		assertEquals("Y position should be " + expected.getYpos(), expected.getYpos(), actual.getYpos());
		assertEquals("Orientation should be " + expected.getOrientation().toString(), expected.getOrientation(), actual.getOrientation());
	}

}
