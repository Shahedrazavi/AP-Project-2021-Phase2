package listener;

import controller.OpeningController;
import event.Event;
import event.StringEvent;

public interface StringListener {

    void eventOccurred(StringEvent event);
}
