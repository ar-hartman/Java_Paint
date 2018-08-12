package command;

import model.Shape;

/*
 * Description: 
 * Interface used by the following Commands: the DrawCommand, CopyCommand, NullCommand, 
 * PasteCommand, RedoCommand, and UndoCommand. 
 * 
 * Methods:
 * - execute
 * - getShape
 */

public interface ICommand {
	void execute();
	Shape getShape();
}
