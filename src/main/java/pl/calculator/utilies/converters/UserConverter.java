package pl.calculator.utilies.converters;

import pl.calculator.models.model.User;
import pl.calculator.models.modelFx.UserFx;

public class UserConverter {

    public UserFx convertToUserFx(User user)
    {
        UserFx userFx = new UserFx();
        userFx.setId(user.getId());
        userFx.setEmail(user.getEmail());
        userFx.setName(user.getName());
        userFx.setSurname(user.getSurname());
        userFx.setWealth(user);
        userFx.setNick(user.getNick());
        return userFx;
    }
}
