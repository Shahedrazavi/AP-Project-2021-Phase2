package ui.sidebar;

import ui.mainView.MainPage;
import ui.mainView.CenterContent;
import ui.mainView.MainViewFXMLController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import model.User;

import java.io.IOException;

public class Sidebar extends CenterContent {

    private MainPage mainPage;

    private SidebarFXMLController sidebarFXMLController;

    public Sidebar(MainPage mainPage,User user) {
        super(user);
        this.mainPage = mainPage;
    }


    @Override
    public void initialize(BorderPane borderPane, MainViewFXMLController parentFXMLController) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/ui/sidebar/sidebar.fxml"));

        AnchorPane anchorPane = null;

        try {
            anchorPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert anchorPane != null;
        borderPane.setLeft(anchorPane);

        sidebarFXMLController = loader.getController();
        sidebarFXMLController.setSidebar(this);
        parentFXMLController.setSidebarFXMLController(sidebarFXMLController);
        sidebarFXMLController.setParentFXMLController(parentFXMLController);
        update();

    }

    @Override
    public void update() {
        sidebarFXMLController.hideButtons();
    }
}
