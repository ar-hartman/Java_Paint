package view.interfaces;

import view.EventName;

/*
 * Description: 
 * No changes from Instructor provided code.
 * 
 */

public interface IUiModule {
    void addEvent(EventName eventName, IEventCallback command);
    <T> T getDialogResponse(IDialogChoice dialogChoice);
}
