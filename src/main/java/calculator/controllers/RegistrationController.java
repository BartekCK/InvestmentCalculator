package calculator.controllers;

import calculator.database.dao.UserDao;
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

    @FXML
    private TextField nickTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField surname;

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
        textEmailWarning.visibleProperty().bind(emailBoolean);
        textPasswordWarning.visibleProperty().bind(passwordBoolean);
    }

    @FXML
    void register(ActionEvent event) {
        if(checkPassword()&&checkEmail() && !(password1TextField.getText().isEmpty() || emailTextField.getText().isEmpty()))
        {
            System.out.println("UDALO SIE");
        }


        //User user = new User(emailTextField.toString(),password1TextField.toString(),nickTextField.toString());

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
                emailBoolean.set(true);//To znczy ze juz wystepuje taki email
                return false;
            }
            else
            {
                emailBoolean.set(false);//Porzadana odp
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
