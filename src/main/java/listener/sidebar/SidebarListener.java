package listener.sidebar;

import event.StringEvent;
import listener.StringListener;

public class SidebarListener implements StringListener {

    @Override
    public void eventOccurred(StringEvent event) {
        if (event.getCommand().equals("timeline")){
        }
        if (event.getCommand().equals("explore")){

        }
        if (event.getCommand().equals("notifs")){

        }
        if (event.getCommand().equals("search")){

        }
        if (event.getCommand().equals("messages")){

        }
        if (event.getCommand().equals("bookmarks")){

        }
        if (event.getCommand().equals("profile")){

        }
        if (event.getCommand().equals("settings")){

        }
        if (event.getCommand().equals("logOut")){

        }
        if (event.getCommand().equals("tweet")){

        }
    }
}
