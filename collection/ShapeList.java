package collection;

import java.util.ArrayList;

import model.Shape;

/*
 * Description: 
 * This class stores all shapes impacted by the DrawCommand, UndoCommand, RedoCommand, PasteCommand, and Move classes. 
 * This class leverages an ArrayList to hold an arbitrary number of Shapes; leveraging the dynamic sizing behavior of 
 * the data structure. Shapes are added to the ArrayList through the 'addShape' method. Shapes are drawn through the 
 * 'drawShapes' method. Client code retrieves a list of the ArrayList through the 'getShapeList' method. Finally,
 * shapes are removed from the end of the ArrayList through the 'pop' method.
 * 
 * Fields:
 * - ArrayList<Shape> shapeList
 * 
 * Methods:
 * - addShape
 * - drawShapes
 * - getShapeList
 * - pop
 */

public class ShapeList {
	public static ArrayList<Shape> shapeList = new ArrayList<Shape>();

	public static void addShape(Shape shape) {
		shapeList.add(shape);
	}
	
	public void drawShapes() {
		for (Shape shape : shapeList) {
			shape.draw();
		}
	}
	public ArrayList<Shape> getShapeList(){
		return shapeList;
	}
	
	public Shape pop() {
		int listSize = shapeList.size();
		Shape shape = shapeList.get(listSize-1);
		shapeList.remove(listSize);
		return (Shape) shape;
	}
}
