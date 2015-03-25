package marsrover;

import java.util.ArrayList;
import java.util.List;

import marsrover.datastructure.Location;
import marsrover.datastructure.Instruction;
import marsrover.datastructure.Plateau;
import marsrover.util.CommandLineManager;
import marsrover.util.StringConversionUtility;
/**
 * The MarsRoverApp main program class, obtains the user input text files and calls the rovers 
 * to explore and  report the final location as the output on the command line.
 * @author Amy Lee
 *
 */
public class MarsRoverApp {

	public static void main(String[] args) {
		List<String> parameters = getParametersFromUser(); //get input parameters from user
		List<Rover> rovers = initializeParameters(parameters); //takes read input strings and initialize the rovers

		beginExploration(rovers); //Rovers execute the instructions
		reportToNASA(rovers); //Report final locations of the Rovers 
	}

	/**
	 * 
	 * Returns the parameters provided by the user by calling {@link CommandLineManager#getInputs}
	 * if the parameters returns <code>null</code>, inputs could not be read and system quits. 
	 * @return {@code List<String>} if input was parsed with no IOExceptions
	 */
	private static List<String> getParametersFromUser() {
		 List<String> parameters = CommandLineManager.getInputs();
		 if(parameters == null) {
			 quit();
		 } 
		 return parameters;
	}
	
	/**
	 * Initializes all the Rover initial position and orientation as well as the plateau coordinates by 
	 * parsing the parameters strings obtained from  obtained from {@link MarsRoverApp#getCommandsFromUser()}
	 * The parameters strings are parsed by {@link StringConversionUtility#getPlateauCoordinates(String)}, 
	 * 										{@link StringConversionUtility#getRoverLocation(String)}, and 
	 * 										{@link StringConversionUtility#getInstructions(String)}
	 * 
	 * @param parameters {@code List<String>} contains plateau coordinates, location and instructions for the rovers
	 * @return {@code List<Rover>} initialized 
	 */
	private static List<Rover> initializeParameters(List<String> parameters){
		Plateau plateau = StringConversionUtility.getPlateauCoordinates(parameters.get(0));
		if(plateau == null) {
			System.err.println("Invalid plateau inputs. Please restart.");
			quit(); //system quits when failed to parse the plateau coordinates 
		}
		
		List<Rover> rovers = new ArrayList<Rover>();
		for(int i = 1; i < parameters.size(); i = i + 2){
			Location location = StringConversionUtility.getRoverLocation(parameters.get(i)); //first string is the rover location
			if(location == null) {
				System.err.println("Invalid location inputs. Please restart.");
				quit(); //system quits when failed to parse the location coordinates
			} 
			
			List<Instruction> instructions = StringConversionUtility.getInstructions(parameters.get(i+1)); //second string is the rover instruction
			//instructions doesn't have to check for null, if it failed to parse. 
			//It is returned as an empty list with no instructions but does not end the program
			
			Rover rover = new Rover(location, plateau, instructions);
			rovers.add(rover);
		}
		return rovers;
	}

	/**
	 * Calls all the rovers with the method {@link Rover#explore()} to execute all the instructions
	 * @param rovers List of Rovers obtained from {@link MarsRoverApp#initializeParameters(List)}
	 * 
	 */
	private static void beginExploration(List<Rover> rovers) {
		for(int i = 0; i < rovers.size(); i++) {
			rovers.get(i).explore();
		}
	}

	/**
	 * Prints all the Rover's final x-y position and orientation 
	 * @param rovers List of rovers
	 */
	private static void reportToNASA(List<Rover> rovers) {
		for(int i = 0; i < rovers.size(); i++) {
			System.out.println(rovers.get(i).reportLocation());
		}
	}

	/**
	 * Exits the program.
	 * Called when inputs cannot be parsed into right format or user wants to quit the program from the command line
	 */
	private static void quit() {
		System.out.println("System exiting");
		System.exit(0);
	}
}
