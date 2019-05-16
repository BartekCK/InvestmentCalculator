package calculator.controllers;

import calculator.currency.manage.CryptoCurrency;
import calculator.currency.types.BandK;
import calculator.currency.types.CaT;
import calculator.currency.types.Zloty;
import calculator.currency.manage.Money;
import calculator.database.tasks.CurrencyTask;
import calculator.user.User;
import calculator.utilies.TimeThread;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class StockExchangeController {

    private User user;

    private ObservableList<Money> list;

    private CurrencyTask currencyTask;

    private TimeThread timeThread;

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
    private TextField buyTextField;

    @FXML
    private Text currencyText;

    @FXML
    private ComboBox<Money> buyComboBox;

    @FXML
    private TextField buyTextField1;

    @FXML
    private Text currencyText1;

    @FXML
    private ComboBox<Money> buyComboBox1;


    public StockExchangeController()
    {
        timeThread = new TimeThread();

        user = MainWindowController.getUser();
        list = FXCollections.observableArrayList(new CaT(),new BandK(), new Zloty());
        currencyTask = new CurrencyTask();
        list = currencyTask.init(list);
    }

    @FXML
    private void initialize()
    {

        zlotychOnAccountText.setText(String.valueOf(user.getPolishZlotyAccount()));
        catOnAccountText.setText(String.valueOf(user.getValueCaT()));
        bandkOnAccountText.setText(String.valueOf(user.getValueBandK()));

        catValueText.setText(String.valueOf(((CryptoCurrency)list.get(0)).getMoneyRate()));
        bandkValueText.setText(String.valueOf(((CryptoCurrency)list.get(1)).getMoneyRate()));

        buyComboBox.setItems(list);
        buyComboBox1.setItems(list);

        buyComboBox.valueProperty().addListener((observable, oldValue, newValue) -> currencyText.setText(newValue.toString()));
        buyComboBox1.valueProperty().addListener((observable, oldValue, newValue) -> currencyText1.setText(newValue.toString()));

    }

    @FXML
    void buy(ActionEvent event) {

    }

    @FXML
    void check(ActionEvent event) {
        System.out.println(user);
        CryptoCurrency.buyCurrency(this.user,buyComboBox.getValue(),Double.parseDouble(buyTextField.getText()),buyComboBox1.getValue());
        System.out.println(user);
    }

}