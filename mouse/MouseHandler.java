package mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import collection.ShapeList;
import model.Observer;
import model.Pair;
import model.Shape;

/*
 * Description:
 * This MouseHandler class completes the MouseObserver Observer pattern, notifying all
 * dependent classes when a mouse is left-clicked and released.  At this time, a notification
 * is sent to all connected Observers.  When the observers require the updated information,
 * the call he MouseHandler class' getter methods for the starting and ending Pairs, which were
 * created at the mousePressed and mouseReleased instances, respectively.
 * 
 * Fields:
 * - Pair start
 * - Pair end
 * - ShapeList shapes
 * - Shape shape
 * 
 * Methods:
 * - mousePressed
 * - mouseReleased
 * - getStart
 * - getEnd
 * - setPoints
 * - update
 * - attach
 * - notifyAllObservers
 */

public class MouseHandler extends MouseAdapter implements MouseObserver{
	private Pair start;
	private Pair end;
	ShapeList shapes = new ShapeList();;
	Shape shape;

    private List<Observer> observers = new ArrayList<Observer>();
	
	public void mousePressed(MouseEvent e) {
		start = new Pair(e.getX(), e.getY());	
	}
	
	public void mouseReleased(MouseEvent e) {
		end = new Pair(e.getX(), e.getY());
		setPoints();
		notifyAllObservers();
	}
	
	public Pair getStart() {
		return start;
	}
	public Pair getEnd() {
		return end;
	}
	public void setPoints() {
		Pair smaller, larger;
		
		if (end.getX() < start.getX() || end.getY() < start.getY()) {
			smaller = new Pair(Math.min(start.getX(), end.getX()), Math.min(start.getY(), end.getY()));
			larger = new Pair(Math.max(start.getX(), end.getX()), Math.max(start.getY(), end.getY()));
			start = smaller;
			end = larger;
		}		
	}

	@Override
	public void update() {
	}

    public void attach(Observer observer) {
    	observers.add(observer);
    }
    
    public void notifyAllObservers() {
    	for (Observer observer : observers) {
    		observer.update();
    	}
    }

}
