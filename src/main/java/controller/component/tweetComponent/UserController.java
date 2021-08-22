package controller.component.tweetComponent;

import controller.Controller;
import model.ID;
import model.User;

public class UserController extends Controller {
    public String getUsername(ID id){
        return context.users.get(id).getUsername();
    }
}
