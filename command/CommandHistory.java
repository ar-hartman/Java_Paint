package command;

import java.util.Stack;

/*
 * Description: 
 * This class enables the functionality for undoing and redoing draw operations. The class leverages two stacks 
 * to store recently performed operations and recently undone operations. This includes draw commands, move commands, 
 * copy commands and paste commands. This class is only responsible for adding or removing commands from one of the
 * respective stacks. 
 * 
 * Fields:
 * - Stack<IUndoable> undoStack
 * - Stack<IUndoable> redoStack
 * 
 * Methods:
 * - add
 * - undo
 * - redo
 * - getUndoStack
 */

public class CommandHistory {
	private static final Stack<IUndoable> undoStack = new Stack<IUndoable>();
	private static final Stack<IUndoable> redoStack = new Stack<IUndoable>();

	public static void add(IUndoable command) {
		undoStack.push(command);
		redoStack.clear();
	}
	
	public static boolean undo() {
		boolean result = !undoStack.empty();
		if (result) {
			IUndoable command = undoStack.pop();
			redoStack.push(command);
			command.undo();
		}
		return result;
	}

	public static boolean redo() {
		boolean result = !redoStack.empty();
		if (result) {
			IUndoable command = redoStack.pop();
			undoStack.push(command);
			command.redo();
		}
		return result;
	}
	
	public static Stack<IUndoable> getUndoStack(){
		return undoStack;
	}
}
