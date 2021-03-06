package ui.mainView;

import ui.Component;
import ui.GraphicalAgent;
import ui.newTweet.NewTweet;
import ui.profile.Profile;
import ui.settings.Settings;
import ui.sidebar.Sidebar;
import ui.Page;
import model.User;
import util.Logger;

import java.util.Stack;

public class MainPage extends Page {

    private GraphicalAgent graphicalAgent = GraphicalAgent.getInstance();

    private Stack<Component> componentHistory;

    private Component sidebar;

    private Component centerComp;

    public MainPage(User loggedInUser, String fxmlName) {
        super(fxmlName);
        setLoggedInUser(loggedInUser);
        componentHistory = new Stack<>();
        initialize();
    }


    public void initialize() {
        MainViewFXMLController controller= (MainViewFXMLController)fxmlController;
        controller.setPage(this);

        sidebar = new Sidebar("sidebar",this, loggedInUser);
        centerComp = new Settings("settings",this, loggedInUser);
        componentHistory.add(centerComp);
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

    private void addNewCenterComp(){
        componentHistory.add(centerComp);
        ((MainViewFXMLController)fxmlController).setContentSection();
    }

    public void goToSettingsPage() {
        centerComp = new Settings("settings",this,loggedInUser);
        addNewCenterComp();
    }

    public void goToProfile(User user) {
        if (user.equals(loggedInUser)) {
            goToSelfProfilePage();
        } else {
            goToProfilePage(user);
        }
    }

    public void goToSelfProfilePage() {
        centerComp = new Profile("profile",this, loggedInUser);
        addNewCenterComp();
    }

    public void goToProfilePage(User user) {
        centerComp = new Profile("sidebar",this, user);
        addNewCenterComp();
    }

    public void goToNewTweetPage(){
        centerComp = new NewTweet("newTweet",this, loggedInUser);
        addNewCenterComp();
    }

    public void exit(){
        graphicalAgent.goToOpeningPage();
        Logger.getLogger().logOut(loggedInUser.getUsername(),loggedInUser.getId().toString());
    }

    public void goBack(){
        if (componentHistory.size()>1){
            componentHistory.pop();
            centerComp = componentHistory.peek();
            centerComp.update();
            ((MainViewFXMLController)fxmlController).setContentSection();
        }
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
