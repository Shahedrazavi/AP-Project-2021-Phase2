package ui.component.tweetComponent.ui;

import ui.FXMLController;
import ui.component.tweetComponent.event.TweetEvent;
import ui.component.tweetComponent.listener.TweetComponentListener;
import ui.component.tweetComponent.logic.TweetComponentLogic;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class TweetComponentFXMLController extends FXMLController implements Initializable {

    private TweetComponentListener listener;

    private TweetComponentLogic logic;

    @FXML
    private ImageView profilePhoto;

    @FXML
    private ImageView tweetPhoto;


    @FXML
    private Label ProfileNameLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label tweetTextLabel;

    @FXML
    private Label replyingToLabel;

    @FXML
    private Label retweetedLabel;

    @FXML
    private Button muteButton;

    @FXML
    private Button blockButton;

    @FXML
    private Button viewProfileButton;

    @FXML
    private Button likeButton;

    @FXML
    private Button commentButton;

    @FXML
    private Button retweetButton;

    @FXML
    private Button viewCommentsButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button forwardButton;

    @FXML
    private Button reportButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        profilePhoto.setPickOnBounds(true); // allows click on transparent areas
        profilePhoto.setOnMouseClicked((MouseEvent e) -> {
            System.out.println("Clicked!"); // change functionality
            viewTweetPhotoPressed();
        });



    }

    public void initializeButtons(){
        if (logic.isMuted()){
            muteButton.setDisable(true);
        }
        if (logic.isBlocked()){
            blockButton.setDisable(true);
        }
//        if (logic.isReported()){
//            reportButton.setDisable(true);
//        }
//        if (logic.isRetweeted()){
//            retweetButton.setDisable(true);
//        }
    }

    public void initializeLogic(TweetComponentLogic logic){
        this.logic = logic;
    }

    public void initializeListener(){
        listener = new TweetComponentListener(logic);
    }

    @FXML
    void blockPressed(ActionEvent event) {
        listener.eventOccurred(new TweetEvent(this,"blockPressed"));
    }

    @FXML
    void commentPressed(ActionEvent event) {
        listener.eventOccurred(new TweetEvent(this,"commentPressed"));
    }

    @FXML
    void forwardPressed(ActionEvent event) {
        listener.eventOccurred(new TweetEvent(this,"forwardPressed"));
    }

    @FXML
    void likePressed(ActionEvent event) {
        listener.eventOccurred(new TweetEvent(this,"likePressed"));
    }

    @FXML
    void mutePressed(ActionEvent event) {
        listener.eventOccurred(new TweetEvent(this,"mutePressed"));
    }

    @FXML
    void reportPressed(ActionEvent event) {
        listener.eventOccurred(new TweetEvent(this,"reportPressed"));
    }

    @FXML
    void retweetPressed(ActionEvent event) {
        listener.eventOccurred(new TweetEvent(this,"retweetPressed"));
    }

    @FXML
    void savePressed(ActionEvent event) {
        listener.eventOccurred(new TweetEvent(this,"savePressed"));
    }

    @FXML
    void viewCommentsPressed(ActionEvent event) {
        listener.eventOccurred(new TweetEvent(this,"viewCommentsPressed"));
    }

    @FXML
    void viewProfilePressed(ActionEvent event) {
        listener.eventOccurred(new TweetEvent(this,"viewProfilePressed"));
    }

    void viewTweetPhotoPressed(){
        listener.eventOccurred(new TweetEvent(this,"viewTweetPhotoPressed"));
    }
}
