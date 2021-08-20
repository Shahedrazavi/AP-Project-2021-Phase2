package ui.settings;

import ui.FXMLController;
import ui.mainView.CenterContent;
import ui.mainView.CenterContentFXMLController;
import ui.mainView.MainViewFXMLController;
import event.settings.ChangePassEvent;
import event.settings.ComboBoxEvent;
import event.settings.SettingsStringEvent;
import listener.settings.ChangePassListener;
import listener.settings.ComboBoxListener;
import listener.settings.SettingsListener;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SettingsFXMLController extends FXMLController implements Initializable, CenterContentFXMLController {

    private CenterContent centerContent;

    private ComboBoxListener comboBoxListener;

    private SettingsListener settingsListener;

    private ChangePassListener changePassListener;

    private MainViewFXMLController parentFXMLController;

    @FXML
    private AnchorPane backButton;

    @FXML
    private Label settingsLabel;

    @FXML
    private Label authenticationLabel;

    @FXML
    private Label currentPassLabel;

    @FXML
    private Label newPassLabel;

    @FXML
    private Label privacyLabel;

    @FXML
    private Label accountTypeLabel;

    @FXML
    private Label lastSeenLabel;

    @FXML
    private Button changPassButton;

    @FXML
    private Button deactivateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button saveAccountTypeButton;

    @FXML
    private Button saveLastSeenButton;

    @FXML
    private ComboBox<String> accountTypeBox;

    @FXML
    private ComboBox<String> lastSeenBox;

    @FXML
    private TextField currentPassBox;

    @FXML
    private TextField newPassBox;

    @FXML
    private Label passErrorLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        accountTypeBox.getItems().addAll("Public"
                ,"Private");
        lastSeenBox.getItems().addAll("Everyone can see",
                "Only following can see",
                "No one can see");

        comboBoxListener = new ComboBoxListener();
        settingsListener = new SettingsListener();
        changePassListener = new ChangePassListener();

        passErrorLabel.setVisible(false);
    }

    public Label getPassErrorLabel() {
        return passErrorLabel;
    }

    @Override
    public void setParentFXMLController(MainViewFXMLController parentFXMLController) {
        this.parentFXMLController = parentFXMLController;
    }

    public void setCenterContent(CenterContent centerContent) {
        this.centerContent = centerContent;
    }

    @FXML
    void changePassPressed(ActionEvent event) {
        changePassListener.eventOccurred(new ChangePassEvent(this,
                centerContent.getUser(),
                currentPassBox.getText(),
                newPassBox.getText()));
    }

    @FXML
    void saveAccountTypePressed(ActionEvent event) {
        String selectedOption = accountTypeBox.getValue();
        comboBoxListener.eventOccurred(new ComboBoxEvent(this,
                centerContent.getUser(),
                "changeAccountType",
                selectedOption));
    }

    @FXML
    void saveLastSeenPressed(ActionEvent event) {
        String selectedOption = lastSeenBox.getValue();
        comboBoxListener.eventOccurred(new ComboBoxEvent(this,
                centerContent.getUser(),
                "changeLastSeen",
                selectedOption));
    }

    @FXML
    void deactivatePressed(ActionEvent event) {
        settingsListener.eventOccurred(new SettingsStringEvent(this, centerContent.getUser(), "deactivate"));
    }

    @FXML
    void deletePressed(ActionEvent event) {
        settingsListener.eventOccurred(new SettingsStringEvent(this, centerContent.getUser(), "delete"));

    }



}
