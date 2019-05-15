package calculator.controllers;

import calculator.currency.manage.CryptoCurrency;
import calculator.currency.types.BandK;
import calculator.currency.types.CaT;
import calculator.currency.types.Zloty;
import calculator.currency.manage.Money;
import calculator.user.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class StockExchangeController {

    private User user;

    private ObservableList<Money> list;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private Text zlotychOnAccountText;

    @FXML
    private Text catOnAccountText;

    @FXML
    private Text bandkOnAccountText;

    @FXML
    private Text catValueText;

    @FXML
    private Text bandkValueText;

    @FXML
    private ComboBox<Money> sellComboBox;

    @FXML
    private TextField sellTextField;

    @FXML
    private TextField buyTextField;

    @FXML
    private ComboBox<Money> buyComboBox;


    public StockExchangeController()
    {
        user = MainWindowController.getUser();
        list = FXCollections.observableArrayList(new CaT(),new BandK(), new Zloty());
    }

    @FXML
    private void initialize()
    {

        zlotychOnAccountText.setText(String.valueOf(user.getPolishZlotyAccount()));
        catOnAccountText.setText(String.valueOf(user.getValueCaT()));
        bandkOnAccountText.setText(String.valueOf(user.getValueBandK()));

        catValueText.setText(String.valueOf(((CryptoCurrency)list.get(0)).returnCurrentValue()));
        bandkValueText.setText(String.valueOf(((CryptoCurrency)list.get(1)).returnCurrentValue()));

        sellComboBox.setItems(list);
        buyComboBox.setItems(list);
    }

    @FXML
    void buy(ActionEvent event) {

    }

    @FXML
    void check(ActionEvent event) {

    }

    public AnchorPane getAnchorPane()
    {
        return this.mainAnchorPane;
    }
}