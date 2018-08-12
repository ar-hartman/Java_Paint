package model;

import mouse.MouseHandler;

/*
 * Description: 
 * An abstract class providing required field and methods for a ShapeBuilder class.  This class
 * also extends an Observer abstract class.  This tiered model was required as I created many
 * observer objects and wanted to ensure enforcement of specific behavior. 
 * 
 * Fields:
 * - MouseHandler mouseHandler
 * 
 * Methods:
 * - update
 */

public abstract class BuilderObserver extends Observer{
	protected MouseHandler mouseHandler;
	public abstract void update();
}
