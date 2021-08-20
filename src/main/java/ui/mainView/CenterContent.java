package ui.mainView;

import db.Updatable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import model.User;

public class CenterContent implements Updatable {
    protected User user;
    protected AnchorPane anchorPane;

    public CenterContent() {
    }

    public CenterContent(User user){
        this.user = user;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void initialize(BorderPane borderPane , MainViewFXMLController parentFXMLController){

    }

    public User getUser() {
        return user;
    }

    @Override
    public void update() {

    }
}
