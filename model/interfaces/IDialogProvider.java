package model.interfaces;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.StartAndEndPointMode;
import view.interfaces.IDialogChoice;

/*
 * Description: 
 * No changes from Instructor provided code.
 * 
 */

public interface IDialogProvider {

    IDialogChoice<ShapeType> getChooseShapeDialog();

    IDialogChoice<ShapeColor> getChoosePrimaryColorDialog();

    IDialogChoice<ShapeColor> getChooseSecondaryColorDialog();

    IDialogChoice<ShapeShadingType> getChooseShadingTypeDialog();

    IDialogChoice<StartAndEndPointMode> getChooseStartAndEndPointModeDialog();
}
