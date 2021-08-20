package ui.auth.signIn;

import ui.auth.SignInPageFXMLController;
import event.auth.signIn.SignInFormEvent;
import listener.auth.signIn.SignInFormListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.User;

public class SignInCenterFXMLController implements Initializable {

    SignInFormListener listener;

    private SignInPageFXMLController parentPageFXMLController;

    @FXML
    private AnchorPane backButton;

    @FXML
    private Label signInLabel;

    @FXML
    private Button signInButton;

    @FXML
    private TextField usernameBox;

    @FXML
    private TextField passwordBox;

    @FXML
    private Label errorLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorLabel.setVisible(false);
        setBackButton();

        listener = new SignInFormListener();
    }

    public void setParentPageFXMLController(SignInPageFXMLController parentPageFXMLController) {
        this.parentPageFXMLController = parentPageFXMLController;
    }

    public void setBackButton(){
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("/component/backButton/ui/backButton.fxml"));
            AnchorPane pane = loader.load();
            backButton.getChildren().add(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void signInPressed(ActionEvent event) {
        listener.eventOccurred(new SignInFormEvent(this,usernameBox.getText(), passwordBox.getText()));
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    public void goToHomePage(User loggedInUser){
        parentPageFXMLController.goToHomePage(loggedInUser);
    }
}
