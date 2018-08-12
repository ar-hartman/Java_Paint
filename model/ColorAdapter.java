package model;

import java.awt.Color;
import java.lang.reflect.Field;

/*
 * Description: 
 * An Adapter pattern used to convert the ENUM provided data into a java.awt.Color class
 * that can be used by our Shape objects.  This originally was located within our Shape classes,
 * however, I felt this required the Shape class to take on too many responsibilities.  Creation 
 * a ColorAdapter requires the shapeColor from the application state. This was provided by the
 * Shape class via the IColorRequestor interface.  When called by the requestColor method, 
 * this adapter returns a Color object. 
 * 
 * Fields:
 * - n/a
 * 
 * Methods:
 * - requestColor
 */

public class ColorAdapter implements IColorRequestor{

	@Override
	public Color requestColor(ShapeColor shapeColor) {
		Color returnColor; 
		try {
			Field field = Class.forName("java.awt.Color").getField(shapeColor.toString());
			returnColor = (Color)field.get(null);	
		} catch (Exception e) {
			returnColor = null;
		}
		return returnColor;
	}
}
