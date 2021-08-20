package controller.settings;

import controller.Controller;
import model.User;

public class AccountController extends Controller {

    public boolean isPassCorrect(User user , String inputPass){
        return user.getPassword().equals(inputPass);
    }

    public void changePass(User user , String newPass){
        user.setPassword(newPass);
        context.users.update(user);
    }

    public void ChangeAccType(User user, boolean isPublic){
        user.setPublic(isPublic);
        context.users.update(user);
    }

    public void ChangeLastSeenType(User user, User.LastSeenType lastSeenType){
        user.setLastSeenType(lastSeenType);
        context.users.update(user);
    }

    public void changeActivate(User user){
        user.setActive(!user.isActive());
        context.users.update(user);
    }

    public void deleteAcc(User user){
        context.users.remove(user);
    }
}