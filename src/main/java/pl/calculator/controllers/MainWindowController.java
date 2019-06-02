package pl.calculator.controllers;


import pl.calculator.controllers.login.SignInController;
import pl.calculator.controllers.userInterface.UserInterfaceController;
import pl.calculator.models.model.User;
import pl.calculator.utilies.Path;
import pl.calculator.utilies.ProjectLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;


public class MainWindowController {


    protected static User user;
    private UserInterfaceController userInterfaceController;

    @FXML
    private ToggleGroup toogleGroup;

    @FXML
    private MenuItem transactionMenuItem;

    @FXML
    private StackPane downStackPane;


    @FXML
    private void checkUser() {
        if(user == null)//Sign in
        {
            SignInController signInController = ProjectLoader.FxmlLoaderNewWindow(Path.PATH_LOGIN,"Panel logowania").getController();
            signInController.setMainWindowController(this);
        }
    }

    @FXML
    private void openCreditAndBankDeposit() {

        downStackPane.getChildren().clear();
        downStackPane.getChildren().add(ProjectLoader.ParentLoader(Path.PATH_LOANS_AND_DEPOSIT,null));

    }

    @FXML
    private void openRemuneration() {
        downStackPane.getChildren().clear();
        downStackPane.getChildren().add(ProjectLoader.ParentLoader(Path.PATH_REMUNERATION,null));

    }

    @FXML
    private void openStockExchange() {
        if(user != null)
        {
            downStackPane.getChildren().clear();
            downStackPane.getChildren().add(ProjectLoader.ParentLoader(Path.PATH_STOCK_EXCHANGE,null));
        }else
        {
            checkUser();
            toogleGroup.getSelectedToggle().setSelected(false);
        }

    }



    @FXML
    protected void userTopUpAccount() {
        clickOnMenuItem();
        userInterfaceController.getButtonTopUpAccount().setSelected(true);
        userInterfaceController.userTopUpAccount();
    }

    @FXML
    protected void userAccountBalance() {
        clickOnMenuItem();
        userInterfaceController.getButtonAccountBalance().setSelected(true);
        userInterfaceController.userAccountBalance();
    }

    @FXML
    protected void superUserTransaction() {
        clickOnMenuItem();
        userInterfaceController.getButtonUserTransaction().setSelected(true);
        userInterfaceController.superUserTransaction();
    }

    @FXML
    private void userStatistic(ActionEvent event) {
        ProjectLoader.FxmlLoaderNewWindow(Path.PATH_STATISTIC,"Statystyki");
    }

    @FXML
    private void userSignOut() {
        MainWindowController.user = null;
        downStackPane.getChildren().clear();
        toogleGroup.getToggles().clear();

    }

    public void setSuperUser(User user) {

        MainWindowController.user = user;
        if(user.isSuperUser())
            transactionMenuItem.setDisable(false);
        else
            transactionMenuItem.setDisable(true);
    }


    private void clickOnMenuItem() {
        userInterfaceController = ProjectLoader.FxmlLoaderNewWindow(Path.PATH_USER_INTERFACE,"Menu użytkownika").getController();
        setUser(user);
        if(!user.isSuperUser())
            userInterfaceController.getButtonUserTransaction().setDisable(true);
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        MainWindowController.user = user;
    }


}
