package command;

import model.Shape;

public class UndoCommand implements ICommand{

	@Override
	public void execute() {
		System.out.println("Undo Command Triggered");
		CommandHistory.undo();
	}

	@Override
	public Shape getShape() {
		return null;
	}

}
