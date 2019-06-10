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

        AnonimOnAbstract anonimOnAbstract = new AnonimOnAbstract() {
            @Override
            void printMessage(String message) {
                System.out.println(message);
            }
        };

        anonimOnAbstract.printMessage("Proba obiektu klasy, ktora ma tylko jedna instnacje");
        return userFx;
    }
}


abstract class AnonimOnAbstract
{
    abstract void printMessage(String message);
}
