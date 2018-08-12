package command;

import model.Shape;

/*
 * Description: 
 * The UndoCommand leverages the static undoStack provided by the CommandHistory class. 
 * When executed, the UndoCommand calls the undo method provided by the static 
 * CommandHistory class. The getShape method returns null.
 * 
 * Methods:
 * - execute
 * - getShape
 */

public class UndoCommand implements ICommand{

	@Override
	public void execute() {
		CommandHistory.undo();
	}

	@Override
	public Shape getShape() {
		return null;
	}

}
