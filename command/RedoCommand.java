package command;

import model.Shape;

public class RedoCommand implements ICommand{

	@Override
	public void execute() {
		System.out.println("Redo command triggered");
		CommandHistory.redo();
	}

	@Override
	public Shape getShape() {
		return null;
	}

}
