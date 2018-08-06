package command;

import model.Shape;

public class DrawCommand implements ICommand, IUndoable{
	private Shape shape;
	
	public DrawCommand(Shape shape) {
		this.shape = shape;
	}
	@Override
	public void execute() {
		CommandHistory.add(this);
		shape.draw();		
	}
	
	@Override
	public void undo() {
		shape.undraw();
	}
	@Override
	public void redo() {
		shape.draw();
	}
	public Shape getShape() {
		return shape;
	}
}
