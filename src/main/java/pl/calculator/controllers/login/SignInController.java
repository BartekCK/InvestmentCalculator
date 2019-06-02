package pl.calculator.controllers.login;

import pl.calculator.controllers.MainWindowController;
import pl.calculator.database.tasks.UserTask;
import pl.calculator.exceptions.Dialogs;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SignInController {

    private MainWindowController mainWindowController;
    private SuperUser superUser;
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
        superUser = userTask.pullUserFromDataBase(emailTextField.getText(),passwordTextField.getText());
        if(superUser == null)
        {
            Dialogs.errorDialog("Brak użytkownika");
            textBoolean.set(true);
        }else
        {

            mainWindowController.setSuperUser(superUser);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.close();
        }
    }

    public void registerNewUser(MouseEvent mouseEvent) {
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(ProjectLoader.addSCssToScene(new Scene(ProjectLoader.ParentLoader(Path.PATH_REGISTRATION,null))));
    }

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }
}
