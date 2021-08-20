package controller.auth.registration;

import controller.auth.AuthController;
import event.auth.registration.RegistrationFormEvent;
import ui.auth.registration.RegistrationPage1FXMLController;
import javafx.scene.control.Label;

import java.util.LinkedList;

public class RegistrationPage1Logic {

    private AuthController authController;

    public RegistrationPage1Logic() {
        authController = new AuthController();
    }

    public void Check(RegistrationFormEvent event){
        boolean isValid = true;
        isValid = isFirstLevelNotEmpty(event);
        if (isValid){
            isValid = isFirstLevelValid(event);
        }

        if (isValid){
            proceed(event);
        }

    }
    public boolean isFirstLevelNotEmpty(RegistrationFormEvent event){
        RegistrationPage1FXMLController controller = (RegistrationPage1FXMLController) event.getSource();

        LinkedList<String> eventInfo = event.getFirstPageInfo();

        LinkedList<Label> emptyErrorLabels = controller.getFirstPageEmptyErrors();

        LinkedList<Boolean> isLabelWritten = new LinkedList<>();

        boolean isValid = true;

        for (int i = 0 ; i<6 ; i++){
            if (eventInfo.get(i).isEmpty()){
                isLabelWritten.add(false);
                isValid = false;
            }else {
                isLabelWritten.add(true);
            }
        }

        for (int i = 0 ; i<6 ; i++){
            if (isLabelWritten.get(i)){
                controller.hideLabel(emptyErrorLabels.get(i));
            }else {
                controller.showLabel(emptyErrorLabels.get(i));
            }
        }

        return isValid;
    }

    public boolean isFirstLevelValid(RegistrationFormEvent event){
        RegistrationPage1FXMLController controller = (RegistrationPage1FXMLController) event.getSource();

        boolean isPasswordMatched = true;
        boolean isUsernameAvailable = authController.isUsernameAvailable(event.getUsername());
        boolean isEmailAvailable = authController.isEmailAvailable(event.getEmail());


        if (!event.getPassword1().equals(event.getPassword2())){
            isPasswordMatched = false;
            controller.showLabel(controller.getPasswordError());
        } else {
            controller.hideLabel(controller.getPasswordError());
        }


        if (!isEmailAvailable){
            controller.showLabel(controller.getEmailError());
        } else{
            controller.hideLabel(controller.getEmailError());
        }

        if (!isUsernameAvailable){
            controller.showLabel(controller.getUsernameError());
        } else {
            controller.hideLabel(controller.getUsernameError());
        }

        return (isPasswordMatched&&isEmailAvailable&&isUsernameAvailable);
    }

    public boolean isLastLevelValid(RegistrationFormEvent event){
        return true;
    }

    public void proceed(RegistrationFormEvent event){
        RegistrationPage1FXMLController controller = (RegistrationPage1FXMLController) event.getSource();
        controller.goToPage2(event);
    }
}
