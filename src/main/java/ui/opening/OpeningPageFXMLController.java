package ui.opening;

import java.net.URL;
import java.util.ResourceBundle;

import event.StringEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import listener.OpeningListener;
import listener.StringListener;
import ui.FXMLController;

public class OpeningPageFXMLController extends FXMLController implements Initializable {

    private StringListener openingListener;
    
    @FXML
    private Label label;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        openingListener = new OpeningListener();
    }

    @FXML
    void signInPressed(ActionEvent event) {
        openingListener.eventOccurred(new StringEvent(this,"signingIn"));
    }

    @FXML
    void signUpPressed(ActionEvent event) {
        openingListener.eventOccurred(new StringEvent(this,"registration"));
    }


}