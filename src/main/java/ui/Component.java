package ui;

import config.Config;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;

public class Component {
    protected FXMLController fxmlController;
    protected Parent root;
    protected Component parent;

    public Component(String fxmlName) {
        URL url = getClass().getResource(Config.getConfig("fxmls").getProperty(fxmlName));
        System.out.println(url);
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        System.out.println(fxmlLoader);
        try {
            root = fxmlLoader.load();
//            System.out.println(root!=null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert root!=null;

        fxmlController = fxmlLoader.getController();
    }

    public FXMLController getFxmlController() {
        return fxmlController;
    }

    public Parent getRoot() {
        return root;
    }

    public Component getParent() {
        return parent;
    }

    public void setParent(Component parent){
        this.parent = parent;
    }

    public void initialize(){}
}
