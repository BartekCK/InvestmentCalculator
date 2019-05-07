package calculator.controllers;

import calculator.database.dao.UserDao;
import calculator.database.tasks.UserTask;
import calculator.exceptions.CalculatorException;
import calculator.user.User;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class RegistrationController {

    UserTask userTask;

    @FXML
    private TextField nickTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField surnameTextField;

    @FXML
    private RadioButton investorCheckBox;

    @FXML
    private ToggleGroup radioButtonGroup;

    @FXML
    private RadioButton superInvestorCheckBox;

    @FXML
    private Text textPasswordWarning;
    private BooleanProperty passwordBoolean = new SimpleBooleanProperty(false);

    @FXML
    private Text textEmailWarning;
    private BooleanProperty emailBoolean = new SimpleBooleanProperty(false);

    @FXML
    private PasswordField password1TextField;

    @FXML
    private PasswordField password2TextField;

    @FXML
    public void initialize()
    {
        userTask = new UserTask();
        textEmailWarning.visibleProperty().bind(emailBoolean);
        textPasswordWarning.visibleProperty().bind(passwordBoolean);
    }

    @FXML
    void register(ActionEvent event) {

        if(checkPassword()&&checkEmail() && !(password1TextField.getText().isEmpty() || emailTextField.getText().isEmpty()))
        {
            User user = new User(emailTextField.getText(),password1TextField.getText(),nickTextField.getText());
            user.setName(nameTextField.getText());
            user.setSurname(surnameTextField.getText());
            if(investorCheckBox.isSelected())
            {
                user.setSuperUser(false);
            }
            else if(superInvestorCheckBox.isSelected())
            {
                user.setSuperUser(true);
            }
            userTask.addUserToDataBase(user);

        }

    }

    private boolean checkPassword()
    {
        if(password1TextField.getText().equals(password2TextField.getText()))
        {
            passwordBoolean.set(false);
            return true;
        }
        else
        {
            passwordBoolean.set(true);
            return false;
        }

    }

    private boolean checkEmail()
    {
        UserDao userDao = new UserDao();
        try {
            if(userDao.checkFigureEmail(emailTextField.getText()))
            {
                emailBoolean.set(true);
                return false;
            }
            else
            {
                emailBoolean.set(false);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (CalculatorException e) {
            e.printStackTrace();
        }
        return false;
    }

}
