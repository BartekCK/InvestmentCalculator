package calculator.models.modelFx;

import javafx.beans.property.*;

import java.time.LocalDate;

public class TransactionFx {

    private ObjectProperty<LocalDate> addedDate = new SimpleObjectProperty<>();
    private StringProperty buyTypeCurrency= new SimpleStringProperty();
    private StringProperty buyCountCurrency= new SimpleStringProperty();
    private DoubleProperty buyRateCurrency = new SimpleDoubleProperty();

    private StringProperty sellTypeCurrency= new SimpleStringProperty();
    private StringProperty sellCountCurrency= new SimpleStringProperty();
    private DoubleProperty sellRateCurrency = new SimpleDoubleProperty();

    public LocalDate getAddedDate() {
        return addedDate.get();
    }

    public ObjectProperty<LocalDate> addedDateProperty() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate.set(addedDate);
    }

    public String getBuyTypeCurrency() {
        return buyTypeCurrency.get();
    }

    public StringProperty buyTypeCurrencyProperty() {
        return buyTypeCurrency;
    }

    public void setBuyTypeCurrency(String buyTypeCurrency) {
        this.buyTypeCurrency.set(buyTypeCurrency);
    }

    public String getBuyCountCurrency() {
        return buyCountCurrency.get();
    }

    public StringProperty buyCountCurrencyProperty() {
        return buyCountCurrency;
    }

    public void setBuyCountCurrency(String buyCountCurrency) {
        this.buyCountCurrency.set(buyCountCurrency);
    }

    public double getBuyRateCurrency() {
        return buyRateCurrency.get();
    }

    public DoubleProperty buyRateCurrencyProperty() {
        return buyRateCurrency;
    }

    public void setBuyRateCurrency(double buyRateCurrency) {
        this.buyRateCurrency.set(buyRateCurrency);
    }

    public String getSellTypeCurrency() {
        return sellTypeCurrency.get();
    }

    public StringProperty sellTypeCurrencyProperty() {
        return sellTypeCurrency;
    }

    public void setSellTypeCurrency(String sellTypeCurrency) {
        this.sellTypeCurrency.set(sellTypeCurrency);
    }

    public String getSellCountCurrency() {
        return sellCountCurrency.get();
    }

    public StringProperty sellCountCurrencyProperty() {
        return sellCountCurrency;
    }

    public void setSellCountCurrency(String sellCountCurrency) {
        this.sellCountCurrency.set(sellCountCurrency);
    }

    public double getSellRateCurrency() {
        return sellRateCurrency.get();
    }

    public DoubleProperty sellRateCurrencyProperty() {
        return sellRateCurrency;
    }

    public void setSellRateCurrency(double sellRateCurrency) {
        this.sellRateCurrency.set(sellRateCurrency);
    }
}
