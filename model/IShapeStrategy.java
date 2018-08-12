package model;

/*
 * Description:
 * The interface allowing for the Shape Strategy Pattern.  This interface is called by the 
 * Shape class and returns either an Ellipse, a Rectangle, or a Triangle.
 * 
 * Methods:
 * - draw
 * - undraw
 */

public interface IShapeStrategy {
	public void draw();
	public void undraw();
}
