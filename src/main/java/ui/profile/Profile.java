package ui.profile;

import ui.Component;
import ui.mainView.MainPage;
import ui.mainView.CenterContent;
import ui.mainView.MainViewFXMLController;
import javafx.scene.layout.BorderPane;
import model.User;

public class Profile extends Component {

    public Profile(String fxmlName, MainPage parent , User user) {
        super(fxmlName);
        setParent(parent);
        setLoggedInUser(user);
        initialize();
    }

//    @Override
//    public void initialize(BorderPane borderPane, MainViewFXMLController parentFXMLController) {
//
//    }
}
