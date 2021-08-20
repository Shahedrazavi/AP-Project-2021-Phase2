package ui.auth;

import javafx.fxml.Initializable;
import ui.FXMLController;
import ui.GraphicalAgent;
import model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInPageFXMLController extends FXMLController implements Initializable {

    private GraphicalAgent graphicalAgent = GraphicalAgent.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    public void goToHomePage(User loggedInUser){
        graphicalAgent.startMainApp(loggedInUser);
    }

}
