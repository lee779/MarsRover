package marsrover.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import marsrover.datastructure.Location;
import marsrover.datastructure.Instruction;
import marsrover.datastructure.Orientation;
import marsrover.datastructure.Plateau;

/**
 * Converts parameters in String read from the input text file into the correct DataStructure
 * @author Amy Lee
 *
 */
public class StringConversionUtility {

	/**
	 * translates the instructionChar into the {@link marsrover.datastructure.Instruction}.
	 * Called by the {@link StringConversionUtility#getInstructions(String)}
	 * @param instructionChar {@code char} containing individual instruction
	 * @return translated {@link marsrover.datastructure.Instruction} or {@code null} if the instructionChar is invalid
	 */
	public static Instruction translateInstruction(char instructionChar){
		Instruction instruction = null;
		if(instructionChar == 'M'){
			instruction = Instruction.MOVE;
		}else if (instructionChar == 'L') {
			instruction = Instruction.LEFT;
		}else if (instructionChar == 'R') {
			instruction = Instruction.RIGHT;
		}
		return instruction;
	}

	/**
	 * parses the String input into List of Instruction.  
	 * Called by {@link marsrover.MarsRoverApp}
	 * @param input {@code String} containing instructions
	 * @return List of {@link marsrover.datastructure.Instruction}
	 */
	public static List<Instruction> getInstructions(String input) {

		if(input.matches("\\s+")){
			return null;
		}
		List<Instruction> instructions = new ArrayList<Instruction>();

		for (int i=0; i<input.length();i++) {
			Instruction parsedInstruction = translateInstruction(input.charAt(i));
			if(parsedInstruction != null) { //if it's null, don't add it in the set of instructions
				instructions.add(translateInstruction(input.charAt(i)));
			}
		}
		return instructions;
	}
	
	/**
	 * separates the input string into Array, taking out othe white spaces
	 * @param input {@code String}
	 * @return {@code String[]} and array of individual inputs 
	 */
	private static String[] parseInput(String input) {
		String[] parsed = input.split("\\s+");
		return parsed;
	}

	/**
	 * parses the input string into the {@link marsrover.datastructure.Plateau}. Checks if the parsed input consists of two integers.
	 * Called by {@link marsrover.MarsRoverApp}
	 * @param input {@code String} containing x and y coordinate
	 * @return {@link marsrover.datastructure.Plateau}. or {@code null} if input didn't contain two integers
	 */
	public static Plateau getPlateauCoordinates(String input) {
		if(input.matches("\\s+")){
			return null;
		}

		String[] coordinates= parseInput(input); //separates the input into x and y string
		Plateau plateau = new Plateau(0,0);

		int[] inputInt = checkAndParseIntegerInputs(coordinates); //checks if x and y string can be parsed into string
		if(inputInt == null) {
			plateau = null;
		} else {
			plateau.setXcoordinate(inputInt[0]);
			plateau.setYcoordinate(inputInt[1]);
		}

		return plateau;
	}

	/**
	 * parses the input string into {@link marsrover.datastructure.Location}
	 * @param input {@code String} consisting of xposition, yposition and orientation of Rover
	 * @return {@link marsrover.datastructure.Location} or {@code null} if parsing was unsuccessful
	 */
	public static Location getRoverLocation(String input) {
		if(input.matches("\\s+")){
			return null;
		}

		int xPos, yPos;
		String[] location = parseInput(input);
		//checks only the first two element which are the x and y position of Rover
		int[] inputInt = checkAndParseIntegerInputs(Arrays.copyOfRange(location,0,2)); 
		if(inputInt == null) {
			return null;
		} else {
			xPos = inputInt[0];
			yPos = inputInt[1];
		}
		
		Orientation orient = parseOrientation(location[2]);
		Location coordinate = new Location(xPos,yPos,orient);
		return coordinate;
	}
	
	/**
	 * chekcs if the input String can be translate into an integer
	 * @param inputs Array of {@code String}
	 * @return translated array of Integer or {@code null} if it cannot be parsed into integer
	 */
	private static int[] checkAndParseIntegerInputs(String[] inputs) {
		int[] inputInt = new int[inputs.length];
		for (int i =0; i < inputs.length; i++) {
			if(isInteger(inputs[i])) {
				inputInt[i] = Integer.valueOf(inputs[i]);
			} else {
				return null;
			}
		}
		return inputInt;

	}

	/**
	 * called by {@link StringConversionUtility#checkAndParseIntegerInputs(String[])} and determines if the string has a char value of a number
	 * @param input {@code String}
	 * @return {@code true} if char value of input is an integer
	 */
	private static boolean isInteger(String input) {
		//TODO: regex for finding integers only?
		for (int i =0; i< input.length(); i ++) {			
			if(input.charAt(i) < '0' || input.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}

	/**
	 * parses the String input into {@link marsrover.datastructure.Orientation}
	 * @param input {@code String} to be parsed
	 * @return {@link marsrover.datastructure.Orientation} or {@code Orientation.NORTH} as a default
	 */
	public static Orientation parseOrientation(String input) {
		if(input.equals("N")){
			return Orientation.NORTH;
		} else if (input.equals("S")) {
			return Orientation.SOUTH;
		} else if (input.equals("W")) {
			return Orientation.WEST;
		} else if (input.equals("E")) {
			return Orientation.EAST;
		} else 
			return Orientation.NORTH; 
		//putting default orientation to NORTH
	}
}
