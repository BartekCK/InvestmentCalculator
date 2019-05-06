package calculator.controllers;

import calculator.database.dao.UserDao;
import calculator.exceptions.CalculatorException;
import calculator.user.User;
import calculator.utilies.Path;
import calculator.utilies.ProjectLoader;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.SQLException;

public class SignInController {

    private User user;

    @FXML
    AnchorPane anchorPane;

    @FXML
    private Text text;

    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField passwordTextField;

    private BooleanProperty textBoolean = new SimpleBooleanProperty(false);

    @FXML
    public void initialize()
    {

        text.visibleProperty().bind(textBoolean);
    }

    @FXML
    void loginAction() {
        UserDao userDao = new UserDao();
        try {
            user = userDao.findUserByRequiredProperty(emailTextField.toString(),passwordTextField.toString());
            if(user == null)
            {
                System.out.println("Brak użytkownika");//THING TO DO LATER !!!
                textBoolean.set(true);
            }else
                textBoolean.set(false);

        } catch (CalculatorException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void registerNewUser(MouseEvent mouseEvent) {
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(new Scene(ProjectLoader.ParentLoader(Path.PATH_REGISTRATION)));
    }
}
