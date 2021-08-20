package ui.auth;

import javafx.fxml.FXML;
import ui.Component;
import ui.auth.signIn.SignInCenter;
import ui.auth.signIn.SignInCenterFXMLController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import ui.Page;

import java.io.IOException;

public class SignInPage extends Page {

    @FXML
    private Component signInCenter;

    public SignInPage(String fxmlName) {
        super(fxmlName);
        initialize();
    }

    @Override
    public void initialize() {
        SignInPageFXMLController controller = (SignInPageFXMLController)fxmlController;
        signInCenter = new SignInCenter("signInCenter", this);
        controller.setPage(this);
        controller.makeContents();
    }

    public Component getSignInCenter() {
        return signInCenter;
    }


//        @Override
//    public void initialize() {
//        FXMLLoader mainFxmlLoader = new FXMLLoader();
//        mainFxmlLoader.setLocation(getClass().getResource("signInPage.fxml"));
//        BorderPane borderPane = null;
////        Parent root = null;
//        try {
////            mainFxmlLoader.setLocation(getClass().getResource("signInPage.fxml"));
//            borderPane = mainFxmlLoader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        assert borderPane != null;
//        scene = new Scene(borderPane);
//
//        FXMLLoader centerFXMLLoader = new FXMLLoader();
//        centerFXMLLoader.setLocation(getClass().getResource("/ui/auth/signIn/signInCenter.fxml"));
//        AnchorPane centerPane = null;
//        try {
//            centerPane = centerFXMLLoader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        borderPane.setCenter(centerPane);
//
//        SignInCenterFXMLController centerFXMLController = centerFXMLLoader.getController();
//        SignInPageFXMLController signInPageFXMLController = mainFxmlLoader.getController();
//
//        if (signInPageFXMLController == null){
//            System.out.println("WTF");
//        }
//        centerFXMLController.setParentPageFXMLController(signInPageFXMLController);
////        scene = new Scene(root);
//
//
//
//
//    }
}
