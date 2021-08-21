package ui.settings;

import ui.Component;
import ui.mainView.CenterContent;
import ui.mainView.CenterContentFXMLController;
import ui.mainView.MainPage;
import ui.mainView.MainViewFXMLController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import model.User;

import java.io.IOException;

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
