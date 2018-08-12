package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.lang.reflect.Field;

/*
 * Description: 
 * A concrete Triangle Shape Object created by a Strategy Pattern object (IShapeStrategy) via
 * a Shape Object. The sole responsibilities for this class is to Draw and Undraw itself.
 * 
 * 
 * Fields:
 * - Pair start
 * - Pair end
 * - Color primaryC
 * - Color secondaryC
 * - ShapeShadingType shadingType
 * - Graphics2D graphics2d
 * 
 * Methods:
 * - draw
 * - undraw
 */

public class Triangle implements IShapeStrategy{
	Pair start;
	Pair end;
	Color primaryC;
    Color secondaryC;
	ShapeShadingType shadingType;
	Graphics2D graphics2d;
	int HEADEROFFSET = 39;

	
	public Triangle(Pair start, Pair end, Color primaryC, Color secondaryC, ShapeShadingType shadingType, Graphics2D graphics2d) {
		this.start = start;
		this.end = end;
		this.primaryC = primaryC;
		this.secondaryC = secondaryC;
		this.shadingType = shadingType;
		this.graphics2d = graphics2d;
	}
	
	@Override
	public void draw() {
		int[] xArray = {start.getX(), start.getX(), end.getX()};
		int[] yArray = {start.getY()-HEADEROFFSET, end.getY()-HEADEROFFSET, end.getY()-HEADEROFFSET};
		switch (shadingType.toString()){
		case "FILLED_IN":
			//these two lines - filled in portion of ellipse
			graphics2d.setColor(primaryC);
			graphics2d.fillPolygon(xArray, yArray, 3);
			break;
		case "OUTLINE":
			// these three lines - outline portion of ellipse
	        graphics2d.setStroke(new BasicStroke(5));
	        graphics2d.setColor(secondaryC);
			graphics2d.drawPolygon(xArray, yArray, 3);
	        break;
		case "OUTLINE_AND_FILLED_IN":
			//these two lines - filled in portion of ellipse
			graphics2d.setColor(primaryC);
			graphics2d.fillPolygon(xArray, yArray, 3);
			// these three lines - outline portion of ellipse
	        graphics2d.setStroke(new BasicStroke(5));
	        graphics2d.setColor(secondaryC);
			graphics2d.drawPolygon(xArray, yArray, 3);
	        break;
		}	
	}

	@Override
	public void undraw() {
		Color undrawPrimaryC;
		Color undrawSecondaryC;
		try {
        	Field field = Class.forName("java.awt.Color").getField("white");
        	undrawPrimaryC = (Color)field.get(null);
        	field = Class.forName("java.awt.Color").getField("white");
        	undrawSecondaryC = (Color)field.get(null);
        }
        catch (Exception e) {
        	undrawPrimaryC = null;
        	undrawSecondaryC = null;
        }
		
		int[] xArray = {start.getX(), start.getX(), end.getX()};
		int[] yArray = {start.getY()-39, end.getY()-39, end.getY()-39};
        graphics2d.setColor(undrawPrimaryC);
        graphics2d.fillPolygon(xArray, yArray, 3);
        graphics2d.setStroke(new BasicStroke(5));
		graphics2d.setColor(undrawSecondaryC);
		graphics2d.drawPolygon(xArray, yArray, 3);
	}

}
