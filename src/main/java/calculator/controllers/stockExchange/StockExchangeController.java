package calculator.controllers.stockExchange;

import calculator.controllers.MainWindowController;
import calculator.currency.manage.CryptoCurrency;
import calculator.currency.types.BandK;
import calculator.currency.types.CaT;
import calculator.currency.types.Zloty;
import calculator.currency.manage.Money;
import calculator.database.dao.TransactionDao;
import calculator.database.tasks.CurrencyTask;
import calculator.database.tasks.TransactionTask;
import calculator.database.tasks.UserTask;
import calculator.date.Transaction;
import calculator.exceptions.CalculatorException;
import calculator.user.SuperUser;
import calculator.user.User;
import calculator.utilies.TimeThread;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
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

    @FXML
    private ToggleButton buyButton;

    @FXML
    private ToggleButton checkButton;



    @FXML
    private void initialize()
    {
        refresh();

        buyComboBox.setItems(list);
        buyComboBox1.setItems(list);

        buyComboBox.valueProperty().addListener((observable, oldValue, newValue) -> currencyText.setText(newValue.toString()));
        buyComboBox1.valueProperty().addListener((observable, oldValue, newValue) -> currencyText1.setText(newValue.toString()));

        checkButton.disableProperty().bind(buyComboBox.valueProperty().isNull().or(buyComboBox1.valueProperty().isNull()).or(buyTextField.textProperty().isEmpty()));
        buyButton.disableProperty().bind(checkButton.disabledProperty());
    }

    @FXML
    void buy(ActionEvent event) {

        try {
            buyTextField1.setText(String.valueOf(CryptoCurrency.buyCurrency(this.user, buyComboBox.getValue(),
                    Double.parseDouble(buyTextField.getText()), buyComboBox1.getValue())));
            MainWindowController.setUser(this.user);
            UserTask userTask = new UserTask();
            userTask.addUserToDataBase((SuperUser) user);
            refresh();
            if(user.isSuperUser())
            {
                Transaction transaction= new Transaction((SuperUser)user
                        ,TimeThread.getLastSaveDay()
                        ,buyComboBox1.getSelectionModel().getSelectedItem().getCurrencyShort()
                        ,buyTextField1.getText()
                        ,buyComboBox1.getSelectionModel().getSelectedItem().getMoneyRate()
                        ,buyComboBox.getSelectionModel().getSelectedItem().getCurrencyShort()
                        ,buyTextField.getText()
                        ,buyComboBox.getSelectionModel().getSelectedItem().getMoneyRate());
                TransactionTask transactionTask = new TransactionTask();
                transactionTask.addTransactionToDataBase(transaction);
            }

        } catch (CalculatorException e) {
            System.out.println(e.getMessage());
        }



    }

    @FXML
    void check(ActionEvent event) {
        User userTemp = new User();
        userTemp.setPolishZlotyAccount(user.getPolishZlotyAccount());
        userTemp.setValueCaT(user.getValueCaT());
        userTemp.setValueBandK(user.getValueBandK());
        refresh();
        try {
            buyTextField1.setText(String.valueOf(CryptoCurrency.buyCurrency(userTemp, buyComboBox.getValue(),
                    Double.parseDouble(buyTextField.getText()), buyComboBox1.getValue())));
        } catch (CalculatorException e) {
            System.out.println(e.getMessage());
        }
    }


    private void refresh()
    {
        timeThread = new TimeThread();

        user = MainWindowController.getUser();
        list = FXCollections.observableArrayList(new CaT(),new BandK(), new Zloty());
        currencyTask = new CurrencyTask();
        list = currencyTask.init(list);

        zlotychOnAccountText.setText(String.valueOf(user.getPolishZlotyAccount()));
        catOnAccountText.setText(String.valueOf(user.getValueCaT()));
        bandkOnAccountText.setText(String.valueOf(user.getValueBandK()));

        catValueText.setText(String.valueOf(list.get(0).getMoneyRate()));
        bandkValueText.setText(String.valueOf(list.get(1).getMoneyRate()));

    }

}