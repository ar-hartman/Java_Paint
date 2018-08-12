package model;

import java.awt.Color;

/*
 * Description: 
 * Interface used to provide adapter functionality, converting a ENUM provided color
 * string to a Color object. This interface is called by the Shape class.
 * 
 * Methods:
 * - requestColor
 */

public interface IColorRequestor {
	public Color requestColor(ShapeColor shapeColor);
}
