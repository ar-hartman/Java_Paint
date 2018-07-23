package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.ShapeBuilder;
import model.persistence.ApplicationState;
import mouse.MouseHandler;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
	

    public static void main(String[] args){

    	PaintCanvas canvas = new PaintCanvas();
    	MouseHandler mouseHandler = new MouseHandler();  	    	    	
    	
    	IGuiWindow guiWindow = new GuiWindow(canvas, mouseHandler);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();
        ShapeBuilder builder = new ShapeBuilder(mouseHandler, appState, canvas);
    }
}
