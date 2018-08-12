package command;

/*
 * Description: 
 * Interface used to provide the undo and redo functionality. Used by the
 * following Commands: the DrawCommand. 
 * 
 * Methods:
 * - undo
 * - redo
 */


public interface IUndoable {
	void undo();
	void redo();
}
