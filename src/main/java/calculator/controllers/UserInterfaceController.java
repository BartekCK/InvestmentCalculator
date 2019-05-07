package calculator.controllers;

import calculator.user.SuperUser;
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
        AccountTopUpController accountTopUpController = ProjectLoader.FxmlLoader(Path.PATH_ACCOUNT_TOP_UP).getController();
        accountTopUpController.setUser(this.user);
        anchorPane.getChildren().clear();
        anchorPane.getChildren().addAll(accountTopUpController.getTopUpAccountAnchorPane());
    }

    @Override
    protected void userAccountBalance() {

        BankBalanceController bankBalanceController = ProjectLoader.FxmlLoader(Path.PATH_BANK_BALANCE).getController();
        bankBalanceController.setValuesInText(this.user);
        anchorPane.getChildren().clear();
        anchorPane.getChildren().addAll(bankBalanceController.getBankBalanceAnchorPane());
    }

    @Override
    protected void superUserTransaction() {
        TransactionRecordController transactionRecordController = ProjectLoader.FxmlLoader(Path.PATH_TRANSACTION_RECORD).getController();
        transactionRecordController.setSuperUser((SuperUser) this.user);
        transactionRecordController.showTable();
        anchorPane.getChildren().clear();
        anchorPane.getChildren().addAll(transactionRecordController.getTransactionRecordAnchorPane());
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
