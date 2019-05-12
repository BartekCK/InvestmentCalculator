package calculator.controllers;


import calculator.controllers.login.SignInController;
import calculator.controllers.userInterface.UserInterfaceController;
import calculator.user.User;
import calculator.utilies.Path;
import calculator.utilies.ProjectLoader;
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
        downStackPane.getChildren().add(ProjectLoader.ParentLoader(Path.PATH_LOANS_AND_DEPOSIT));

    }

    @FXML
    private void openCurrencyRates() {

    }

    @FXML
    private void openStockExchange() {
        if(user != null)
        {
            StockExchangeController stockExchangeController = ProjectLoader.FxmlLoader(Path.PATH_STOCK_EXCHANGE).getController();
            downStackPane.getChildren().clear();
            downStackPane.getChildren().addAll(stockExchangeController.getAnchorPane());
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
    private void userSignOut() {
        this.user = null;
        downStackPane.getChildren().clear();
        toogleGroup.getToggles().clear();

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

    public static User getUser() {
        return user;
    }
}
