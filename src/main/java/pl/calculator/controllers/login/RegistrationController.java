package pl.calculator.controllers.login;

import pl.calculator.database.dao.SuperUserDao;
import pl.calculator.database.tasks.UserTask;
import pl.calculator.exceptions.CalculatorException;
import pl.calculator.models.model.SuperUser;
import pl.calculator.utilies.Path;
import pl.calculator.utilies.ProjectLoader;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
            SuperUser superUser = new SuperUser(emailTextField.getText(),password1TextField.getText(),nickTextField.getText());
            superUser.setName(nameTextField.getText());
            superUser.setSurname(surnameTextField.getText());

            if(investorCheckBox.isSelected())
            {
                superUser.setPolishZlotyAccount(100);
                superUser.setSuperUser(false);
            }
            else if(superInvestorCheckBox.isSelected())
            {
                superUser.setPolishZlotyAccount(1000);
                superUser.setSuperUser(true);
            }
            superUser.setValueBandK(0);
            superUser.setValueCaT(0);
            userTask.addUserToDataBase(superUser);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(ProjectLoader.addSCssToScene(new Scene(ProjectLoader.ParentLoader(Path.PATH_REGISTRATION_CONFIRMATION,Path.CSS_MAIN_SCENE))));
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
        SuperUserDao superUserDao = new SuperUserDao();
        try {
            if(superUserDao.checkFigureEmail(emailTextField.getText()))
            {
                emailBoolean.set(true);
                return false;
            }
            else
            {
                emailBoolean.set(false);
                return true;
            }
        } catch (SQLException | CalculatorException e) {
            e.printStackTrace();
        }
        return false;
    }

}
