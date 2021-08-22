package ui.component.profileHeader;

import model.User;
import ui.Component;
import ui.profile.Profile;

public class ProfileHeader extends Component {

    public ProfileHeader(String fxmlName , Profile parent , User loggedInUser) {
        super(fxmlName);
        setParent(parent);
        setLoggedInUser(loggedInUser);
    }
}
