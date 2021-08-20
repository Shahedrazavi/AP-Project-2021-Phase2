package ui.component.tweetComponent.listener;

import ui.component.tweetComponent.event.TweetEvent;
import ui.component.tweetComponent.logic.TweetComponentLogic;

public class TweetComponentListener {
    TweetComponentLogic logic;

    public TweetComponentListener(TweetComponentLogic logic) {
        this.logic = logic;
    }

    public void eventOccurred(TweetEvent event){
        if (event.getCommand().equals("blockPressed")){
            logic.block();
        }
        if (event.getCommand().equals("commentPressed")){
            logic.comment();
        }
        if (event.getCommand().equals("forwardPressed")){
            logic.forwardTo();
        }
        if (event.getCommand().equals("likePressed")){
            logic.checkLike();
        }
        if (event.getCommand().equals("mutePressed")){
            logic.mute();
        }
        if (event.getCommand().equals("reportPressed")){
            logic.block();
        }
        if (event.getCommand().equals("retweetPressed")){
//            logic.retweet();
        }
        if (event.getCommand().equals("savePressed")){
            logic.save();
        }
        if (event.getCommand().equals("viewCommentsPressed")){
            logic.viewComments();
        }
        if (event.getCommand().equals("viewProfilePressed")){
            logic.viewProfile();
        }
        if (event.getCommand().equals("viewTweetPhotoPressed")){
            logic.viewTweetPhoto();
        }
    }
}
