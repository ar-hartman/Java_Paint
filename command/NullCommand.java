package command;

import model.Shape;

public class NullCommand implements ICommand{
	@Override
	public void execute() {	
	}

	@Override
	public Shape getShape() {
		return null;
	}
}
