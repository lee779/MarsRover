package marsrover.test;

import java.util.ArrayList;
import java.util.List;

import marsrover.Rover;
import marsrover.datastructure.Instruction;
import marsrover.datastructure.Location;
import marsrover.datastructure.Orientation;
import marsrover.datastructure.Plateau;

/**
 * Creates data structures for testing purposes
 * @author Amy Lee
 *
 */
public class DataStructureCreator {
	/** 
	 * creates the default command string list defined by the values in doc/NASA.txt.
	 * see {@link CommandLineManagerTest#testGetInputWithValidFilename()}
	 * @return {@code List<String>} 
	 */
	public static List<String> createCommandList() {
		List<String> commands = new ArrayList<String>();
		commands.add("5 5");
		commands.add("1 2 N");
		commands.add("LMLMLMLMM");
		commands.add("3 3 E");
		commands.add("MMRMMRMRRM");
		return commands;
	}
	
	/**
	 * creates a list of Instruction. 
	 * See {@link StringConversionUtilityTest#testGetInstructionsWithWrongCommand()}
	 * @return {@code List<Instruction>} MOVE, LEFT, RIGHT
	 */
	public static List<Instruction> createInstructionList() {
		List<Instruction> instructions = new ArrayList<Instruction>();
		instructions.add(Instruction.MOVE);
		instructions.add(Instruction.LEFT);
		instructions.add(Instruction.RIGHT);
		return instructions;
	}
	
	/**
	 * Creates a default list used in {@link StringConversionUtilityTest#testParseOrientationWithCorrectInput()}
	 * @return {@code List<Orientation>} NORTH, SOUTH, WEST EAST
	 */
	public static List<Orientation> createOrientationList() {
		List<Orientation> orientations = new ArrayList<Orientation>();
		orientations.add(Orientation.NORTH);
		orientations.add(Orientation.SOUTH);
		orientations.add(Orientation.WEST);
		orientations.add(Orientation.EAST);
		return orientations;
	}

	/**
	 * creates a default rover location, see {@link StringConversionUtilityTest#testGetRoverLocationWithWrongInput()}
	 * see {@link DataStructureCreator#createDefaultRoverLocationString()} for input data
	 * @return {@code Location}
	 */
	public static Location createDefaultRoverLocation() {
		Location location = new Location(1, 1, Orientation.NORTH);
		return location;
	}
	
	/**
	 * crate a default rover for {@link RoverTest} with Plateau (2,2) and Rover at (1,1) facing North
	 * @return {@link marsrover.Rover}
	 */
	public static Rover createRover() {
		Location location = createDefaultRoverLocation();
		Plateau plateau = new Plateau(2,2);
		List<Instruction> instructions = new ArrayList<Instruction>();
		Rover rover = new Rover(location,plateau,instructions);
		return rover;
	}
	
	/**
	 * create a set of instruction that tells the rover to go out of bounds west given the default rover settings.
	 *  See {@link DataStructureCreator#createRover()}for the default parameters
	 * @return {@code List<Instruction>} 
	 */
	public static List<Instruction> createInstructionGoingOutOfBoundsWest() {
		List<Instruction> instructions = new ArrayList<Instruction>();
		instructions.add(Instruction.LEFT);
		instructions.add(Instruction.MOVE);
		instructions.add(Instruction.MOVE);
		return instructions;
	}
	
	/**
	 * create a set of instruction that tells the rover to go out of bounds east given the default rover settings.
	 *  See {@link DataStructureCreator#createRover()}for the default parameters
	 * @return {@code List<Instruction>} 
	 */
	public static List<Instruction> createInstructionGoingOutOfBoundsEast() {
		List<Instruction> instructions = new ArrayList<Instruction>();
		instructions.add(Instruction.RIGHT);
		instructions.add(Instruction.MOVE);
		instructions.add(Instruction.MOVE);
		return instructions;
	}
	
	/**
	 * create a set of instruction that tells the rover to go out of bounds NORTH given the default rover settings.
	 *  See {@link DataStructureCreator#createRover()}for the default parameters
	 * @return {@code List<Instruction>} 
	 */
	public static List<Instruction> createInstructionGoingOutOfBoundsNorth() {
		List<Instruction> instructions = new ArrayList<Instruction>();
		instructions.add(Instruction.MOVE);
		instructions.add(Instruction.MOVE);
		return instructions;
	}
	
	/**
	 * create a set of instruction that tells the rover to go out of bounds SOUTH given the default rover settings.
	 *  See {@link DataStructureCreator#createRover()}for the default parameters
	 * @return {@code List<Instruction>} 
	 */
	public static List<Instruction> createInstructionGoingOutOfBoundsSouth() {
		List<Instruction> instructions = new ArrayList<Instruction>();
		instructions.add(Instruction.RIGHT);
		instructions.add(Instruction.RIGHT);
		instructions.add(Instruction.MOVE);
		instructions.add(Instruction.MOVE);
		return instructions;
	}
	
		
}
