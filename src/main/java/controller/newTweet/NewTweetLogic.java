package controller.newTweet;

import controller.component.tweetComponent.TweetController;
import event.newTweet.NewTweetEvent;

public class NewTweetLogic {
    private NewTweetController controller;

    public NewTweetLogic() {
        controller = new NewTweetController();
    }

    public void checkForTweet(NewTweetEvent event){
        if (!(event.getText().equals("")) || event.getImage()!=null){
            controller.Tweet(event);
        }
    }
}
