package listener.settings;

import event.settings.ChangePassEvent;
import controller.settings.SettingsLogic;

public class ChangePassListener {

    private SettingsLogic logic;

    public ChangePassListener() {
        logic = new SettingsLogic();
    }

    public void eventOccurred(ChangePassEvent event){
        logic.checkForChangingPass(event);
    }
}
