package calculator.utilies.converters;

import calculator.models.model.User;
import calculator.models.modelFx.UserFx;

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
