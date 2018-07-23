package model;

import java.util.ArrayList;

import collection.ShapeList;

public class ShapeListObserver extends ShapeObserver{
	/*
	 * 
	 * 
	 * This class can probably be deleted
	 * 
	 * 
	 */
	ShapeList shapes = new ShapeList();
	/*
	public ShapeListObserver(ShapeBuilder shapeBuilder) {
		this.shapeBuilder = shapeBuilder;
		this.shapeBuilder.attach(this);
	}
	*/
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
	
}
