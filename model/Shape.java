package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.lang.reflect.Field;

import view.gui.PaintCanvas;

public class Shape{
	private final Pair start;
	private final Pair end;
    private final ShapeType shapeType;
    private final ShapeColor primaryColor;
    private final ShapeColor secondaryColor;
    private final ShapeShadingType shadingType;
    private final PaintCanvas canvas;
	
	public Shape(Pair start, Pair end, ShapeType shapeType, ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shadingType, PaintCanvas canvas) {
		this.start = start;
		this.end = end;
		this.shapeType = shapeType; 
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
		this.shadingType = shadingType;
		this.canvas = canvas;
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
		
		
		switch (shapeType.toString()) {
			case "ELLIPSE":
				System.out.println("We've selected an ELIPSE");
				break;
			case "RECTANGLE":
				System.out.println("We've selected an RECTANGLE");
		        Graphics2D graphics2d = canvas.getGraphics2D();
		        

		        /*
		         * I would like to use an adapter pattern to convert the colors we're building with from ShapeColor to Color using a design pattern.
		         */
		        
		        Color primaryC;
		        Color secondaryC;
		        try {
		        	Field field = Class.forName("java.awt.Color").getField(primaryColor.toString());
		        	primaryC = (Color)field.get(null);
		        	field = Class.forName("java.awt.Color").getField(secondaryColor.toString());
		        	secondaryC = (Color)field.get(null);
		        }
		        catch (Exception e) {
		        	primaryC = null;
		        	secondaryC = null;
		        }
		        
		        
		        graphics2d.setColor(primaryC);//Color.decode(primaryColor.toString()));
		        graphics2d.fillRect(start.getX(), start.getY(), ((end.getX()-start.getX()-1)), end.getY()-start.getY()-1);
		        graphics2d.setStroke(new BasicStroke(5));
		        graphics2d.setColor(secondaryC);
		        graphics2d.drawRect(start.getX(), start.getY(), ((end.getX()-start.getX()-1)), end.getY()-start.getY()-1);
				break;
			case "TRIANGLE":
				System.out.println("We've selected an TRIANGLE");
				break;
		}
	}
}
