package command;

import java.util.Stack;

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
}
