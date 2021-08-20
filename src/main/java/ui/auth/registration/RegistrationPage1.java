package ui.auth.registration;

import ui.Component;
import ui.auth.SignUpPage;

public class RegistrationPage1 extends Component {
    public RegistrationPage1(String fxmlName, SignUpPage parent) {
        super(fxmlName);
        setParent(parent);
        initialize();
    }

    @Override
    public void initialize() {
        ((RegistrationPage1FXMLController)fxmlController).setComponent(this);
    }
}
