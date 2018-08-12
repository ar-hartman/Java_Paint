package view.interfaces;

/*
 * Description: 
 * No changes from Instructor provided code.
 * 
 */

public interface IDialogChoice<T> {
    String getDialogTitle();

    String getDialogText();

    T[] getDialogOptions();

    T getCurrentSelection();
}
