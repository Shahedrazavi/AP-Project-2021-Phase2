package ui.component.tweetViewer;

import controller.component.tweetViewer.TweetViewerLogic;
import event.component.tweetViewer.TweetViewerEvent;
import listener.component.tweetViewer.TweetViewerListener;
import ui.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class TweetViewerFXMLController extends FXMLController implements Initializable {

    private TweetViewerLogic logic;

    private TweetViewerListener listener;

    @FXML
    private AnchorPane componentPane;

    @FXML
    private Label emptyLabel;

    @FXML
    private Button previousButton;

    @FXML
    private Button nextButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emptyLabel.setVisible(false);
    }

    public void initializeLogic(TweetViewerLogic logic){
        this.logic = logic;
    }

    public void initializeListener(){
        listener = new TweetViewerListener(logic);
    }

    public void disableButtons(){
        previousButton.setDisable(true);
        previousButton.setDisable(true);
    }

    public void showEmptyLabel(){
        emptyLabel.setVisible(true);
    }

    @FXML
    void nextPressed(ActionEvent event) {
        listener.EventOccurred(new TweetViewerEvent(this,"nextPressed"));
    }

    @FXML
    void previousPressed(ActionEvent event) {
        listener.EventOccurred(new TweetViewerEvent(this,"previousPressed"));
    }
}