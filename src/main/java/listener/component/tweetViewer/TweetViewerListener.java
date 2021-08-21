package listener.component.tweetViewer;

import controller.component.tweetViewer.TweetViewerLogic;
import event.component.tweetViewer.TweetViewerEvent;

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
