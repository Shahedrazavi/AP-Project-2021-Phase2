package ui.component.tweetComponent;


import controller.component.tweetComponent.TweetComponentLogic;
import ui.component.tweetViewer.TweetViewer;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.Tweet;
import model.User;

import java.io.IOException;

public class TweetComponent {
    private Tweet tweet;
    private User loggedInUser;
    private TweetComponentLogic logic;

    private TweetViewer tweetViewer;

    public TweetComponent(TweetViewer tweetViewer,Tweet tweet , User loggedInUser) {
        this.tweet = tweet;
        this.loggedInUser = loggedInUser;
        this.tweetViewer = tweetViewer;
    }

    public void initialize(AnchorPane anchorPane){
        setupLogic();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("component/tweetComponent/ui/tweetComponent.fxml"));

        AnchorPane component = null;
        try {
            component = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert component != null;

        anchorPane.getChildren().add(component);

        TweetComponentFXMLController tweetComponentFXMLController = loader.getController();
        tweetComponentFXMLController.initializeLogic(logic);
        tweetComponentFXMLController.initializeListener();
        tweetComponentFXMLController.initializeButtons();


    }

    public void setupLogic(){
        logic = new TweetComponentLogic(this,tweet,loggedInUser);
    }

    public void goToProfile(User user){
        tweetViewer.goToProfile(user);
    }

}
