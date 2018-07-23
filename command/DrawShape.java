package command;

import model.Shape;

public class DrawShape implements Command{
	private Shape shape;
	
	public DrawShape(Shape shape) {
		this.shape = shape;
	}
	@Override
	public void execute() {
		shape.draw();		
	}


}
