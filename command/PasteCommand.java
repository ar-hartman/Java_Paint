package command;

import model.Shape;

/*
 * Description: 
 * The PasteCommand finishes the Copy/Paste functionality. The PateCommand object has an injected 
 * dependency, a Shape provided by the CopyCommand. With a Copied object in hand, we simply create
 * a new DrawCommand based on the Copied Shape Object and then execute such Shape.
 * 
 * Methods:
 * - execute
 * - getShape
 */

public class PasteCommand implements ICommand {
	Shape shape;
	
	public PasteCommand(Shape shape) {
		this.shape = shape;
	}
	public void execute() {	
		ICommand command = new DrawCommand(shape);
		command.execute();
	}	
	public Shape getShape() {
		return null;
	}
}


