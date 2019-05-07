package calculator.controllers;

import calculator.database.tasks.UserTask;
import calculator.user.User;
import calculator.utilies.Path;
import calculator.utilies.ProjectLoader;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SignInController {

    private MainWindowController mainWindowController;
    private User user;
    private UserTask userTask;

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
        userTask = new UserTask();
        text.visibleProperty().bind(textBoolean);
    }

    @FXML
    void loginAction(ActionEvent event) {
        user = userTask.pullUserFromDataBase(emailTextField.getText(),passwordTextField.getText());
        if(user == null)
        {
            System.out.println("Brak użytkownika");//THING TO DO LATER !!!
            textBoolean.set(true);
        }else
        {
            mainWindowController.setUser(user);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.close();
        }
    }

    public void registerNewUser(MouseEvent mouseEvent) {
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(new Scene(ProjectLoader.ParentLoader(Path.PATH_REGISTRATION)));
    }

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }
}
