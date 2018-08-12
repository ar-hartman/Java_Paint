package model;

import javax.swing.JOptionPane;

import command.DrawCommand;
import model.persistence.ApplicationState;
import mouse.MouseHandler;
import view.gui.PaintCanvas;

/*
 * Description: 
 * A concrete Mover object created via the MoverObserver Observer pattern.  When the MouseHandler object
 * sends and update notification, this Mover object is notified.  Upon checking for application state criteria,
 * this object will continue processing and move and Selected object. This class also proves quasi-Singleton behavior,
 * such that if we already have move a Selected object, then we will move it again, but we will not retain any of the 
 * previous objects. Furthermore, this class also calls an overridden equals() method from the Shape class to allow for
 * movement of subsequent shapes within the same session. 
 * 
 * Fields:
 * - MouseHandler mouseHandler
 * - ApplicationState appState
 * - PaintCanvas canvas
 * - Shape newShape
 * 
 * Methods:
 * - getEndingPair
 * - update
 * - getNewShape
 */

public class Mover extends MoveObserver {
	MouseHandler mouseHandler;
	ApplicationState appState;
	PaintCanvas canvas;
	Shape newShape;
	
	public Mover(MouseHandler mouseHandler, ApplicationState appState, PaintCanvas canvas) {
		this.mouseHandler = mouseHandler;
	  	this.mouseHandler.attach(this);
		this.appState = appState;
		this.canvas = canvas;
	}

	public Pair getEndingPair() {
		Pair start = Selector.getShape().getStart();
		Pair end = Selector.getShape().getEnd();
		
		int xDelta = end.getX() - start.getX();
		int yDelta = end.getY() - start.getY();
		
		return new Pair(mouseHandler.getStart().getX() + xDelta, mouseHandler.getStart().getY() + yDelta);
	}

	@Override
	public void update() {
		if (appState.getActiveStartAndEndPointMode().toString() == "MOVE" && Selector.getShape() != null) {	
			try {
				newShape = getNewShape();
				DrawCommand drawShapeCommand = new DrawCommand(newShape);
				drawShapeCommand.execute();
				DrawCommand undoShapeCommand = new DrawCommand(Selector.getShape());
				undoShapeCommand.undo();
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "In order to perform a MOVE, you must first select a Shape or groupt of Shapes");
			}
		}
	}

	private Shape getNewShape() {
		if (newShape != null && newShape.equals(Selector.getShape())) {
			return newShape;
		} else {
			newShape = new Shape(mouseHandler.getStart(), getEndingPair(), Selector.getShape().getShapeType(), Selector.getShape().getPrimaryColor()
					, Selector.getShape().getSecondaryColor(), Selector.getShape().getShadingType(), canvas);
			return newShape;
		}
	}	
}
