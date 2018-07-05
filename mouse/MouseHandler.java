package mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Pair;

//import jdk.internal.util.xml.impl.Pair;

public class MouseHandler extends MouseAdapter{
	private Pair start;
	private Pair end;
	
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
	}
	
	public Pair getStart() {
		return start;
	}
	public Pair getEnd() {
		return end;
	}
}
