package listener.settings;

import event.settings.ComboBoxEvent;
import controller.settings.SettingsLogic;

public class ComboBoxListener {

    private SettingsLogic logic;

    public ComboBoxListener() {
        logic = new SettingsLogic();
    }

    public void eventOccurred(ComboBoxEvent event){
        if (event.getCommand().equals("changeAccountType")){
            logic.ChangeAccType(event);
        }
        if (event.getCommand().equals("changeLastSeen")) {
            logic.ChangeLastSeenType(event);
        }
    }

}
