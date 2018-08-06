package command;

import model.Shape;

public interface ICommand {
	void execute();
	Shape getShape();
}
