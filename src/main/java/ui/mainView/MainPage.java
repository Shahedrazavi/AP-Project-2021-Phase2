package ui.mainView;

import ui.Component;
import ui.GraphicalAgent;
import ui.profile.Profile;
import ui.settings.Settings;
import ui.sidebar.Sidebar;
import ui.Page;
import model.User;

import java.util.Stack;

public class MainPage extends Page {

    private GraphicalAgent graphicalAgent = GraphicalAgent.getInstance();

    private Stack<Component> componentHistory;

    private Component sidebar;

    private Component centerComp;

    public MainPage(User loggedInUser, String fxmlName) {
        super(fxmlName);
        this.loggedInUser = loggedInUser;
        initialize();
    }


    public void initialize() {
        MainViewFXMLController controller= (MainViewFXMLController)fxmlController;
        sidebar = new Sidebar("sidebar",this, loggedInUser);
        centerComp = new Settings("settings",this, loggedInUser);
        controller.setPage(this);
        controller.makeContents();
    }

    public Component getSidebar() {
        return sidebar;
    }

    public Component getCenterComp() {
        return centerComp;
    }

    public Stack<Component> getComponentHistory() {
        return componentHistory;
    }

//    public void goToSettingsPage() {
//
//        SettingsContent content = new SettingsContent(loggedInUser);
//        content.initialize(borderPane, mainViewFXMLController);
//
//    }

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
        Profile content = new Profile("profile",this, loggedInUser);
    }

    public void deleteAndExit(){
        graphicalAgent.goToOpeningPage();
    }


    public void updateAll() {

        sidebar.update();
        for (Component component : componentHistory) {
            component.update();
        }
    }

    @Override
    public void updateApp() {
        sidebar.update();
        centerComp.update();
    }
}
