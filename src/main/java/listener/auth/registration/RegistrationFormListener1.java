package listener.auth.registration;

import event.auth.registration.RegistrationFormEvent;
import controller.auth.registration.RegistrationPage1Logic;

public class RegistrationFormListener1 {

    private RegistrationPage1Logic logic;

    public RegistrationFormListener1() {
        logic = new RegistrationPage1Logic();
    }

    public void eventOccurred(RegistrationFormEvent event){
        logic.Check(event);
    }
}
