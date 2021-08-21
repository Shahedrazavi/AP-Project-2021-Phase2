package ui.auth;

import ui.Component;
import ui.Page;
import ui.auth.registration.RegistrationPage1;
import ui.auth.registration.RegistrationPage2;
import ui.component.backButton.BackButton;

public class SignUpPage extends Page {
    private Component backButton;
    private Component page1;
    private Component page2;

    public SignUpPage(String fxmlName) {
        super(fxmlName);
        initialize();
    }

    @Override
    public void initialize() {
        SignUpPageFXMLController controller = (SignUpPageFXMLController)fxmlController;
        backButton = new BackButton("backButton");
        page1 = new RegistrationPage1("reg1",this);
        page2 = new RegistrationPage2("reg2",this);
        controller.setPage(this);
        controller.makeContents();
    }

    public Component getBackButton() {
        return backButton;
    }

    public Component getPage1() {
        return page1;
    }

    public Component getPage2() {
        return page2;
    }
}
