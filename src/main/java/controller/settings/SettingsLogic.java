package controller.settings;

import event.settings.ChangePassEvent;
import event.settings.ComboBoxEvent;
import ui.settings.SettingsFXMLController;
import model.User;

public class SettingsLogic {

    private AccountController accountController;

    public SettingsLogic() {
        accountController = new AccountController();
    }

    public void checkForChangingPass(ChangePassEvent changePassEvent){
        boolean isValid = accountController.isPassCorrect(changePassEvent.getUser(),changePassEvent.getCurrentPass());

        SettingsFXMLController settingsFXMLController = (SettingsFXMLController) changePassEvent.getSource();
        settingsFXMLController.getPassErrorLabel().setVisible(!isValid);

        if (isValid){
            accountController.changePass(changePassEvent.getUser(), changePassEvent.getNewPass());
        }
    }

    public void ChangeAccType(ComboBoxEvent event){
        boolean isPublic = event.getSelectedOption().equals("Public");
        accountController.ChangeAccType(event.getUser(),isPublic);
    }

    public void ChangeLastSeenType(ComboBoxEvent event){
        User.LastSeenType lastSeenType = User.LastSeenType.everyone;
        if (event.getSelectedOption().equals("Only following can see")){
            lastSeenType = User.LastSeenType.followings;
        }
        if (event.getSelectedOption().equals("No one can see")){
            lastSeenType = User.LastSeenType.no_one;
        }
        accountController.ChangeLastSeenType(event.getUser(), lastSeenType);
    }

    public void changeActivate(User user){
        accountController.changeActivate(user);
        //
    }

    public void deleteAcc(User user){
        accountController.deleteAcc(user);
        //
    }
}
