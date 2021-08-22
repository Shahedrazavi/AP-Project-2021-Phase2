package ui.sidebar;

import ui.Component;
import ui.mainView.MainPage;
import model.User;

public class Sidebar extends Component {

    public Sidebar(String fxmlName, MainPage parent , User user) {
        super(fxmlName);
        setParent(parent);
        setLoggedInUser(user);
        initialize();
    }

    @Override
    public void initialize() {
        SidebarFXMLController controller = (SidebarFXMLController)fxmlController;
        controller.setComponent(this);
        update();
    }

    @Override
    public void update() {
        ((SidebarFXMLController)fxmlController).hideOrUnhideButtons();
    }

    public void exitToHomePage(){
        ((MainPage)parent).exit();
    }

    public void goBack(){
        ((MainPage)parent).goBack();
    }

    public void goToSelfProfile(){
        ((MainPage)parent).goToSelfProfilePage();
    }

    public void goToSettings(){
        ((MainPage)parent).goToSettingsPage();
    }

    public void goToNewTweet(){
        ((MainPage)parent).goToNewTweetPage();
    }

}
