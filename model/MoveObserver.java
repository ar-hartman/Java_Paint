package model;

import mouse.MouseHandler;

/*
 * Description: 
 * A abstract MoverObserver, created by the Main class.  This object extends Observer 
 * functionality and is used to create a Mover object.   
 * 
 * Fields:
 * - MouseHandler mouseHandler
 * 
 * Methods:
 * - udpate
 */

public abstract class MoveObserver extends Observer{
		protected MouseHandler mouseHandler;
		public abstract void update();
}	
	
	

