package listener.component.tweetViewer;

import controller.component.tweetViewer.TweetViewerLogic;
import event.component.tweetViewer.TweetViewerEvent;
import ui.component.tweetViewer.TweetViewerFXMLController;

public class TweetViewerListener {
    private TweetViewerLogic logic;

    public TweetViewerListener(TweetViewerLogic logic) {
        this.logic = logic;
    }


    public void EventOccurred(TweetViewerEvent event){
        if (event.getCommand().equals("nextPressed")){
            ((TweetViewerFXMLController)event.getSource()).getComponent().goToNext();
        }
        if (event.getCommand().equals("previousPressed")){
            ((TweetViewerFXMLController)event.getSource()).getComponent().goToPrevious();
        }
    }
}
