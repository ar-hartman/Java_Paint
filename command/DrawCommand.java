package command;

import collection.ShapeList;
import model.Shape;

/*
 * Description: 
 * This class provides the DrawCommand functionality for the entire program.  This class is 
 * triggered by the ShapeBuilder, the UndoCommand, the RedoCommand, the PasteCommand, and the
 * Move commands.  When a Shape is created, we first add the shape to the CommandHistory stack, 
 * we then add the Shape to a static ShapeList, and finally we Draw the given shape.  The Undo method 
 * first removes the shape from the static ShapeList and then Undraws the shape.  The Redo command 
 * simply adds the undone shapeDraw back to the static ShapeList and then Redraws the given Shape. 
 * 
 * Fields:
 * - Shape shape
 * 
 * Methods:
 * - execute
 * - undo
 * - redo
 * - getShape
 */

public class DrawCommand implements ICommand, IUndoable{
	private Shape shape;
	
	public DrawCommand(Shape newShape) {
		this.shape = newShape;
	}
	@Override
	public void execute() {
		CommandHistory.add(this);
		ShapeList.addShape(shape);
		shape.draw();		
	}
	
	@Override
	public void undo() {
		ShapeList.shapeList.remove(shape);
		shape.undraw();
	}
	@Override
	public void redo() {
		ShapeList.shapeList.add(shape);
		shape.draw();
	}
	public Shape getShape() {
		return shape;
	}
}
