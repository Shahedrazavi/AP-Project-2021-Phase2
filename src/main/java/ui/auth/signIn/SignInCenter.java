package ui.auth.signIn;

import ui.Component;
import ui.auth.SignInPage;
import ui.component.backButton.BackButton;

public class SignInCenter extends Component {
    private Component backButton;

    public SignInCenter(String fxmlName, SignInPage parent) {
        super(fxmlName);
        setParent(parent);
        initialize();
    }

    @Override
    public void initialize() {
        SignInCenterFXMLController controller = (SignInCenterFXMLController)fxmlController;
        backButton = new BackButton("backButton");
        controller.setComponent(this);
        controller.makeContents();
    }

    public Component getBackButton() {
        return backButton;
    }
}
