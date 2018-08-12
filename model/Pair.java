package model;

/*
 * Description:
 * A user-defined Object type to be used by all Shape instances for the starting and ending 
 * locations, providing x and y coordinates as a pair of coordinates.
 * 
 * fields:
 * - int x
 * - int y
 * 
 * methods:
 * - getX
 * - getY
 */

public class Pair {
	private int x;
	private int y;
	
	public Pair(int x0, int y0){
		this.x = x0;
		this.y = y0;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
