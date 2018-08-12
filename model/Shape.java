package model;

import java.awt.Color;
import java.awt.Graphics2D;
import view.gui.PaintCanvas;

/*
 * Description:
 * The Shape class is responsible for the creation of all Shape objects within this program.  It is instantiated by
 * the ShapeBuilder class via the BuilderObserver class.  This class utilizes a Strategy Pattern to create the specific
 * Shape type (Ellipse, Rectangle, or Triangle) and utilizes an Adapter pattern to convert our ENUM provided Color string to 
 * a java.awt.Color Color object. This class also contains methods to both Draw and Undraw itself, handled by the concrete
 * Shape types. There are a series of trivial getter methods. Lastly, I have overridden the Equals method to allow for 
 * Shape-to-Shape comparisons, namely for the Mover class. 
 * 
 * Fields:
 * - Pair start
 * - Pair end
 * - ShapeType shapeType
 * - ShapeColor primaryColor
 * - ShapeColor secondaryColor
 * - ShapeShadingType shadingType
 * - PaintCanvas canvas
 * - IShapeStrategy shapeStrategy
 * - Color primaryC
 * - Color secondaryC
 * - Graphics2D graphics2d
 * - IColorRequestor colorRequestor
 * 
 * Methods:
 * - setupColors
 * - setupShape
 * - draw
 * - undraw
 * - getStart
 * - getEnd
 * - getShapeType
 * - getPrimaryColor
 * - getSecondaryColor
 * - getShadingType
 * - getCanvas
 * - getWidth
 * - getHeight
 * - equals
 */

public class Shape{
	private final Pair start;
	private final Pair end;
    private final ShapeType shapeType;
    private final ShapeColor primaryColor;
    private final ShapeColor secondaryColor;
    private final ShapeShadingType shadingType;
    private final PaintCanvas canvas;
    private IShapeStrategy shapeStrategy;
    private Color primaryC;
    private Color secondaryC;
	Graphics2D graphics2d;
	IColorRequestor colorRequestor = new ColorAdapter();
    
	
	public Shape(Pair start, Pair end, ShapeType shapeType, ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shadingType, PaintCanvas canvas) {
		this.start = start;
		this.end = end;
		this.shapeType = shapeType; 
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
		this.shadingType = shadingType;
		this.canvas = canvas;
		graphics2d = canvas.getGraphics2D();
		setupColors();
		setupShape();
	}
	
	public void setupColors() {
        primaryC = colorRequestor.requestColor(primaryColor);
        secondaryC = colorRequestor.requestColor(secondaryColor);
	}
	
	public void setupShape() {
		switch (shapeType.toString()) {
		case "ELLIPSE":
			shapeStrategy = new Ellipse(start, end, primaryC, secondaryC, shadingType, graphics2d);
			break;
		case "RECTANGLE":
			shapeStrategy = new Rectangle(start, end, primaryC, secondaryC, shadingType, graphics2d);
			break;
		case "TRIANGLE":
			shapeStrategy = new Triangle(start, end, primaryC, secondaryC, shadingType, graphics2d);				
			break;
		}
	}

	public void draw() {
        shapeStrategy.draw();
	}

	public void undraw() {
        shapeStrategy.undraw();
	}
	
	
	/*
	 * Getter methods
	 */
	public Pair getStart() {
		return start;
	}
	public Pair getEnd() {
		return end;
	}
	public ShapeType getShapeType() {
		return shapeType;
	}
	public ShapeColor getPrimaryColor() {
	    return primaryColor;
	}
	public ShapeColor getSecondaryColor() {
		return secondaryColor;
		
	}
	public ShapeShadingType getShadingType() {
		return shadingType;
	}
	public PaintCanvas getCanvas() {
		return canvas;
	}
	public int getWidth() {
		return end.getX() - start.getX();
	}
	public int getHeight() {
		return end.getY() - start.getY();
	}
	
	/*
	 * overridden equals function
	 */
	public boolean equals(Shape shape) {
		if (this.getWidth() == shape.getWidth() &&
			this.getHeight() == shape.getHeight() &&
			this.shapeType.toString().equals(shape.shapeType.toString()) &&
			this.primaryColor.toString().equals(shape.primaryColor.toString()) &&
			this.secondaryColor.toString().equals(shape.secondaryColor.toString()) &&
			this.shadingType.toString().equals(shape.shadingType.toString())) 
		{
			return true;
		} else {
			return false;
		}
		
	}
}
