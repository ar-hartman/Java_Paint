package command;

import model.Shape;

/*
 * Description: 
 * This class provides the functionality enabling the deletion of a Selected Shape. Unlike the CopyCommand,
 * I have omitted the error catching functionality. That is, we simply do not delete a Shape if we have not 
 * Selected a shape. When a shape is Deleted, we first Undraw the selected Shape, then we remove the Selected
 * shape from the Undo CommandHistory stack.  Therefore, a DeleteCommand is not Undoable.  
 * 
 * Fields:
 * - Shape shape
 * 
 * Methods:
 * - execute
 * - getShape
 */

public class DeleteCommand implements ICommand {
	Shape shape;
	
	public DeleteCommand(Shape shape) {
		this.shape = shape;
	}
	
	public void execute() {
		shape.undraw();
		CommandHistory.getUndoStack().pop();
	}

	public Shape getShape() {
		return null;
	}

}
