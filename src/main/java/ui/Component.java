package ui;

import config.Config;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;

public class Component {
    protected FXMLController fxmlController;
    protected Scene scene;
    protected Component parent;

    public Component(String fxmlName) {
        URL url = getClass().getResource(Config.getConfig("fxmls").getProperty(fxmlName));
//        System.out.println(url);
        FXMLLoader fxmlLoader = new FXMLLoader(url);

        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        fxmlController = fxmlLoader.getController();
    }

    public FXMLController getFxmlController() {
        return fxmlController;
    }

    public Scene getScene() {
        return scene;
    }

    public void setParent(Component parent){
        this.parent = parent;
    }
}
