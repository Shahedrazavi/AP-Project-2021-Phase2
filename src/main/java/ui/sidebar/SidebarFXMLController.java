package ui.sidebar;

import ui.mainView.MainViewFXMLController;
import listener.sidebar.SidebarListener;
import event.StringEvent;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SidebarFXMLController implements Initializable {

    private Sidebar sidebar;

    private MainViewFXMLController parentFXMLController;

    private SidebarListener listener;

    @FXML
    private Button bookmarksButton;

    @FXML
    private Button timelineButton;

    @FXML
    private Button exploreButton;

    @FXML
    private Button notifsButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button messagesButton;

    @FXML
    private Button profileButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button tweetButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listener = new SidebarListener();
    }

    public void hideButtons(){
        if(!sidebar.getUser().isActive()){
            bookmarksButton.setDisable(true);
            timelineButton.setDisable(true);
            tweetButton.setDisable(true);
        }
    }

    @FXML
    void bookmarksPressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "bookmarks"));
    }

    @FXML
    void explorePressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "explore"));
    }

    @FXML
    void homePressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "home"));
    }

    @FXML
    void logoutPressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "logout"));
    }

    @FXML
    void messagesPressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "messages"));
    }

    @FXML
    void notifsPressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "notifs"));
    }

    @FXML
    void profilePressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "profile"));
    }

    @FXML
    void searchPressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "search"));
    }

    @FXML
    void settingsPressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "settings"));
    }

    @FXML
    void tweetPressed(ActionEvent event) {
        listener.eventOccurred(new StringEvent(this, "tweet"));
    }

    public void setParentFXMLController(MainViewFXMLController parentFXMLController) {
        this.parentFXMLController = parentFXMLController;
    }

    public void setSidebar(Sidebar sidebar) {
        this.sidebar = sidebar;
    }
}
