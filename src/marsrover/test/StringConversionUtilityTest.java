package marsrover.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import marsrover.datastructure.Instruction;
import marsrover.datastructure.Location;
import marsrover.datastructure.Orientation;
import marsrover.datastructure.Plateau;
import marsrover.util.StringConversionUtility;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing all the String conversions to appropriate DataStructures used by the {@link Rover} with correct and incorrect inputs
 * @author Amy Lee
 *
 */
public class StringConversionUtilityTest {

	private static final char INVALIDCOMMAND = 'D';
	private static final String INVALID_ORIENTATION = "X";
	private static final String INVALID_PLATEAU = "3 e";
	private static final String INVALID_ROVER_LOCATION = "F 2 S";
	
	private static final String INSTRUCTION = "DDMDDLR"; 
	private static final String LOCATION = "1 1 N";
	private static final String VALID_PLATEAU = "3 5";
	private static final int PLATEAU_X = 3;
	private static final int PLATEAU_Y = 5;
	


	/**
	 * test {@link StringConversionUtility#parseInstruction(char)} given a wrong command. 
	 * Should return {@code null}
	 */
	@Test
	public void testParseInstructionWithWrongCommand() {
		Instruction actualInstruction = StringConversionUtility.translateInstruction(INVALIDCOMMAND);
		assertNull("Invalid command should return null", actualInstruction);
	}
	
	/**
	 * test {@link StringConversionUtility#parseInstruction(char)} given correct inputs.
	 */
	@Test
	public void testParseInstructionWithCorrectCommand() {
		Instruction instructionMove = StringConversionUtility.translateInstruction('M');
		Instruction instructionLeft = StringConversionUtility.translateInstruction('L');
		Instruction instructionRight = StringConversionUtility.translateInstruction('R');
		
		assertEquals("Parsed instruction should be MOVE", Instruction.MOVE, instructionMove);
		assertEquals("Parsed instruction should be LEFT", Instruction.LEFT, instructionLeft);
		assertEquals("Parsed instruction should be RIGHT", Instruction.RIGHT, instructionRight);
	}
	
	/**
	 * test {@link StringConversionUtility#getInstructions(String)} when input is an empty string
	 */
	@Test
	public void testGetInstructionsOfEmptyStrng() {
		List<Instruction> nullInstruction = StringConversionUtility.getInstructions("    ");
		assertNull("Empty input string, instruction returned should be null", nullInstruction);
	}
	
	/**
	 * test {@link StringConversionUtility#getInstructions(String)} with a combination of right and wrong input.
	 * Ending Instruction List should only contain the correct inputs
	 */
	@Test
	public void testGetInstructionsWithWrongCommand() {
		List<Instruction> expectedInstructions = DataStructureCreator.createInstructionList();
		List<Instruction> actualInstructions = StringConversionUtility.getInstructions(INSTRUCTION);
		
		assertEquals("actualInstructions should have the same size as expected", expectedInstructions.size(), actualInstructions.size());
		for (int i =0; i<expectedInstructions.size(); i++) {
			assertEquals("Instruction expected should be " + expectedInstructions.get(i).toString(), expectedInstructions.get(i), actualInstructions.get(i));
		}
	}
	
	/**
	 * tests {@link StringConversionUtility#parseOrientation(String)} with an invalid input
	 *  As default. Should return {@code Orientation.NORTH}
	 */
	@Test
	public void testParseOrientationWithWrongInput(){
		Orientation actualOrientation = StringConversionUtility.parseOrientation(INVALID_ORIENTATION);
		assertEquals("Invalid Orientation should be set to North", Orientation.NORTH, actualOrientation);
	}
	
	/**
	 * tests {@link StringConversionUtility#parseOrientation(String)} with correct inputs
	 */
	@Test
	public void testParseOrientationWithCorrectInput(){
		List<Orientation> expectedOrientations = DataStructureCreator.createOrientationList(); //default creator with NORTH, SOUTH, WEST, EAST
		String[] inputToParse = {"N","S", "W", "E"};
		for (int i = 0; i < inputToParse.length; i++) {
			Orientation actualOrientation = StringConversionUtility.parseOrientation(inputToParse[i]);
			assertEquals("actual orientation should match", expectedOrientations.get(i), actualOrientation);
		}
	}
	
	/**
	 * tests {@link StringConversionUtility#getPlateauCoordinates(String)} with input that is not an integer
	 */
	@Test
	public void testGetPlateauCoordinateWithWrongInput() {
		Plateau nullPlateau = StringConversionUtility.getPlateauCoordinates(INVALID_PLATEAU);
		assertNull("Plateau contained a non-integer, should return null",nullPlateau); 
	}
	
	/**
	 * tests {@link StringConversionUtility#getPlateauCoordinates(String)} with correct input 
	 */
	@Test
	public void testGetPlateauCoordinateWithCorrectInput() {
		Plateau actualPlateau = StringConversionUtility.getPlateauCoordinates(VALID_PLATEAU);
		assertEquals("Plateau x coordinate should be " + PLATEAU_X, PLATEAU_X, actualPlateau.getXcoordinate());
		assertEquals("Plateau y coordinate should be " + PLATEAU_Y, PLATEAU_Y, actualPlateau.getYcoordinate());
	}
	
	/**
	 * tests {@link StringConversionUtility#getRoverLocation(String)} with wrong input
	 */
	@Test
	public void testGetRoverLocationWithWrongInput() {
		Location nullLocation = StringConversionUtility.getRoverLocation(INVALID_ROVER_LOCATION);
		assertNull("Invalid rover location input, should return null", nullLocation);
	}

	/**
	 * tests {@link StringConversionUtility#getRoverLocation(String)} with correct input
	 */
	@Test
	public void testGetRoverLocationWithCorrectInput() {
		Location expectedRoverLocation = DataStructureCreator.createDefaultRoverLocation();
		Location actualRoverLocation = StringConversionUtility.getRoverLocation(LOCATION);
		assertEquals("Rover xpos should be " + expectedRoverLocation.getXpos(), expectedRoverLocation.getXpos(), actualRoverLocation.getXpos());
		assertEquals("Rover ypos should be " + expectedRoverLocation.getYpos(), expectedRoverLocation.getYpos(), actualRoverLocation.getYpos());
		assertEquals("Rover orientation should be " + expectedRoverLocation.getOrientation().toString(), expectedRoverLocation.getOrientation(), actualRoverLocation.getOrientation());
	}
	
}
