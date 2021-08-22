package ui.settings;

import ui.Component;
import ui.mainView.MainPage;
import model.User;

public class Settings extends Component {

    public Settings(String fxmlName, MainPage parent , User user) {
        super(fxmlName);
        setParent(parent);
        setLoggedInUser(user);
        initialize();
    }

    @Override
    public void initialize() {
        SettingsFXMLController controller = (SettingsFXMLController)fxmlController;
        controller.setComponent(this);
        update();
    }
}
