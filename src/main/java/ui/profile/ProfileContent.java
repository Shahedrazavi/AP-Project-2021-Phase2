package ui.profile;

import ui.mainView.MainPage;
import ui.mainView.CenterContent;
import ui.mainView.MainViewFXMLController;
import javafx.scene.layout.BorderPane;
import model.User;

public class ProfileContent extends CenterContent {
    private MainPage mainPage;

    public ProfileContent(MainPage mainPage,User user) {
        super(user);
        this.mainPage= mainPage;
    }

    @Override
    public void initialize(BorderPane borderPane, MainViewFXMLController parentFXMLController) {

    }
}
