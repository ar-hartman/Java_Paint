package command;

import model.Shape;

/*
 * Description: 
 * The RedoCommand leverages the static redoStack provided by the CommandHistory class. 
 * When executed, the RedoCommand calls the redo method provided by the static 
 * CommandHistory class. The getShape method returns null.
 * 
 * Methods:
 * - execute
 * - getShape
 */

public class RedoCommand implements ICommand{

	@Override
	public void execute() {
		CommandHistory.redo();
	}

	@Override
	public Shape getShape() {
		return null;
	}

}
