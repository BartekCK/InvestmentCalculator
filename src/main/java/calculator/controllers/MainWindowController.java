package calculator.controllers;


import calculator.user.User;
import calculator.utilies.Path;
import calculator.utilies.ProjectLoader;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;


public class MainWindowController {

    private User user;

    @FXML
    private ToggleGroup toogleGroup;

    @FXML
    private void checkUser(Event event) {
        if(user == null)//Sign in
        {
            SignInController signInController = ProjectLoader.FxmlLoader(Path.PATH_LOGIN,"Panel logowania").getController();
        }
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
    private void userSettings() {

    }

    @FXML
    private void userSignOut() {

    }


}
