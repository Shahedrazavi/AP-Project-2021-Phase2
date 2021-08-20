package ui.auth.registration;

import ui.auth.SignUpPageFXMLController;
import event.auth.registration.RegistrationFormEvent;
import listener.auth.registration.RegistrationFormListener1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegistrationPage1FXMLController implements Initializable {

    private RegistrationFormListener1 listener;

    private LinkedList<Label> firstPageEmptyErrors = new LinkedList<>();

    private SignUpPageFXMLController parentPageFXMLController;

    @FXML
    private Label enterInformationLabel;

    @FXML
    private Label willBeUsernameLabel;

    @FXML
    private TextField firstNameBox;

    @FXML
    private TextField lastNameBox;

    @FXML
    private TextField emailBox;

    @FXML
    private TextField usernameBox;

    @FXML
    private TextField passwordBox;

    @FXML
    private TextField passwordConfirmationBox;

    @FXML
    private Button proceedButton;

    @FXML
    private Label emailError;

    @FXML
    private Label usernameError;

    @FXML
    private Label passwordError;

    @FXML
    private Label firstNameEmpty;

    @FXML
    private Label lastNameEmpty;

    @FXML
    private Label emailEmpty;

    @FXML
    private Label usernameEmpty;

    @FXML
    private Label passwordEmpty;

    @FXML
    private Label password2Empty;

    public Label getEmailError() {
        return emailError;
    }

    public Label getUsernameError() {
        return usernameError;
    }

    public Label getPasswordError() {
        return passwordError;
    }

    public Label getFirstNameEmpty() {
        return firstNameEmpty;
    }

    public Label getLastNameEmpty() {
        return lastNameEmpty;
    }

    public Label getEmailEmpty() {
        return emailEmpty;
    }

    public Label getUsernameEmpty() {
        return usernameEmpty;
    }

    public Label getPasswordEmpty() {
        return passwordEmpty;
    }

    public Label getPassword2Empty() {
        return password2Empty;
    }

    @FXML
    void proceedPressed(ActionEvent event) {
        String firstName = firstNameBox.getText();
        String lastName = lastNameBox.getText();
        String email = emailBox.getText();
        String username = usernameBox.getText();
        String password1 = passwordBox.getText();
        String password2 = passwordConfirmationBox.getText();
        RegistrationFormEvent formEvent = new RegistrationFormEvent(this, firstName,lastName,email,username,password1,password2);
        listener.eventOccurred(formEvent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailError.setVisible(false);
        usernameError.setVisible(false);
        passwordError.setVisible(false);
        firstNameEmpty.setVisible(false);
        lastNameEmpty.setVisible(false);
        emailEmpty.setVisible(false);
        usernameEmpty.setVisible(false);
        passwordEmpty.setVisible(false);
        password2Empty.setVisible(false);

        listener = new RegistrationFormListener1();

        firstPageEmptyErrors.add(firstNameEmpty);
        firstPageEmptyErrors.add(lastNameEmpty);
        firstPageEmptyErrors.add(emailEmpty);
        firstPageEmptyErrors.add(usernameEmpty);
        firstPageEmptyErrors.add(passwordEmpty);
        firstPageEmptyErrors.add(password2Empty);

    }

    public void showLabel(Label label){
        label.setVisible(true);
    }
    public void hideLabel(Label label){
        label.setVisible(false);
    }

    public LinkedList<Label> getFirstPageEmptyErrors() {
        return firstPageEmptyErrors;
    }

    public void setParentPageFXMLController(SignUpPageFXMLController parentPageFXMLController) {
        this.parentPageFXMLController = parentPageFXMLController;
    }

    public void goToPage2(RegistrationFormEvent event){
        parentPageFXMLController.goToPage2(event);
    }
}
