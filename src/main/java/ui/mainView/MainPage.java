package ui.mainView;

import ui.profile.ProfileContent;
import ui.settings.SettingsContent;
import ui.sidebar.Sidebar;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import ui.Page;
import model.User;

import java.io.IOException;
import java.util.Stack;

public class MainPage extends Page {

    private User loggedInUser;

    private Stack<CenterContent> contentsHistory;

    private Sidebar sidebar;

    private MainViewFXMLController mainViewFXMLController;

    private BorderPane borderPane;


    public MainPage(User user, String fxmlName) {
        super(fxmlName);
        loggedInUser = user;
        initialize();
    }


    public void initialize() {
        FXMLLoader mainFXMLLoader = new FXMLLoader();
        mainFXMLLoader.setLocation(getClass().getResource("./ui/mainView.fxml"));

        borderPane = null;
        try {
            borderPane = mainFXMLLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert borderPane != null;
        scene = new Scene(borderPane);

        mainViewFXMLController = mainFXMLLoader.getController();

        setSidebar();
        goToSettingsPage();
    }

    public Stack<CenterContent> getContentsHistory() {
        return contentsHistory;
    }

    public void setSidebar() {
        sidebar = new Sidebar(this, loggedInUser);
        sidebar.initialize(borderPane, mainViewFXMLController);
    }

    public void goToSettingsPage() {

        SettingsContent content = new SettingsContent(loggedInUser);
        content.initialize(borderPane, mainViewFXMLController);

    }

    public void goToProfile(User user) {
        if (user.equals(loggedInUser)) {
            goToSelfProfilePage();
        } else {
            goToProfilePage();
        }
    }

    private void goToProfilePage() {


    }

    private void goToSelfProfilePage() {
        ProfileContent content = new ProfileContent(this, loggedInUser);
    }

//    public void setCenterContent(FXMLLoader loader , BorderPane borderPane , MainViewFXMLController parentFXMLController){
//
//
//        CenterContentFXMLController centerContentFXMLController = loader.getController();
//        parentFXMLController.setCenterContentFXMLController(centerContentFXMLController);
//        centerContentFXMLController.setParentFXMLController(parent FXMLController);
//
//    }


    public void updateAll() {

        sidebar.update();
        for (CenterContent content : contentsHistory) {
            content.update();
        }
    }


}
