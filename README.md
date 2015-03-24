
# MarsRover
Programmer: Juyoung (Amy) Lee
Programmed answer to the MarsRover Question (a common programming question asked by tech companies). Created a robust program that is scalable and fully tested.

## PROBLEM: 
 A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.
          A rover's position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.
          In order to control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right respectively, without moving from its current spot. 'M' means move forward one grid point, and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1).

INPUT:

The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.

The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover's position, and the second line is a series of instructions telling the rover how to explore the plateau.
The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover's orientation.

Each rover will be finished sequentially, which means that the second rover won't start to move until the first one has finished moving.

OUTPUT:

The output for each rover should be its final co-ordinates and heading.

INPUT AND OUTPUT:

Test Input:
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM

Expected Output:
1 3 N
5 1 E


## OBJECTIVE: 
	Objective of this problem is output the (2) Rover's location based on the string of Instructions and their initial location. 

## GIVEN: 
	Rovers roam in the plateau which is rectangular.
	Rover's location is determined by a combination of x and y coordiantes and a letter reprsenting compass points (N, S, W, E.
	Rover's are controlled by instructions given by NASA consisting of 'L', 'R', and 'M'
	Rover moves one unit at a time.
	Plateau world on the lower left corner is 0,0 and stretching to (x,y) in the right top corner. This (x,y) is given by the input text.
	Input parameters are given as a input text.
	
## ASSUMPTIONS and DESIGN DECISIONS: 
	The ouput is printed on the commandline.
	This app supports N Rovers, N>0
	Rover's move sequentially, one after the other. This design assumed no collision between Rovers and that 
	Rover's are removed from their final positions for the next Rover to occupy that space if needed.
	Given the coordinates of the Plateau, Rover will not execute and skip any instructions that puts them out of bounds.
	The input text is assumed to be contain correct number of parameters. 
		This MarsRoverApp will check and assumed the following for the inputs.
			1. Invalid Instruction (outside of L, R or M) will not be executed and skipped. 
			2. Invalid Plateau coordinates and Rover X and Y position (when it's not an integer) will not be executed and quit the app safely with the error message.
			3. Invalid Orientation (outside of N, S, W, E) will be set to default orientation N.
	
## HOW TO EXECUTE THE PROGRAM:
	JAVA was used to program this assignment.

	Inside MarsRoverApp folder are two files: 
		1. src: consisting all the .java files organized and ready to run.
		2. doc: consisting NASA.txt(a default input text file for JUnit Testing purposes)
	Open any JAVA IDE and build a project given these folders. Main method is in the MarsRoverApp.java

## DESIGN PATTERN:
	I selected Strategy Design Pattern to implement how the Rover will navigate itself. I created an interface INavigator with a method execute() which is implemented 
	implemented by three classes NavigateForward, NavigateLeft, and NavigateRight that performs the three instructions given the Rover's orientation.

## CLASSES:
	All the classes are well defined in the program itself using javadoc. Here's a brief explanation.
	
	marsrover.MarsRoverApp		Main program that obtains the input parameter and initializes the Rover's location and instruction set. 
								Then calls on each Rover to perform the instructions. Finally, reports the final locations of the Rovers on the console.
	marsrover.Rover				Manages its location, Plateau coordinates, and list of Instruction. 
								Each rover has its own NavigateForward, NavigateLeft, NavigateRight for movement controls
								Main method is explore() which iterates through list of Instructions and	
								executeInstruction() that selectes the correct INavigator to use and move.
	
	marsrover.navigator.INavigate			Interface for the navigate classes. Has one method execute().
	marsrover.navigator.NavigateForward 	Implements INavigate and executes forward movement.
	marsrover.navigator.NavigateLeft 		Implements INavigate and executes face left movement.
	marsrover.navigator.NavigateRight 		Implements INavigate and executes face right movement
	
	marsrover.util.CommandLineManager		Manages the user commandline input and reads the input file to be organized into a list of String.
											Called by the marsrover.MarsRoverApp.
	marsrover.util.StringConversionUtility	Translates and Parses a string of input into the correct DataStructure.
											Called by the marsrove..
	
	marsrover.datastructure.Instruction		Datastructure of Instruction as enum {MOVE, LEFT, RIGHT}.
	marsrover.datastructure.Orientation		Datastructure of Orientation as enum {NORTH, SOUTH, WEST, EAST}.
	marsrover.datastructure.Plateau 		Datastructure that holds X and Y coordinates of the rectangular plateau.
	marsrover.datastructure.Location		Datastructure that holds X and Y coordinate of the Rover and its orientation.
	
	marsrover.test.NavigateTest						Unit test for the INavigate classes
	marsrover.test.CommandLineManagerTest			Unit test for CommandLineManager
	marsrover.test.RoverTest						Unit test for Rover
	marsrover.test.StringConversionUtilityTest		Unit test for StringConversionUtility
	marsrover.test.DataStructureCreator				Creates DataStructures for the Unit tests

	


