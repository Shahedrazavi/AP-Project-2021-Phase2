package ui.component.tweetViewer;

import controller.component.tweetViewer.TweetViewerLogic;
import ui.mainView.MainPage;
import ui.component.tweetComponent.TweetComponent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.Tweet;
import model.User;

import java.util.LinkedList;

public class TweetViewer {
    private LinkedList<Tweet> tweets;
    private User loggedInUser;

    private TweetViewerLogic logic;

    private TweetViewerFXMLController tweetViewerFXMLController;

    private MainPage mainPage;

    public TweetViewer(MainPage mainPage , LinkedList<Tweet> tweets , User loggedInUser) {
        this.mainPage = mainPage;
        this.tweets = tweets;
        this.loggedInUser = loggedInUser;
    }

    public void initialize(AnchorPane anchorPane){
        setupLogic();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("component/tweetViewer/ui/tweetViewer.fxml"));

        tweetViewerFXMLController = loader.getController();
        tweetViewerFXMLController.initializeLogic(logic);
        tweetViewerFXMLController.initializeListener();

        fillComponent();
    }

    public void setupLogic(){
        logic = new TweetViewerLogic();
    }

    public void fillComponent(){
        if (tweets.isEmpty()){
            tweetViewerFXMLController.disableButtons();
            tweetViewerFXMLController.showEmptyLabel();
        }
        else {
            showTweetComponent();
        }
    }

    public void showTweetComponent(){
        Tweet showingTweet = tweets.get(0);
        TweetComponent tweetComponent = new TweetComponent(this,showingTweet,loggedInUser);

    }

    public void goToProfile(User user){
        mainPage.goToProfile(user);
    }
}
