package ui.component.tweetViewer;

import controller.component.tweetViewer.TweetViewerLogic;
import ui.Component;
import ui.mainView.MainPage;
import ui.component.tweetComponent.TweetComponent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import model.Tweet;
import model.User;

import java.util.LinkedList;

public class TweetViewer extends Component {
    private LinkedList<Tweet> tweets;
    private int index;
    private User loggedInUser;

    private MainPage mainPage;

    public TweetViewer(String fxmlName, TVContainerComponent parent, LinkedList<Tweet> tweets , User loggedInUser , MainPage mainPage) {
        super(fxmlName);
        setParent(parent);
        setLoggedInUser(loggedInUser);
        this.index = 0;
        this.tweets = tweets;
        this.loggedInUser = loggedInUser;
        this.mainPage = mainPage;
        initialize();
    }

    @Override
    public void initialize() {
        TweetViewerFXMLController controller = (TweetViewerFXMLController) fxmlController;
        controller.setComponent(this);
        controller.initializeLogic(new TweetViewerLogic());
        controller.initializeListener();
        fillComponent(controller);
    }

    public void fillComponent(TweetViewerFXMLController controller){
        if (tweets.isEmpty()){
            controller.disableButtons();
            controller.showEmptyLabel();
        }
        else {
            index = tweets.size()-1;
            showTweetComponent(controller);
        }
    }

    public void showTweetComponent(TweetViewerFXMLController controller){
        if (index==0){
            controller.disableNext();
        }
        else{
            controller.enableNext();
        }
        if (index==tweets.size()-1){
            controller.disablePrevious();
        }
        else {
            controller.enablePrevious();
        }
        Tweet showingTweet = tweets.get(index);
        TweetComponent tweetComponent = new TweetComponent("tweetComponent",this,showingTweet,loggedInUser);
        controller.setComponentPane(tweetComponent);
    }

    public void goToNext(){
        index--;
        showTweetComponent((TweetViewerFXMLController)fxmlController);
    }

    public void goToPrevious(){
        index++;
        showTweetComponent((TweetViewerFXMLController)fxmlController);

    }

    public void goToProfile(User user){
        mainPage.goToProfile(user);
    }
}
