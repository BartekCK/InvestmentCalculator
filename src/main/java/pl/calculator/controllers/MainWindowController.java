package pl.calculator.controllers;

import javafx.event.ActionEvent;
import pl.calculator.controllers.login.SignInController;
import pl.calculator.controllers.userInterface.UserInterfaceController;
import pl.calculator.logs.Log;
import pl.calculator.logs.SaveLogs;
import pl.calculator.models.model.User;
import pl.calculator.utilies.Path;
import pl.calculator.utilies.ProjectLoader;
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
    private void showLog()
    {

        SaveLogs.saveToFile(new Log("Otwarcie panelu logów"));
        ProjectLoader.FxmlLoaderNewWindow(Path.PATH_LOG,"Log");
    }

    @FXML
    private void openCreditAndBankDeposit() {
        SaveLogs.saveToFile(new Log("Otwarcie panelu kredytów i lokat"));
        downStackPane.getChildren().clear();
        downStackPane.getChildren().add(ProjectLoader.ParentLoader(Path.PATH_LOANS_AND_DEPOSIT,Path.CSS_MAIN_SCENE));

    }

    @FXML
    private void openRemuneration() {
        SaveLogs.saveToFile(new Log("Otwarcie panelu wynagordzeń"));
        downStackPane.getChildren().clear();
        downStackPane.getChildren().add(ProjectLoader.ParentLoader(Path.PATH_REMUNERATION,Path.CSS_MAIN_SCENE));

    }

    @FXML
    private void openStockExchange() {
        if(user != null)
        {
            SaveLogs.saveToFile(new Log("Otwarcie panelu giełdy"));
            downStackPane.getChildren().clear();
            downStackPane.getChildren().add(ProjectLoader.ParentLoader(Path.PATH_STOCK_EXCHANGE,Path.CSS_MAIN_SCENE));
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
    private void userStatistic() {
        SaveLogs.saveToFile(new Log("Otwarcie panelu statystyk"));
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

    @FXML
    void universityThread(ActionEvent event) {
        ProjectLoader.FxmlLoaderNewWindow(Path.PATH_THREAD,"Statystyki");
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
