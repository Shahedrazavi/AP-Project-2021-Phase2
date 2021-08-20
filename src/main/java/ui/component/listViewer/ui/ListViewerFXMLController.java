package ui.component.listViewer.ui;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ListViewerFXMLController implements Initializable {

    @FXML
    private AnchorPane componentPane;

    @FXML
    private Button previousButton;

    @FXML
    private Button nextButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void nextPressed(ActionEvent event) {

    }

    @FXML
    void previousPressed(ActionEvent event) {

    }
}
