package controller.auth.registration;

import controller.auth.AuthController;
import event.auth.registration.RegistrationFormEvent;
import ui.auth.registration.RegistrationPage2FXMLController;

import java.time.DateTimeException;
import java.time.LocalDate;

public class RegistrationPage2Logic {

    private AuthController authController;
    private RegistrationFormEvent primaryFormEvent;

    public RegistrationPage2Logic() {
        authController = new AuthController();
    }

    public void check(RegistrationFormEvent formEvent){
        boolean isValid = isBirthdayValid(formEvent);
        if (isValid){
            setProfileName(formEvent);
            try{
                authController.register(formEvent,
                        LocalDate.of(Integer.parseInt(formEvent.getBirthdayYear()),
                                Integer.parseInt(formEvent.getBirthdayMonth()),
                                Integer.parseInt(formEvent.getBirthdayDay()) ));
            }
            catch (NumberFormatException e){
                authController.registerWithoutBirthday(formEvent);
            }

            proceed(formEvent);
        }
    }

    public boolean isBirthdayValid(RegistrationFormEvent formEvent){
        RegistrationPage2FXMLController controller = (RegistrationPage2FXMLController) formEvent.getSource();

        LocalDate birthday = LocalDate.now();

        boolean isValid = true;

        try {
            birthday = LocalDate.of(Integer.parseInt(formEvent.getBirthdayYear()),
                    Integer.parseInt(formEvent.getBirthdayMonth()),
                    Integer.parseInt(formEvent.getBirthdayDay()));
        }
        catch (NumberFormatException ignored){
        }
        catch (DateTimeException e){
            isValid = false;
        }
        controller.getBirthdayError().setVisible(!isValid);
        return isValid;
    }

    public void setProfileName(RegistrationFormEvent formEvent){
        if (formEvent.getProfileName().isEmpty()){
            formEvent.setProfileName(formEvent.getUsername());
        }
    }

    public void proceed(RegistrationFormEvent formEvent){
        RegistrationPage2FXMLController controller = (RegistrationPage2FXMLController) formEvent.getSource();
        controller.backToOpeningPage();
    }

}
