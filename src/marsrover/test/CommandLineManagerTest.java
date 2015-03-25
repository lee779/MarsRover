package marsrover.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import marsrover.util.CommandLineManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Functional test for CommandLineManagerTest for method {@link CommandLineManager#getInputs()}
 * @author Amy Lee
 *
 */
public class CommandLineManagerTest {

	//using the text file created as default under doc folder
	private static final String FILENAME = System.getProperty("user.dir") + "\\doc\\NASA.txt";
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUp() {
	    System.setErr(new PrintStream(errContent));
	}
	
	@After
	public void cleanUpStreams() {
	    System.setIn(null);
	    System.setErr(null);
	}
	
	/**
	 * tests when the user enters an invalid file name, the parameters returned should be {@code null}
	 */
	@Test 
	public void testGetInputWithInvalidFilename() {
		ByteArrayInputStream in = new ByteArrayInputStream("INVALID".getBytes());
		System.setIn(in);
		System.setErr(new PrintStream(errContent));
		List<String> parameters = CommandLineManager.getInputs();
		assertNull("Parameter returns null, since it could not read the file", parameters);
	}
	
	/**
	 * tests when user inputs correct filename. Using the default input text file in the doc folder
	 * {@link DataStructureCreator#createCommandList()} is used as the expected parameter strings 
	 */
	@Test
	public void testGetInputWithValidFilename() {
		ByteArrayInputStream in = new ByteArrayInputStream(FILENAME.getBytes());
		System.setIn(in);
		
		List<String> expectedParameters= DataStructureCreator.createCommandList();
		List<String> actualParameters = CommandLineManager.getInputs();
		assertNotNull("Parameter is not null",actualParameters);
		assertEquals("Size should be same",expectedParameters.size(), actualParameters.size());
		for (int i = 0; i < expectedParameters.size(); i++) {
			assertEquals("Each string parameters should be equal", expectedParameters.get(i), actualParameters.get(i));
		}
	}
	
	
	
}
