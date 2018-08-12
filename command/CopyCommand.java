package command;

import javax.swing.JOptionPane;

import collection.ClipBoard;
import model.Pair;
import model.Shape;

/*
 * Description: 
 * This class is a dependent class, enabling the Paste functionality to operate properly. That is, in order
 * to Paste a shape, we must first select a shape (handled by the Selector class) and then Copy the shape.
 * When a shape is copied, we create a new Shape object and update the Start and End points in such a way
 * that provides an offset shape. This class also provides error checking, such that if we do not first 
 * select a Shape, then we do not have the ability to Copy a shape. In an instance where we have not 
 * Selected a Shape, an error pop-up window will be presented, indicating such an error has occurred.   
 * 
 * Fields:
 * - Shape newShape
 * 
 * Methods:
 * - execute
 * - getShape
 */

public class CopyCommand implements ICommand {
	private Shape newShape;			   
	
	public CopyCommand(Shape shape) {
		try {
			Pair newStart = new Pair(shape.getStart().getX() + 100 , shape.getStart().getY() + 100);
			Pair newEnd = new Pair(shape.getEnd().getX() + 100, shape.getEnd().getY() + 100);
			newShape = new Shape(newStart, newEnd, shape.getShapeType(), shape.getPrimaryColor(), shape.getSecondaryColor(), shape.getShadingType(), shape.getCanvas());
			execute();
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "In order to COPY, you must first select a Shape or groupt of Shapes");
		}		
	}
	
	public void execute() {		
		ClipBoard.addShape(newShape);
	}

	public Shape getShape() {
		return newShape;
	}
}
