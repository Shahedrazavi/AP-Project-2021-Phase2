package listener.settings;

import event.settings.SettingsStringEvent;
import controller.settings.SettingsLogic;

public class SettingsListener {

    private SettingsLogic logic;

    public SettingsListener() {
        logic = new SettingsLogic();
    }

    public void eventOccurred(SettingsStringEvent event) {
        if (event.getCommand().equals("delete")) {
            logic.deleteAcc(event.getUser());
        }
        if (event.getCommand().equals("deactivate")) {
            logic.changeActivate(event.getUser());
        }
    }
}
