package ui.component.tweetComponent.logic;

import ui.component.tweetComponent.TweetComponent;
import ui.component.tweetComponent.controller.TweetController;
import model.Tweet;
import model.User;

public class TweetComponentLogic {
    private Tweet tweet;
    private User loggedInUser;

    private TweetController controller;

    private TweetComponent tweetComponent;

    public TweetComponentLogic(TweetComponent tweetComponent,Tweet tweet, User loggedInUser) {
        this.tweetComponent = tweetComponent;
        this.tweet = tweet;
        this.loggedInUser = loggedInUser;

        controller = new TweetController(tweet, loggedInUser);
    }

    public void checkLike(){
//        if (isLiked()){
//            like();
//        }
//        if (!isLiked()){
//            unlike();
//        }
    }

//    public boolean isLiked(){
//        return tweet.getLikes().contains(loggedInUser.getId());
//    }

    public void like(){
        controller.like();
    }

    public void unlike(){
        controller.unlike();
    }

//    public boolean isReported(){
//        return tweet.getReports().contains(loggedInUser.getId());
//    }

    public void report(){
        controller.report();
    }

//    public boolean isRetweeted(){
//        return tweet.getRetweets().contains(loggedInUser.getId());
//    }

//    public void retweet(){
//        controller.retweet();
//    }

    public boolean isMuted(){
        return controller.isMuted();
    }

    public void mute(){
        controller.mute();
    }

    public boolean isBlocked(){
        return controller.isBlocked();
    }

    public void block() {
        controller.block();
    }

    public void save(){
        // coming soon //
    }

    public void comment(){
    }

    public void viewComments(){

    }

    public void forwardTo(){

    }

    public void viewProfile(){
        tweetComponent.goToProfile(controller.getTweetUser());
    }

    public void viewTweetPhoto(){

    }
}
