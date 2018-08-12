package command;

import model.Shape;

/*
 * Description: 
 * Null design pattern used to return a Null command object, providing do nothing
 * implementation of the Command series of classes
 * 
 * Methods:
 * - execute
 * - getShape
 */

public class NullCommand implements ICommand{
	@Override
	public void execute() {	
	}

	@Override
	public Shape getShape() {
		return null;
	}
}
