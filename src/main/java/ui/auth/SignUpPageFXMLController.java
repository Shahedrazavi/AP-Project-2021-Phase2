package ui.auth;

import event.auth.registration.RegistrationFormEvent;
import ui.auth.registration.RegistrationPage1FXMLController;
import ui.auth.registration.RegistrationPage2FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import ui.GraphicalAgent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpPageFXMLController implements Initializable {

    private GraphicalAgent graphicalAgent = GraphicalAgent.getInstance();

    private RegistrationPage1FXMLController page1FXMLController;
    private RegistrationPage2FXMLController page2FXMLController;

    @FXML
    private AnchorPane backButton;

    @FXML
    private AnchorPane registrationSection;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setBackButton();
        setRegistrationSection();
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

    public void setRegistrationSection(){
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("/ui/auth/registation/registrationPage1.fxml"));
            AnchorPane pane = loader.load();
            page1FXMLController = loader.getController();
            page1FXMLController.setParentPageFXMLController(this);
            registrationSection.getChildren().add(pane);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void goToPage2(RegistrationFormEvent primaryEvent){
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("/ui/auth/registation/registrationPage2.fxml"));
            AnchorPane pane = loader.load();
            page2FXMLController = loader.getController();
            page2FXMLController.setParentPageFXMLController(this);
            page2FXMLController.initializePrimaryEvent(primaryEvent);

            registrationSection.getChildren().get(0).setVisible(false);
            registrationSection.getChildren().add(pane);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void backToOpeningPage(){
        graphicalAgent.goToOpeningPage();
    }



}
