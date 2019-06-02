package pl.calculator.controllers.userInterface.menuPanes;

import pl.calculator.models.model.User;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class BankBalanceController {

    @FXML
    private AnchorPane bankBalanceAnchorPane;

    @FXML
    private Text zlValueText;

    @FXML
    private Text catValueText;

    @FXML
    private Text bandkzlValueText;


    public void setValuesInText(User user)
    {
        zlValueText.setText(String.valueOf(user.getPolishZlotyAccount()));
        catValueText.setText(String.valueOf(user.getValueCaT()));
        bandkzlValueText.setText(String.valueOf(user.getValueBandK()));
    }


    public AnchorPane getBankBalanceAnchorPane() {
        return bankBalanceAnchorPane;
    }



}
