package calculator.controllers;


import calculator.controllers.login.SignInController;
import calculator.controllers.userInterface.UserInterfaceController;
import calculator.user.User;
import calculator.utilies.Path;
import calculator.utilies.ProjectLoader;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleGroup;


public class MainWindowController {

    protected User user;
    private UserInterfaceController userInterfaceController;

    @FXML
    private ToggleGroup toogleGroup;

    @FXML
    private MenuItem transactionMenuItem;

    @FXML
    private void checkUser(Event event) {
        if(user == null)//Sign in
        {
            SignInController signInController = ProjectLoader.FxmlLoaderNewWindow(Path.PATH_LOGIN,"Panel logowania").getController();
            signInController.setMainWindowController(this);
        }
    }

    @FXML
    public void initialize()
    {

    }

    @FXML
    private void openCreditAndBankDeposit() {

    }

    @FXML
    private void openCurrencyRates() {

    }

    @FXML
    private void openStockExchange() {

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
    private void userSignOut() {
        this.user = null;

    }

    public void setSuperUser(User user) {//Rzutowanie w góre

        this.user = user;
        if(user.isSuperUser())
            transactionMenuItem.setDisable(false);
        else
            transactionMenuItem.setDisable(true);
    }


    private void clickOnMenuItem() {
        userInterfaceController = ProjectLoader.FxmlLoaderNewWindow(Path.PATH_USER_INTERFACE,"Menu użytkownika").getController();
        userInterfaceController.setUser(this.user);
        if(!user.isSuperUser())
            userInterfaceController.getButtonUserTransaction().setDisable(true);
    }
}
