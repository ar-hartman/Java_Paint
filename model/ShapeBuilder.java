package model;

import java.util.ArrayList;
import java.util.List;

import collection.ShapeList;
import model.persistence.ApplicationState;
import mouse.MouseHandler;

public class ShapeBuilder extends BuilderObserver{
	private Pair start;
	private Pair end;
    private ShapeType shapeType;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shadingType;
    private ApplicationState appState;
    private ShapeList shapes = new ShapeList();
    public Shape newShape;
    private List<ShapeObserver> shapeObservers = new ArrayList<ShapeObserver>();
    
    public ShapeBuilder(MouseHandler mouseHandler, ApplicationState appState) {
    	this.mouseHandler = mouseHandler;
    	this.mouseHandler.attach(this);
    	this.appState = appState;
    }
    
    public ShapeBuilder setStart(Pair start) {
    	this.start = start;
    	return this;
    }
    public ShapeBuilder setEnd(Pair end) {
    	this.end = end;
    	return this;
    }
    public ShapeBuilder setShapeType(ShapeType shapeType) {
    	this.shapeType = shapeType;
    	return this;
    }
    public ShapeBuilder setPrimaryColor(ShapeColor primaryColor) {
    	this.primaryColor = primaryColor;
    	return this;
    }
    public ShapeBuilder setSecondaryColor(ShapeColor secondaryColor) {
    	this.secondaryColor = secondaryColor;
    	return this;
    }
    public ShapeBuilder setShadingType(ShapeShadingType shadingType) {
    	this.shadingType = shadingType;
    	return this;
    }
    public Shape toShape() {
    	newShape = new Shape(start, end, shapeType, primaryColor, secondaryColor, shadingType);
    	notifyAllObservers();
    	return newShape;
    }
    
    
    /*
     * 
     * Methods necessary for ShapeList observer implementation
     * 
     */
	public void attach(ShapeObserver shapeObserver) {
		shapeObservers.add(shapeObserver);
	}
	private void notifyAllObservers() {
		for (ShapeObserver shapeObserver: shapeObservers) {
			shapeObserver.update();
		}
	}
	
	public Shape getShape() {
		return newShape;
	}

	@Override
	public Shape update() {
		System.out.println("Application State Changed");
		setStart(mouseHandler.getStart());
		setEnd(mouseHandler.getEnd());
		setShapeType(appState.getActiveShapeType());
		setPrimaryColor(appState.getActivePrimaryColor());
		setSecondaryColor(appState.getActiveSecondaryColor());
		setShadingType(appState.getActiveShapeShadingType());
		return this.toShape();
	}
}