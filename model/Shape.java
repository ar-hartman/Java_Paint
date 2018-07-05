package model;

import collection.ShapeList;

public class Shape {
	private Pair start;
	private Pair end;
	ShapeList shapes;
	
	public Shape(Pair start0, Pair end0) {
		this.start = start0;
		this.end = end0;
		shapes = new ShapeList();
		shapes.addShape(this);
	}
}
