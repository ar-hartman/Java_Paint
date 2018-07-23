package collection;

import java.util.ArrayList;

import command.Command;
import model.Shape;

public class ShapeList {
	ArrayList<Shape> shapeList = new ArrayList<Shape>();

	public void addShape(Shape shape) {
		shapeList.add(shape);
		System.out.println("something added - triggered by addShape methof from ShapeList class");
	}
	
	public void drawShapes() {
		for (Shape shape : shapeList) {
			shape.draw();
		}
	}
	public ArrayList<Shape> getShapeList(){
		return shapeList;
	}
}
