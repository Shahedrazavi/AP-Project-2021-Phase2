package listener.newTweet;

import controller.component.tweetComponent.TweetComponentLogic;
import controller.newTweet.NewTweetLogic;
import event.newTweet.NewTweetEvent;

public class NewTweetListener {
    NewTweetLogic logic;

    public NewTweetListener() {
        logic = new NewTweetLogic();
    }

    public void eventOccurred(NewTweetEvent event){
        if (event.getCommand().equals("tweet")){
            logic.checkForTweet(event);
        }
    }
}
