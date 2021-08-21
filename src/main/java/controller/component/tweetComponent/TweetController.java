package controller.component.tweetComponent;

import controller.Controller;
import model.ID;
import model.Tweet;
import model.User;

public class TweetController extends Controller {
    private Tweet tweet;
    private User loggedInUser;

    public TweetController(Tweet tweet, User loggedInUser) {
        super();
        this.tweet = tweet;
        this.loggedInUser = loggedInUser;
    }

    public void like(){
        tweet.addLike(loggedInUser.getId());
        context.tweets.update(tweet);
    }

    public void unlike(){
        tweet.removeLike(loggedInUser.getId());
        context.tweets.update(tweet);
    }

    public void report(){
        tweet.addReport(loggedInUser.getId());
        context.tweets.update(tweet);
    }

//    public void retweet(){
//        context.tweets.increaseLastID();
//        Tweet newRetweet = new Tweet(context.tweets.getLastID(),tweet.getText() , tweet.getDate() , loggedInUser.getId());
//        newRetweet.setAsRetweet(tweet.getOwnerID(),tweet.getSourceTweetID());
//        tweet.getRetweets().add(newRetweet.getId());
//        if (tweet.isComment()){
//            newRetweet.setAsComment(tweet.getParentTweetID());
//        }
//
//        context.tweets.add(newRetweet);
//    }

    public boolean isMuted(){
        User mutedUser = context.users.get(tweet.getWriterID());
        ID mutedUserID = mutedUser.getId();
        return loggedInUser.getMutedUsers().contains(mutedUserID);
    }

    public void mute(){
        User mutedUser = context.users.get(tweet.getWriterID());
        ID mutedUserID = mutedUser.getId();
        loggedInUser.getMutedUsers().add(mutedUserID);
        context.users.update(loggedInUser);
    }

    public boolean isBlocked(){
        User blockedUser = context.users.get(tweet.getWriterID());
        ID blockedUserID = blockedUser.getId();
        return loggedInUser.getBlockedUsers().contains(blockedUserID);
    }

    public void block(){
        User blockedUser = context.users.get(tweet.getWriterID());
        ID blockedUserID = blockedUser.getId();
        loggedInUser.getBlockedUsers().add(blockedUserID);
        context.users.update(loggedInUser);
    }

    public User getTweetUser(){
        return context.users.get(tweet.getWriterID());
    }
}
