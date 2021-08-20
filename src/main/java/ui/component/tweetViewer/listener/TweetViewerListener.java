package ui.component.tweetViewer.listener;

import ui.component.tweetViewer.event.TweetViewerEvent;
import ui.component.tweetViewer.logic.TweetViewerLogic;

public class TweetViewerListener {
    private TweetViewerLogic logic;

    public TweetViewerListener(TweetViewerLogic logic) {
        this.logic = logic;
    }


    public void EventOccurred(TweetViewerEvent event){
        if (event.getCommand().equals("nextPressed")){
        }
        if (event.getCommand().equals("previousPressed")){
        }
    }
}
