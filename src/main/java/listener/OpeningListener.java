package listener;

import event.StringEvent;
import ui.GraphicalAgent;

public class OpeningListener implements StringListener {

    @Override
    public void eventOccurred(StringEvent event) {
        GraphicalAgent agent = GraphicalAgent.getInstance();
        if (event.getCommand().equals("registration")){
            agent.goToSignUp(event);
        }
        if (event.getCommand().equals("signingIn")){
            agent.goToSignIn(event);
        }
    }
}
