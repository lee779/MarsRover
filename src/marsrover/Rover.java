package marsrover;

import java.util.List;

import marsrover.datastructure.Instruction;
import marsrover.datastructure.Location;
import marsrover.datastructure.Orientation;
import marsrover.datastructure.Plateau;
import marsrover.navigator.INavigator;
import marsrover.navigator.NavigateForward;
import marsrover.navigator.NavigateLeft;
import marsrover.navigator.NavigateRight;

/**
 * Rover class holds Datastructures {@link marsrover.datastructure.Plateau}, 
 * List of {@link marsrover.datastructure.Instruction} and {@link marsrover.datastructure.Location}.
 * Also, has three INavigator for forward, face left, and face right execution.
 * @author Amy Lee
 *
 */
public class Rover {
	private final INavigator FORWARD_STRATEGY = new NavigateForward();
	private final INavigator FACE_RIGHT_STRATEGY= new NavigateRight();	
	private final INavigator FACE_LEFT_STRATEGY = new NavigateLeft();

	private Plateau plateauGrid;
	private List<Instruction> instructions; 
	private Location location;

	public Rover(Location location, Plateau grid, List<Instruction> instructions){
		this.plateauGrid = grid;
		this.instructions = instructions;
		this.location = location;
	}

	/**
	 * iterate through the list of instructions and executes them.
	 */
	public void explore(){
		for (int i = 0; i < instructions.size(); i++){
			executeInstruction(instructions.get(i));
		}
	}

	/**
	 * executes individual instruction by assigning the correct movementStrategy from FORWARD_STRATEGY, FACE_RIGHT_STRATEGY, and FACE_LEFT_STRATEGY
	 * @param instruction consists of MOVE, RIGHT, LEFT
	 */
	private void executeInstruction(Instruction instruction){
		INavigator movementStrategy = null;
		switch(instruction){
		case MOVE:
			movementStrategy = FORWARD_STRATEGY;
			break;
		case RIGHT:
			movementStrategy = FACE_RIGHT_STRATEGY;
			break;
		case LEFT:
			movementStrategy = FACE_LEFT_STRATEGY;
			break;
		}
		
		if(!skipInstruction(instruction)) { //checks if the rover will go out of bounds given the plateau coordinates
			movementStrategy.execute(this.location);
		}
	}

	/**
	 * determines whether the current instruction can be executed. 
	 * @param instruction MOVE, LEFT, or RIGHT
	 * @return {@code true} if instruction is a MOVE and the rover will go out of bounds since it's on the edge
	 */
	private boolean skipInstruction(Instruction instruction) {
		if (onTheEdge() && instruction.equals(Instruction.MOVE)) {
			System.out.println("Rover will be out of bounds, skipping Instruction " + instruction.toString());
			return true;
		}
		return false;
	}
	
	/**
	 * determines if the rover is on the edge based on its location and orientation
	 * @return {@code true} if rover is on the edge and facing towards the out of bounds. 
	 */
	private boolean onTheEdge(){
		switch(location.getOrientation()) {
		case NORTH:
			return (location.getYpos() == plateauGrid.getYcoordinate());
		case SOUTH:
			return (location.getYpos() == 0);
		case EAST:
			return (location.getXpos() == plateauGrid.getXcoordinate());
		case WEST:
			return (location.getXpos() == 0);
		}
		return false;
	}

	public String reportLocation(){
		return (location.getXpos() + " " + location.getYpos() + " " + location.getOrientation().toString().charAt(0));
	}

	public void setPlateau(Plateau plateau) {
		this.plateauGrid = plateau;
	}

	public void setInstruction(List<Instruction> instructions){
		this.instructions = instructions;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
