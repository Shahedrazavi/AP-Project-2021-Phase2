package controller.auth.signIn;

import event.auth.signIn.SignInFormEvent;
import ui.auth.signIn.SignInCenterFXMLController;
import model.User;
import util.Logger;

public class SignInPageLogic {
    private SignInController signInController;

    public SignInPageLogic() {
        this.signInController = new SignInController();
    }

    public void check(SignInFormEvent formEvent){
        boolean isValid = isInfoCorrect(formEvent);

        SignInCenterFXMLController controller = (SignInCenterFXMLController) formEvent.getSource();
        controller.getErrorLabel().setVisible(!isValid);

        if (isValid){
            logIn(formEvent);
        }
    }

    public boolean isInfoCorrect(SignInFormEvent formEvent){

        boolean isValid = true;

        isValid = isInfoNotEmpty(formEvent);

        if (isValid){
            isValid = signInController.doesUsernameExist(formEvent.getUsername());
        }

        if (isValid){
            isValid = signInController.doesUserPassMatch(formEvent.getUsername(), formEvent.getPassword());
        }

        return isValid;
    }

    public boolean isInfoNotEmpty(SignInFormEvent formEvent){
        if (formEvent.getUsername().isEmpty()){
            return false;
        }
        if (formEvent.getPassword().isEmpty()){
            return false;
        }

        return true;
    }

    public void logIn(SignInFormEvent formEvent){
        User loggedInUser = signInController.getUser(formEvent.getUsername());

        SignInCenterFXMLController controller = (SignInCenterFXMLController) formEvent.getSource();
        Logger.getLogger().signIn(loggedInUser.getUsername(),loggedInUser.getId().toString());
        controller.goToHomePage(loggedInUser);
    }
}
