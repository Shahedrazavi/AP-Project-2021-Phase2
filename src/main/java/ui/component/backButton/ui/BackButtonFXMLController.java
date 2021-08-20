package ui.component.backButton.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import ui.FXMLController;
import ui.GraphicalAgent;

import java.net.URL;
import java.util.ResourceBundle;

public class BackButtonFXMLController extends FXMLController implements Initializable {

    private GraphicalAgent graphicalAgent = GraphicalAgent.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private Button backButton;

    @FXML
    void backPressed(ActionEvent event) {
        graphicalAgent.goToOpeningPage();
    }
}
