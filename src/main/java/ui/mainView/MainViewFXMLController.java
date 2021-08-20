package ui.mainView;

import ui.FXMLController;
import ui.sidebar.SidebarFXMLController;
import javafx.fxml.Initializable;
import ui.GraphicalAgent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewFXMLController extends FXMLController implements Initializable {

    private GraphicalAgent graphicalAgent = GraphicalAgent.getInstance();

    private SidebarFXMLController sidebarFXMLController;

    private CenterContentFXMLController centerContentFXMLController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setSidebarFXMLController(SidebarFXMLController sidebarFXMLController) {
        this.sidebarFXMLController = sidebarFXMLController;
    }

    public void setCenterContentFXMLController(CenterContentFXMLController centerContentFXMLController) {
        this.centerContentFXMLController = centerContentFXMLController;
    }
}
