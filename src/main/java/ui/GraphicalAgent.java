package ui;

import javafx.scene.layout.StackPane;
import ui.auth.SignInPage;
import ui.auth.SignUpPage;
import ui.mainView.MainPage;
import event.Event;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;
import ui.opening.OpeningPage;

import java.util.Stack;

public class GraphicalAgent {
    private static GraphicalAgent instance;

    private Stack<Scene> sceneStack;

    private Stage stage;
    private Scene scene;

    public static GraphicalAgent getInstance(){
        if (instance==null){
            instance = new GraphicalAgent();
        }
        return instance;
    }

    private GraphicalAgent() {
        this.sceneStack = new Stack<>();
    }

    public void initialize(){
        OpeningPage openingPage = new OpeningPage("opening");
        stage = new MainStage();
        scene = openingPage.getScene();
        sceneStack.add(scene);
        stage.setScene(scene);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public void goToSignIn(Event event){
        SignInPage signInPage = new SignInPage("signIn");
        scene = signInPage.getScene();
        sceneStack.add(scene);
        stage.setScene(scene);
    }

    public void goToSignUp(Event event){
        SignUpPage signUpPage = new SignUpPage("signUp");
        scene = signUpPage.getScene();
        sceneStack.add(scene);
        stage.setScene(scene);
    }

    public void goToOpeningPage(){
        sceneStack.pop();
        scene = sceneStack.peek();
        stage.setScene(scene);
    }

    public void startMainApp(User user){
        MainPage mainPage = new MainPage(user,"main");
        sceneStack.pop();
        scene = mainPage.getScene();
        sceneStack.add(scene);
        stage.setScene(scene);
    }

    public void removeLastScene(){
        sceneStack.pop();
    }

}
