package calculator.utilies.converters;

import calculator.user.User;
import calculator.date.UserFx;

public class UserConverter {

    public UserFx convertToUserFx(User user)
    {
        UserFx userFx = new UserFx();
        userFx.setId(user.getId());
        userFx.setEmail(user.getEmail());
        userFx.setName(user.getName());
        userFx.setSurname(user.getSurname());
        userFx.setPolishZlotyAccount(user.getPolishZlotyAccount());
        userFx.setValueBandK(user.getValueBandK());
        userFx.setValueCaT(user.getValueCaT());
        userFx.setNick(user.getNick());
        return userFx;
    }
}
