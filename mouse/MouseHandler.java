package mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import collection.ShapeList;
import model.BuilderObserver;
import model.Pair;
import model.Shape;


//import jdk.internal.util.xml.impl.Pair;

public class MouseHandler extends MouseAdapter implements MouseObserver{
	private Pair start;
	private Pair end;
	ShapeList shapes = new ShapeList();;
	Shape shape;

	
    /*
     * 
     * user provided instance variables/objects
     * 
     */
    private List<BuilderObserver> observers = new ArrayList<BuilderObserver>();
	
    
    
    
    
    
	public void mousePressed(MouseEvent e) {
		// something
		start = new Pair(e.getX(), e.getY());	
		System.out.println("Start: ");
		System.out.println("X: " + start.getX() + " Y: " + start.getY());
	}
	
	public void mouseReleased(MouseEvent e) {
		end = new Pair(e.getX(), e.getY());
		System.out.println("End: ");
		System.out.println("X: " + end.getX() + " Y: " + end.getY());	
		
	//	builder.setStart(start);
		//builder.setEnd(end);
		//builder.setShapeType(appState.getActiveShapeType());
		
		//new Shape(start, end);
		//System.out.println("Mouse Handler: Shape - " + applicationState.getActiveShapeType());
		//shapes.addShape((Command) new Shape(start, end, applicationState.getActiveShapeType()));
		//shapes.addShape((Command) new Shape(start, end));
		//shapes.addShape(builder.toShape());
		//shapes.drawShapes();
		notifyAllObservers();
	}
	
	public Pair getStart() {
		return start;
	}
	public Pair getEnd() {
		return end;
	}

	@Override
	public void update() {
		System.out.println("Dialog Provider updated");
	}

	
    /*
     * User provided methods
     */
    public void attach(BuilderObserver observer) {
    	observers.add(observer);
    }
    
    public void notifyAllObservers() {
    	for (BuilderObserver observer : observers) {
    		//Shape shape = observer.update();
    		observer.update();
    		//shape.draw();
    	}
    }

}
