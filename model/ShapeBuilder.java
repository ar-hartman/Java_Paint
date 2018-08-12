package model;

import command.DrawCommand;
import model.persistence.ApplicationState;
import mouse.MouseHandler;
import view.gui.PaintCanvas;

/*
 * Description:
 * This class is the ShapeBuilder class, utilizing the Builder design pattern, triggered by the 
 * BuilderObserver pattern.  Attributes such as shapeType, primary and secondary colors, and shadingType
 * are provided by the Application State settings; set with the series of setter methods. The Shape is 
 * finished when start and end Pairs are provided by the MouseHandler via the BuilderObserver notification. 
 * 
 * Fields:
 * - Pair start
 * - Pair end
 * - ShapeType shapeType
 * - ShapeColor primaryColor
 * - ShapeColor secondaryColor
 * - ShapeShadingType shadingType
 * - ApplicationState appState
 * - Shape newShape
 * - PaintCanvas canvas 
 * 
 * Methods:
 * - setStart
 * - setEnd
 * - setShapeType
 * - setPrimaryColor
 * - setSecondaryColor
 * - setShadingType
 * - toShape
 * - getShape
 * - update 
 */

public class ShapeBuilder extends BuilderObserver{
	private Pair start;
	private Pair end;
    private ShapeType shapeType;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shadingType;
    private ApplicationState appState;
    public Shape newShape;
    private PaintCanvas canvas;
    
    public ShapeBuilder(MouseHandler mouseHandler, ApplicationState appState, PaintCanvas canvas) {
    	this.mouseHandler = mouseHandler;
    	this.mouseHandler.attach(this);
    	this.appState = appState;
    	this.canvas = canvas;
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
    	newShape = new Shape(start, end, shapeType, primaryColor, secondaryColor, shadingType, canvas);
    	DrawCommand drawShapeCommand = new DrawCommand(newShape);
    	drawShapeCommand.execute();
    	return newShape;
    }
    
	public Shape getShape() {
		return newShape;
	}

	@Override
	public void update() {
		if(appState.getActiveStartAndEndPointMode().toString() == "DRAW") {
			setStart(mouseHandler.getStart());
			setEnd(mouseHandler.getEnd());
			setShapeType(appState.getActiveShapeType());
			setPrimaryColor(appState.getActivePrimaryColor());
			setSecondaryColor(appState.getActiveSecondaryColor());
			setShadingType(appState.getActiveShapeShadingType());
			this.toShape();
		}
	}
}
