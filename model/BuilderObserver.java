package model;

import mouse.MouseHandler;

public abstract class BuilderObserver {
	protected MouseHandler mouseHandler;
	public abstract Shape update();
}
