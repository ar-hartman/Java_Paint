package model;

public class Shape{
	private final Pair start;
	private final Pair end;
    private final ShapeType shapeType;
    private final ShapeColor primaryColor;
    private final ShapeColor secondaryColor;
    private final ShapeShadingType shadingType;
	
	public Shape(Pair start, Pair end, ShapeType shapeType, ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shadingType) {
		this.start = start;
		this.end = end;
		this.shapeType = shapeType; 
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
		this.shadingType = shadingType;
	}


	


/*
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		/*System.out.println("Something to console - triggered by execute from Shape class");
		System.out.println("start: " + this.start.getX() + ", " + this.start.getY() + ", end: " + this.end.getX() + ", " + this.end.getY());
		System.out.println("Shape.java: " + shapeType);
		
		switch (shapeType.name()) {
		case "ELLIPSE":
			System.out.println("We've selected an ELIPSE");
			break;
		case "RECTANGLE":
			System.out.println("We've selected an RECTANGLE");
			break;
		case "TRIANGLE":
			System.out.println("We've selected an TRIANGLE");
			break;
	}
	}*/
	public void draw() {
		System.out.println("Something to console - triggered by execute from Shape class");
		System.out.println("start: " + this.start.getX() + ", " + this.start.getY() + ", end: " + this.end.getX() + ", " + this.end.getY());
		System.out.println("Shape.java.type: " + shapeType);
		System.out.println("Shape.java.primaryColor: " + primaryColor);
		System.out.println("Shape.java.secondaryColor: " + secondaryColor);
		System.out.println("Shape.java.shadingType: " + shadingType);
	}
}
