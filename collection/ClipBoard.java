package collection;

import model.Shape;

/*
 * Description: 
 * This class is essential for the 'Copy/Paste' functionality. When the user selects a shape and subsequently
 * clicks the 'COPY' button, a reference to that shape is stored here in the ClipBoard class. Storing the 
 * Shape object is achieved by using the 'addShape' method. Similarly, the Shape object is retrieved by using
 * the 'getShape' method.
 * 
 * Fields:
 * - Shape clipBoardShape
 * 
 * Methods:
 * - addShape
 * - getShape
 */

public class ClipBoard {
	static Shape clipBoardShape;

	public static void addShape(Shape shape) {		
		clipBoardShape = shape;
	}
	
	public static Shape getShape() {
		return clipBoardShape;
	}
}
