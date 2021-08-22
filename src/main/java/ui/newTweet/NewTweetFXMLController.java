package ui.newTweet;

import event.newTweet.NewTweetEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import listener.newTweet.NewTweetListener;
import ui.FXMLController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class NewTweetFXMLController extends FXMLController {

    private NewTweetListener listener;

    private BufferedImage tweetBufferedImage;

    private NewTweet component;

    @FXML
    private TextArea tweetText;

    @FXML
    private Button fileChooser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listener = new NewTweetListener();
    }

    @FXML
    void choosePressed(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
            fileChooser.getExtensionFilters().addAll(extFilterPNG);
            File file = fileChooser.showOpenDialog(null);
            tweetBufferedImage = ImageIO.read(file);
        }
        catch (Throwable ignored) {
        }
    }

    @FXML
    void tweetButtonPressed(ActionEvent event) {
        listener.eventOccurred(new NewTweetEvent(this,"tweet",tweetText.getText(),tweetBufferedImage, component.getLoggedInUser()));
    }

    public void setComponent(NewTweet component) {
        this.component = component;
    }
}
