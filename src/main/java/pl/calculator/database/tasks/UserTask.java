package pl.calculator.database.tasks;

import pl.calculator.database.dao.SuperUserDao;
import pl.calculator.exceptions.CalculatorException;
import pl.calculator.models.model.SuperUser;
import pl.calculator.models.model.User;
import pl.calculator.models.modelFx.UserFx;
import pl.calculator.utilies.converters.ListConverter;
import pl.calculator.utilies.converters.UserConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UserTask {

    public void addUserToDataBase(SuperUser superUser)
    {
        SuperUserDao superUserDao = new SuperUserDao();
        try {
            superUserDao.creatOrUpdate(superUser);
        } catch (CalculatorException e) {
            e.printStackTrace();
        }
    }

    public SuperUser pullUserFromDataBase(String email, String password)
    {
        SuperUserDao superUserDao = new SuperUserDao();
        try {
            SuperUser superUser = superUserDao.findUserByRequiredProperty(email,password);
            return superUser;
        } catch (CalculatorException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ObservableList<UserFx> pullAllUserFx()
    {
        SuperUserDao superUserDao = new SuperUserDao();
        Set<User> superUserSet = new TreeSet<>();
        ListConverter<User, UserConverter, UserFx> listConverter = (list, converter) -> {
            ObservableList<UserFx> temp = FXCollections.observableArrayList();
            list.forEach(e->{ temp.add(converter.convertToUserFx(e));});
            return temp;
        };
        try {
            List<SuperUser> tempList = superUserDao.queryForAll(SuperUser.class);
            superUserSet.addAll(tempList);
        } catch (CalculatorException e) {
            e.printStackTrace();
        }

        return listConverter.returnFxObject(new ArrayList<>(superUserSet), new UserConverter());
    }

}
