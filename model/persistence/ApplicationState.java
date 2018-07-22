package model.persistence;

import java.util.ArrayList;
import java.util.List;

import model.BuilderObserver;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;
import model.dialogs.DialogProvider;
import model.interfaces.IApplicationState;
import model.interfaces.IDialogProvider;
import view.interfaces.IUiModule;

public class ApplicationState implements IApplicationState {
    private final IUiModule uiModule;
    private final IDialogProvider dialogProvider;

    private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private StartAndEndPointMode activeStartAndEndPointMode;
    
    /*
     * user added instance variables/objects
     */
    private List<BuilderObserver> observers = new ArrayList<BuilderObserver>();
    

    public ApplicationState(IUiModule uiModule) {
        this.uiModule = uiModule;
        this.dialogProvider = new DialogProvider(this);
        setDefaults();
    }

    @Override
    public void setActiveShape() {
        activeShapeType = uiModule.getDialogResponse(dialogProvider.getChooseShapeDialog());
        /*
         * 
         */
        notifyAllObservers();
    }

    @Override
    public void setActivePrimaryColor() {
        activePrimaryColor = uiModule.getDialogResponse(dialogProvider.getChoosePrimaryColorDialog());
        /*
         * 
         */
        notifyAllObservers();
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = uiModule.getDialogResponse(dialogProvider.getChooseSecondaryColorDialog());
        /*
         * 
         */
        notifyAllObservers();
    }

    @Override
    public void setActiveShadingType() {
        activeShapeShadingType = uiModule.getDialogResponse(dialogProvider.getChooseShadingTypeDialog());
        /*
         * 
         */
        notifyAllObservers();
    }

    @Override
    public void setActiveStartAndEndPointMode() {
        activeStartAndEndPointMode = uiModule.getDialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());
        /*
         * 
         */
        notifyAllObservers();
    }

    @Override
    public ShapeType getActiveShapeType() {
        return activeShapeType;
    }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public ShapeShadingType getActiveShapeShadingType() {
        return activeShapeShadingType;
    }

    @Override
    public StartAndEndPointMode getActiveStartAndEndPointMode() {
        return activeStartAndEndPointMode;
    }

    private void setDefaults() {
        activeShapeType = ShapeType.ELLIPSE;
        activePrimaryColor = ShapeColor.BLUE;
        activeSecondaryColor = ShapeColor.GREEN;
        activeShapeShadingType = ShapeShadingType.FILLED_IN;
        activeStartAndEndPointMode = StartAndEndPointMode.DRAW;
    }
    
    
    /*
     * 
     * 
     * 
     */
    
    public void attach(BuilderObserver observer) {
    	observers.add(observer);
    }
    public void notifyAllObservers() {
    	for (BuilderObserver observer : observers) {
    		observer.update();
    	}
    }
}
