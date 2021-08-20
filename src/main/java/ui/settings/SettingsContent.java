package ui.settings;

import ui.mainView.CenterContent;
import ui.mainView.CenterContentFXMLController;
import ui.mainView.MainViewFXMLController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import model.User;

import java.io.IOException;

public class SettingsContent extends CenterContent {

    public SettingsContent(User user) {
        super(user);
    }

    @Override
    public void initialize(BorderPane borderPane, MainViewFXMLController parentFXMLController) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/ui/settings/settings.fxml"));

        AnchorPane anchorPane = null;
        try {
            anchorPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert anchorPane != null;
        borderPane.setCenter(anchorPane);

        CenterContentFXMLController centerContentFXMLController = loader.getController();
        parentFXMLController.setCenterContentFXMLController(centerContentFXMLController);
        centerContentFXMLController.setParentFXMLController(parentFXMLController);
        ((SettingsFXMLController) centerContentFXMLController).setCenterContent(this);
    }
}
