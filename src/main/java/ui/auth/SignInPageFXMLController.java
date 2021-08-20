package ui.auth;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import ui.FXMLController;
import ui.GraphicalAgent;
import model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInPageFXMLController extends FXMLController implements Initializable {

    private GraphicalAgent graphicalAgent = GraphicalAgent.getInstance();

    private SignInPage page;

    @FXML
    private AnchorPane signInCenter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void makeContents(){
        setSignInCenter();
    }

    public void setPage(SignInPage page) {
        this.page = page;
    }

    public void setSignInCenter() {
        signInCenter.getChildren().add(page.getSignInCenter().getRoot());
    }

    public void goToHomePage(User loggedInUser){
        graphicalAgent.startMainApp(loggedInUser);
    }

}
