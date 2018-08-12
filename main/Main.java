package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.BuilderObserver;
import model.MoveObserver;
import model.Mover;
import model.Selector;
import model.SelectorObserver;
import model.ShapeBuilder;
import model.persistence.ApplicationState;
import mouse.MouseHandler;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

/*
 * Description: 
 * The Main method was provided by the instructor, but was modified to include functionality
 * required to complete the assigned project.  
 * 
 * This included creation of:
 * - a PaintCanvas object outside of the GuiWindow object initialization. 
 * - a MouseHandler object, essential action listening within the GuiWindow 
 * 		and also for the three observer objects that were created.
 * - a BuilderObserver object, responsible for being notified of Mouse activity and acquiring
 * 		application state data.
 * - a SelectorObserver object, responsible selecting a Shape only when certain mouse actions were
 * 		triggered along with specific application state criteria.
 * - a MoveObserver, responsible for moving a selected Shape only when certain mouse action were 
 * 		triggered along with specific application state criteria.   
 */

public class Main {
	

    public static void main(String[] args){

    	PaintCanvas canvas = new PaintCanvas();
    	MouseHandler mouseHandler = new MouseHandler();  	    	    	
    	
    	IGuiWindow guiWindow = new GuiWindow(canvas, mouseHandler);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();
        BuilderObserver builder = new ShapeBuilder(mouseHandler, appState, canvas);
        SelectorObserver selecter = new Selector(mouseHandler, appState, canvas);
        MoveObserver mover = new Mover(mouseHandler, appState, canvas);
    }
}
