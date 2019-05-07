package calculator.controllers;

import calculator.user.User;
import calculator.utilies.Path;
import calculator.utilies.ProjectLoader;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;


public class UserInterfaceController extends MainWindowController  {


    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ToggleButton buttonAccountBalance;

    @FXML
    private ToggleButton buttonTopUpAccount;

    @FXML
    private ToggleButton buttonUserTransaction;



    @Override
    protected void userTopUpAccount() {

    }

    @Override
    protected void userAccountBalance() {

            BankBalanceController bankBalanceController = ProjectLoader.FxmlLoader(Path.PATH_BANK_BALANCE).getController();
            bankBalanceController.setValuesInText(this.user);
            anchorPane.getChildren().addAll(bankBalanceController.getBankBalanceAnchorPane());
    }

    @Override
    protected void superUserTransaction() {

    }

    public ToggleButton getButtonAccountBalance() {
        return buttonAccountBalance;
    }

    public ToggleButton getButtonTopUpAccount() {
        return buttonTopUpAccount;
    }

    public ToggleButton getButtonUserTransaction() {
        return buttonUserTransaction;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
