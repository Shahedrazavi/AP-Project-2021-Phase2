package listener.auth.registration;

import event.auth.registration.RegistrationFormEvent;
import controller.auth.registration.RegistrationPage2Logic;

public class RegistrationFormListener2 {

    private RegistrationPage2Logic logic;

    public RegistrationFormListener2(){
        logic = new RegistrationPage2Logic();
    }

    public void eventOccurred(RegistrationFormEvent formEvent){
        logic.check(formEvent);
    }
}
