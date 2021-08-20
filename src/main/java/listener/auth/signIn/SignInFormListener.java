package listener.auth.signIn;

import event.auth.signIn.SignInFormEvent;
import controller.auth.signIn.SignInPageLogic;

public class SignInFormListener {

    private SignInPageLogic logic;

    public SignInFormListener() {
        logic = new SignInPageLogic();
    }

    public void eventOccurred(SignInFormEvent formEvent){
        logic.check(formEvent);
    }
}
