package marsrover.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * manages reading user input file into a list of string
 * @author Amy Lee
 *
 */
public class CommandLineManager {

	/**
	 * system out prints to request an input text file
	 */
	private static void getInputTextFile() {
		System.out.println("Welcome.");
		System.out.println("Enter full path name of your input text file");
		System.out.print(">> ");
	}

	/**
	 * reads the parameters from the input file into a list of string 
	 * @param filename {@code String} obtained from commandline through {@link CommandLineManager#readCommandLine()}
	 * @return {@code List<String>} 
	 * @throws IOException
	 */
	private static List<String> readFile(String filename) throws IOException {
		String line = null;
		System.out.println("file: " + filename);
		List<String> inputs = new ArrayList<String>();
		BufferedReader bReader = new BufferedReader(new FileReader(filename));

		while((line = bReader.readLine())!=null){
			inputs.add(line);
		}
		bReader.close();
		return inputs;
	}

	/**
	 * reads the inputs from the command. line by line.
	 * @return {@code String}
	 * @throws IOException
	 */
	private static String readCommandLine() throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		input = bReader.readLine();
		return input;
	}

	/**
	 * reads the input of the filename and handles all the IOExceptions by setting the return value to be null. 
	 * Called by {@link marsrover.MarsRoverApp#getParametersFromUser()}
	 * @return {@code List<String>} the parameters in the input text file
	 */
	public static List<String> getInputs() {
		CommandLineManager.getInputTextFile();
		String input = null;
		List<String> commands = null;
		try {
			input = readCommandLine();
			if(input != null) {
				commands = readFile(input);

			}
		} catch (IOException e) {
			System.err.println("Error reading command line input. System restart");
		}

		if(input == null) {
			System.err.println("Invalid request. System restart");
		}
		return commands;
	}
}
