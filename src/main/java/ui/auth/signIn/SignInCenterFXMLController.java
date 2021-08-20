package ui.auth.signIn;

import ui.FXMLController;
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

public class SignInCenterFXMLController extends FXMLController implements Initializable {

    SignInFormListener listener;

    private SignInCenter component;

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

        listener = new SignInFormListener();
    }

    @Override
    public void makeContents() {
        setBackButton();
    }

    public void setBackButton(){
        backButton.getChildren().add(component.getBackButton().getRoot());
    }

    public void setComponent(SignInCenter component) {
        this.component = component;
    }

    @FXML
    void signInPressed(ActionEvent event) {
        listener.eventOccurred(new SignInFormEvent(this,usernameBox.getText(), passwordBox.getText()));
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    public void goToHomePage(User loggedInUser){
        ((SignInPageFXMLController)component.getParent().getFxmlController()).goToHomePage(loggedInUser);
    }
}
