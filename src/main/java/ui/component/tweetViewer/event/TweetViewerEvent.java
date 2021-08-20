package ui.component.tweetViewer.event;

import event.StringEvent;

public class TweetViewerEvent extends StringEvent {
    public TweetViewerEvent(Object source, String command) {
        super(source, command);
    }
}
