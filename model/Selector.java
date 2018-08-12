package model;

import model.persistence.ApplicationState;
import mouse.MouseHandler;
import view.gui.PaintCanvas;

import collection.ShapeList;

/*
 * Description:
 * A concrete Selector class completing the SelectorObserver pattern.  This class is responsible for selecting 
 * a Shape object for use in Copy/Paste, Delete, and Move functions.  It does this by taking starting and end
 * coordinates from the mouseHandler and the 'Selection' application state and then checks bounds of objects
 * on screen via the static ShapeList data structure.  Bounds checking is performed through iterating through
 * the ShapeList and checking each shapes starting and ending coordinate pairs to the MouseHandler starting and 
 * ending pairs. If there is a shape with both starting and ending pairs within the MouseHandler values, then the 
 * checkForShape method returns the given shape. 
 * 
 * There are a couple of trivial, setter methods for local, class instance variables (setStart & setEnd)
 * 
 * Additionally, there is getter (getShape) method used for dependency injection for other Command classes
 * 
 * fields:
 * - MouseHandler mouseHandler
 * - Pair start
 * - Pair end
 * - ApplicationState appState
 * - Shape identifiedShape
 * 
 * methods:
 * - checkForShape
 * - setStart
 * - setEnd
 * - update
 * - getShape
 */

public class Selector extends SelectorObserver{
	protected MouseHandler mouseHandler;
	private Pair start;
	private Pair end;
	private ApplicationState appState;
	private static Shape identifiedShape;
	
    public Selector(MouseHandler mouseHandler, ApplicationState appState, PaintCanvas canvas) {
    	this.mouseHandler = mouseHandler;
    	this.mouseHandler.attach(this);
    	this.appState = appState;
    }
	
    private Shape checkforShape() {
		start = mouseHandler.getStart();
		end = mouseHandler.getEnd();
	    	
    	for (Shape shape : ShapeList.shapeList) {
    		Pair shapeStart = shape.getStart();
    		Pair shapeEnd = shape.getEnd();

    		if (start.getX() < shapeStart.getX() && start.getY() < shapeStart.getY() && end.getX() > shapeEnd.getX() && end.getY() > shapeEnd.getY()) {
    			System.out.println("You've selected a Shape");
    			identifiedShape = shape;
    		}
    	}
    	return identifiedShape;
    }
    
    public void setStart(Pair start) {
    	this.start = start;
    }
    public void setEnd(Pair end) {
    	this.end = end;
    }
	
	public void update() {
		if (appState.getActiveStartAndEndPointMode().toString() == "SELECT") {
			setStart(mouseHandler.getStart());
			setEnd(mouseHandler.getEnd());
			identifiedShape = checkforShape();
		}
	}
	public static Shape getShape() {
		return identifiedShape;
	}
}
