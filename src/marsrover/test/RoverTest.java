package marsrover.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import marsrover.Rover;
import marsrover.datastructure.Instruction;
import marsrover.datastructure.Location;
import marsrover.datastructure.Orientation;
import marsrover.datastructure.Plateau;

/**
 * functional test for {@link marsrover.Rover} 
 * @author Amy Lee
 *
 */
public class RoverTest {
	
	private static final int XPOS = 1;
	private static final int YPOS = 1;
	private static final Orientation ORIENTATION = Orientation.NORTH;
	private Rover rover;

	@Before
	public void setUp() {
		rover = DataStructureCreator.createRover();
	}
	
	/**
	 * tests {@link Rover#explore()} with empty instructions where rover will stay in the same location
	 */
	@Test
	public void testExploreWithEmptyInstruction() {
		//default rover setup is with empty instructions
		rover.explore();
		assertEquals("Rover should have not moved with xpos = 1", XPOS, rover.getLocation().getXpos());
		assertEquals("Rover should have not moved with ypos = 1", YPOS, rover.getLocation().getYpos());
		assertEquals("Rover should have not moved with Orientation = NORTH", ORIENTATION, rover.getLocation().getOrientation());
	}
	
	/**
	 *  tests {@link Rover#explore()} of a given instruction MOVE LEFT RIGHT
	 */
	@Test
	public void testExploreWithValidInstruction() {
		//rover intialized with default instruction list
		rover.setInstruction(DataStructureCreator.createInstructionList());
		rover.explore();
		
		assertEquals("Rover Xpos should be 1", 1, rover.getLocation().getXpos());
		assertEquals("Rover Ypos should be 2", 2, rover.getLocation().getYpos());
		assertEquals("Rover Orientation should be North", Orientation.NORTH, rover.getLocation().getOrientation());
	}
	
	/**
	 * tests {@link Rover#explore()} not executing the last move because it cannot go out of bounds (xpos>=0)
	 */
	@Test
	public void testExploreWithGoingOutOfBoundsWest() {
		//rover initalized at (1,1) facing north.
		List<Instruction> instructions = DataStructureCreator.createInstructionGoingOutOfBoundsWest();
		Location expectedLocation = new Location(XPOS-1, YPOS, Orientation.WEST);
		rover.setInstruction(instructions);
		rover.explore();
		compareLocation(expectedLocation, rover.getLocation());
	}
	
	/**
	 * tests {@link Rover#explore()} not executing the last move because it cannot go out of bounds (xpos<=xcoordinate of Plateau)
	 */
	@Test
	public void testExploreWithGoingOutOfBoundsEast() {
		//rover initalized at (1,1) facing north.
		List<Instruction> instructions = DataStructureCreator.createInstructionGoingOutOfBoundsEast();
		Location expectedLocation = new Location(XPOS+1, YPOS, Orientation.EAST);
		rover.setInstruction(instructions);
		rover.explore();
		compareLocation(expectedLocation, rover.getLocation());
	}
	
	/**
	 * tests {@link Rover#explore()} not executing the last move because it cannot go out of bounds (ypos<=ycoordinate of Plateau)
	 */
	@Test
	public void testExploreWithGoingOutOfBoundsNorth() {
		//rover initalized at (1,1) facing north.
		List<Instruction> instructions = DataStructureCreator.createInstructionGoingOutOfBoundsNorth();
		Location expectedLocation = new Location(XPOS, YPOS+1, Orientation.NORTH);
		rover.setInstruction(instructions);
		rover.explore();
		compareLocation(expectedLocation, rover.getLocation());
	}
	
	/**
	 * tests {@link Rover#explore()} not executing the last move because it cannot go out of bounds (ypos >= 0)
	 */
	@Test
	public void testExploreWithGoingOutOfBoundsSouth() {
		//rover initalized at (1,1) facing north.
		List<Instruction> instructions = DataStructureCreator.createInstructionGoingOutOfBoundsSouth();
		Location expectedLocation = new Location(XPOS, YPOS-1, Orientation.SOUTH);
		rover.setInstruction(instructions);
		rover.explore();
		compareLocation(expectedLocation, rover.getLocation());
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

