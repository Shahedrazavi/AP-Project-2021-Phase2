package ui;

import config.Config;
import db.Updatable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import model.User;

import java.io.IOException;
import java.net.URL;

public abstract class Component implements Updatable {
    protected FXMLController fxmlController;
    protected Parent root;
    protected Component parent;

    protected User loggedInUser;

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

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void setParent(Component parent){
        this.parent = parent;
    }

    public void initialize(){}

    public void update(){
    }

    public void updateApp(){
        parent.updateApp();
    }
}
