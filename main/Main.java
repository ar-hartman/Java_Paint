package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import collection.ShapeList;
import command.CommandList;
import controller.IJPaintController;
import controller.JPaintController;
import model.Shape;
import model.ShapeBuilder;
import model.ShapeListObserver;
import model.dialogs.DialogProvider;
import model.interfaces.IDialogProvider;
import model.persistence.ApplicationState;
import mouse.MouseHandler;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
	

    public static void main(String[] args){
    	/*
    	 * adding during test
    	 */
        //ShapeBuilder builder = new ShapeBuilder();
        /*
         * 
         */
    	PaintCanvas canvas = new PaintCanvas();
    	MouseHandler mouseHandler = new MouseHandler();
    	
    	
    	
    	
    	IGuiWindow guiWindow = new GuiWindow(canvas, mouseHandler);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        
        //IDialogProvider dialog = new DialogProvider(appState);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();

        /*
         * 
         */
        //guiWindow.setApplicationState(appState);
        //builder.setShapeType(appState.getActiveShapeType());
        //System.out.println("Shape Type: " + appState.getActiveShapeType());
        /*
         * 
         */
        
        ShapeBuilder builder = new ShapeBuilder(mouseHandler, appState, canvas);
        
        /*
         * 
         * This next call can probably be deleted
         * 
        ShapeListObserver shapeListObserver = new ShapeListObserver(builder); 
        */
        //ShapeList shapeList = shapeListObserver.getShapeList();
        //DrawObserver drawObserver = new DrawObserver(shapeListObserver);
        


    }
}
