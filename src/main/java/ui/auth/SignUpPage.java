package ui.auth;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import ui.Page;

import java.io.IOException;

public class SignUpPage extends Page {

    public SignUpPage(String fxmlName) {
        super(fxmlName);
    }

    public void initialize() {
        Parent root = null;
        try {
//            System.out.println(getClass().getResource("signUpPage.fxml"));
            root = FXMLLoader.load(getClass().getResource("signUpPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        scene = new Scene(root);
    }
}
