package ui.auth;

import event.auth.registration.RegistrationFormEvent;
import ui.FXMLController;
import ui.auth.registration.RegistrationPage1FXMLController;
import ui.auth.registration.RegistrationPage2FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import ui.GraphicalAgent;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpPageFXMLController extends FXMLController implements Initializable {

    private GraphicalAgent graphicalAgent = GraphicalAgent.getInstance();

    private SignUpPage page;

    @FXML
    private AnchorPane backButton;

    @FXML
    private AnchorPane registrationSection;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void makeContents(){
        setBackButton();
        setRegistrationSection();
    }

    public void setPage(SignUpPage page) {
        this.page = page;
    }

    public void setBackButton(){
        backButton.getChildren().add(page.getBackButton().getRoot());
    }

    public void setRegistrationSection(){
        registrationSection.getChildren().add(page.getPage1().getRoot());
    }

    public void goToPage2(RegistrationFormEvent primaryEvent){
        registrationSection.getChildren().get(0).setVisible(false);
        registrationSection.getChildren().add(page.getPage2().getRoot());
        ((RegistrationPage2FXMLController)page.getPage2().getFxmlController()).initializePrimaryEvent(primaryEvent);
    }

    public void backToOpeningPage(){
        graphicalAgent.goToOpeningPage();
    }

}
