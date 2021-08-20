package ui.auth.registration;

import ui.Component;
import ui.auth.SignUpPage;

public class RegistrationPage2 extends Component {
    public RegistrationPage2(String fxmlName, SignUpPage parent) {
        super(fxmlName);
        setParent(parent);
        initialize();
    }

    @Override
    public void initialize() {
        ((RegistrationPage2FXMLController)fxmlController).setComponent(this);
    }
}
