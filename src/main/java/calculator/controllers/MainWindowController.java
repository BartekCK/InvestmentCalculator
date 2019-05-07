package calculator.controllers;


import calculator.user.SuperUser;
import calculator.user.User;
import calculator.utilies.Path;
import calculator.utilies.ProjectLoader;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleGroup;


public class MainWindowController {

    private User user;

    @FXML
    private ToggleGroup toogleGroup;

    @FXML
    private MenuItem transactionMenuItem;

    @FXML
    private void checkUser(Event event) {
        if(user == null)//Sign in
        {
            SignInController signInController = ProjectLoader.FxmlLoader(Path.PATH_LOGIN,"Panel logowania").getController();
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
    private void userTopUpAccount() {

    }

    @FXML
    private void userAccountBalance() {

    }

    @FXML
    private void superUserTransaction() {

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
}
