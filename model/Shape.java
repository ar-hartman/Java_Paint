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

	public void draw() {
		System.out.println("Something to console - triggered by execute from Shape class");
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
        
        
        /*
         * This next section looks prime for a strategy pattern application.
         */
		switch (shapeType.toString()) {
			case "ELLIPSE":
				System.out.println("We've selected an ELIPSE");
				
		        graphics2d.setColor(primaryC);
		        graphics2d.fillOval(start.getX(), start.getY()-39, ((end.getX()-start.getX())-1), (end.getY()-start.getY()-1));
		        graphics2d.setStroke(new BasicStroke(5));
		        graphics2d.setColor(secondaryC);
		        graphics2d.drawOval(start.getX(), start.getY()-39, (end.getX()-start.getX()-1), (end.getY()-start.getY()-1));	
				break;
			case "RECTANGLE":
				System.out.println("We've selected an RECTANGLE");
		        
		        graphics2d.setColor(primaryC);
		        graphics2d.fillRect(start.getX(), start.getY()-39, ((end.getX()-start.getX()-1)), (end.getY()-start.getY()-1));
		        graphics2d.setStroke(new BasicStroke(5));
		        graphics2d.setColor(secondaryC);
		        graphics2d.drawRect(start.getX(), start.getY()-39, (end.getX()-start.getX()-1), (end.getY()-start.getY()-1));	
				break;
			case "TRIANGLE":
				System.out.println("We've selected an TRIANGLE");

				int[] xArray = {start.getX(), start.getX(), end.getX()};
				int[] yArray = {start.getY()-39, end.getY()-39, end.getY()-39};
		        graphics2d.setColor(primaryC);
		        graphics2d.fillPolygon(xArray, yArray, 3);
		        graphics2d.setStroke(new BasicStroke(5));
				graphics2d.setColor(secondaryC);
				graphics2d.drawPolygon(xArray, yArray, 3);
				break;
		}
	}


	public void delete() {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = canvas.getGraphics2D();
        /*
         * I would like to use an adapter pattern to convert the colors we're building with from ShapeColor to Color using a design pattern.
         */
        
        Color primaryC;
        Color secondaryC;
        try {
        	Field field = Class.forName("java.awt.Color").getField("white");
        	primaryC = (Color)field.get(null);
        	field = Class.forName("java.awt.Color").getField("white");
        	secondaryC = (Color)field.get(null);
        }
        catch (Exception e) {
        	primaryC = null;
        	secondaryC = null;
        }
        
        
        /*
         * This next section looks prime for a strategy pattern application.
         */
		switch (shapeType.toString()) {
			case "ELLIPSE":
				System.out.println("We've selected an ELIPSE");
				
		        graphics2d.setColor(primaryC);
		        graphics2d.fillOval(start.getX(), start.getY()-39, ((end.getX()-start.getX())-1), (end.getY()-start.getY()-1));
		        graphics2d.setStroke(new BasicStroke(5));
		        graphics2d.setColor(secondaryC);
		        graphics2d.drawOval(start.getX(), start.getY()-39, (end.getX()-start.getX()-1), (end.getY()-start.getY()-1));	
				break;
			case "RECTANGLE":
				System.out.println("We've selected an RECTANGLE");
		        
		        graphics2d.setColor(primaryC);
		        graphics2d.fillRect(start.getX(), start.getY()-39, ((end.getX()-start.getX()-1)), (end.getY()-start.getY()-1));
		        graphics2d.setStroke(new BasicStroke(5));
		        graphics2d.setColor(secondaryC);
		        graphics2d.drawRect(start.getX(), start.getY()-39, (end.getX()-start.getX()-1), (end.getY()-start.getY()-1));	
				break;
			case "TRIANGLE":
				System.out.println("We've selected an TRIANGLE");

				int[] xArray = {start.getX(), start.getX(), end.getX()};
				int[] yArray = {start.getY()-39, end.getY()-39, end.getY()-39};
		        graphics2d.setColor(primaryC);
		        graphics2d.fillPolygon(xArray, yArray, 3);
		        graphics2d.setStroke(new BasicStroke(5));
				graphics2d.setColor(secondaryC);
				graphics2d.drawPolygon(xArray, yArray, 3);
				break;
		}
	}


}
