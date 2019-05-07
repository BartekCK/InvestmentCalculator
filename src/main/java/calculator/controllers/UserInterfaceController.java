package calculator.controllers;

import javafx.event.ActionEvent;
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

    }

    @Override
    protected void superUserTransaction() {

    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public ToggleButton getButtonAccountBalance() {
        return buttonAccountBalance;
    }

    public void setButtonAccountBalance(ToggleButton buttonAccountBalance) {
        this.buttonAccountBalance = buttonAccountBalance;
    }

    public ToggleButton getButtonTopUpAccount() {
        return buttonTopUpAccount;
    }

    public void setButtonTopUpAccount(ToggleButton buttonTopUpAccount) {
        this.buttonTopUpAccount = buttonTopUpAccount;
    }

    public ToggleButton getButtonUserTransaction() {
        return buttonUserTransaction;
    }

    public void setButtonUserTransaction(ToggleButton buttonUserTransaction) {
        this.buttonUserTransaction = buttonUserTransaction;
    }
}
