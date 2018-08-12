package model;

import mouse.MouseHandler;

/*
 * Description:
 * A Abstract SelectorObserver class to kick off the Observer Patter for selecting a Shape.  This class
 * is instantiated via the Main method.  The Selector class extends this class. 
 * 
 * fields:
 * - MouseHandler mouseHandler
 * 
 * methods:
 * - update
 */

public abstract class SelectorObserver extends Observer{
	protected MouseHandler mouseHandler;
	public abstract void update();
}
