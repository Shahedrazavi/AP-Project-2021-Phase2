package ui.newTweet;

import model.User;
import ui.Component;
import ui.mainView.MainPage;

public class NewTweet extends Component {
    public NewTweet(String fxmlName, MainPage parent , User loggedInUser) {
        super(fxmlName);
        setParent(parent);
        setLoggedInUser(loggedInUser);
        initialize();
    }

    @Override
    public void initialize() {
        NewTweetFXMLController controller = (NewTweetFXMLController) fxmlController;
        controller.setComponent(this);
    }
}
