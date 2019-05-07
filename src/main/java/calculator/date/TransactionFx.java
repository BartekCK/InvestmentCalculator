package calculator.date;

import javafx.beans.property.*;

import java.time.LocalDate;

public class TransactionFx {

    private ObjectProperty<LocalDate> addedDate = new SimpleObjectProperty<>();
    private StringProperty typeCurrency= new SimpleStringProperty();
    private DoubleProperty buyCurrency = new SimpleDoubleProperty();
    private DoubleProperty sellCurrency = new SimpleDoubleProperty();
    private DoubleProperty rateValue = new SimpleDoubleProperty();

    public LocalDate getAddedDate() {
        return addedDate.get();
    }

    public ObjectProperty<LocalDate> addedDateProperty() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate.set(addedDate);
    }

    public String getTypeCurrency() {
        return typeCurrency.get();
    }

    public StringProperty typeCurrencyProperty() {
        return typeCurrency;
    }

    public void setTypeCurrency(String typeCurrency) {
        this.typeCurrency.set(typeCurrency);
    }

    public double getBuyCurrency() {
        return buyCurrency.get();
    }

    public DoubleProperty buyCurrencyProperty() {
        return buyCurrency;
    }

    public void setBuyCurrency(double buyCurrency) {
        this.buyCurrency.set(buyCurrency);
    }

    public double getSellCurrency() {
        return sellCurrency.get();
    }

    public DoubleProperty sellCurrencyProperty() {
        return sellCurrency;
    }

    public void setSellCurrency(double sellCurrency) {
        this.sellCurrency.set(sellCurrency);
    }

    public double getRateValue() {
        return rateValue.get();
    }

    public DoubleProperty rateValueProperty() {
        return rateValue;
    }

    public void setRateValue(double rateValue) {
        this.rateValue.set(rateValue);
    }
}
