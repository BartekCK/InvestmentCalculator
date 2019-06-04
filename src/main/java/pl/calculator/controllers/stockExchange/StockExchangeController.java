package pl.calculator.controllers.stockExchange;

import pl.calculator.controllers.MainWindowController;
import pl.calculator.currency.manage.CryptoCurrency;
import pl.calculator.currency.types.BandK;
import pl.calculator.currency.types.CaT;
import pl.calculator.currency.types.Zloty;
import pl.calculator.currency.manage.Money;
import pl.calculator.database.tasks.CurrencyTask;
import pl.calculator.database.tasks.UserTask;
import pl.calculator.logs.Log;
import pl.calculator.logs.SaveLogs;
import pl.calculator.models.model.Transaction;
import pl.calculator.exceptions.CalculatorException;
import pl.calculator.exceptions.Dialogs;
import pl.calculator.models.model.SuperUser;
import pl.calculator.models.model.User;
import pl.calculator.utilies.TimeThread;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Text;

import java.util.Collections;

import static java.util.stream.Collectors.toList;


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
    private Text bestOffer;



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
    private void buy() {

        try {
            buyTextField1.setText(String.valueOf(CryptoCurrency.buyCurrency(this.user, buyComboBox.getValue(),
                    Double.parseDouble(buyTextField.getText()), buyComboBox1.getValue())));
            MainWindowController.setUser(this.user);
            UserTask userTask = new UserTask();

            buyComboBox1.getValue().buyCurrencyAddOrMinusPolishZloty(buyComboBox.getValue(),Double.parseDouble(buyTextField.getText()));
            if(buyComboBox1.getValue() instanceof CryptoCurrency)
                currencyTask.addCurrencyToDataBase((CryptoCurrency) buyComboBox1.getValue());
            if(buyComboBox.getValue() instanceof CryptoCurrency)
                currencyTask.addCurrencyToDataBase((CryptoCurrency) buyComboBox.getValue());

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
                ((SuperUser)user).addTransaction(transaction);
            }

            userTask.addUserToDataBase((SuperUser) user);
            SaveLogs.saveToFile(new Log("Udany zakup na giełdzie"));

        } catch (CalculatorException e) {
            Dialogs.errorDialog(e.getMessage());
        }catch (NumberFormatException e)
        {
            Dialogs.errorDialog("Dane zostały wprowadzone nieprawidłowo");
        }



    }

    @FXML
    private void check() {
        User userTemp = (User)user.clone();
        try {
            buyTextField1.setText(String.valueOf(CryptoCurrency.buyCurrency(userTemp, buyComboBox.getValue(),
                    Double.parseDouble(buyTextField.getText()), buyComboBox1.getValue())));
        } catch (CalculatorException e) {
            Dialogs.errorDialog(e.getMessage());
        }
        catch (NumberFormatException e)
        {
            Dialogs.errorDialog("Dane zostały wprowadzone nieprawidłowo");
        }
        finally {
            refresh();
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

        bestOffer.setText(Collections.min(list.stream().filter(CryptoCurrency.class::isInstance).map(CryptoCurrency.class::cast).collect(toList())).toString());

    }

}