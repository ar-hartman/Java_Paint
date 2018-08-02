package model;

import java.util.ArrayList;

import collection.ShapeList;
/*
public class ShapeListObserver implements ShapeObserver {
	/*
	 * 
	 * 
	 * This class can probably be deleted
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	/*
	ShapeBuilder shapeBuilder;
	ShapeList shapes = new ShapeList();
	ShapeList undoShapes = new ShapeList();
	
	@Override
	public void update() {
		shapes.addShape(shapeBuilder.getShape());
		iterateOverList();
	}
	
	public ShapeList getShapeList() {
		return shapes;
	}
	
	public void iterateOverList() {
		ArrayList<Shape> shapeList = shapes.getShapeList();
		for (Shape shape: shapeList) {
			shape.draw();
			System.out.println("drew from the ShapeListObserver - called from ShapeListObserver.update()");
		}
	}
	
	public void undoDraw() {
		undoShapes.addShape(shapes.pop());
	}

}
*/