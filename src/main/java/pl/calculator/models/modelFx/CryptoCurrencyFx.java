package pl.calculator.models.modelFx;

import javafx.beans.property.*;

import java.time.LocalDate;

public class CryptoCurrencyFx {

    private StringProperty currencyName= new SimpleStringProperty();

    private StringProperty currencyShort= new SimpleStringProperty();

    private IntegerProperty id= new SimpleIntegerProperty();

    private DoubleProperty polishMoney= new SimpleDoubleProperty();

    private ObjectProperty<LocalDate> validFrom = new SimpleObjectProperty<>();;

    private ObjectProperty<LocalDate> validTo = new SimpleObjectProperty<>();;

    private DoubleProperty moneyRate= new SimpleDoubleProperty();

    public void setCurrencyName(String currencyName) {
        this.currencyName.set(currencyName);
    }

    public void setCurrencyShort(String currencyShort) {
        this.currencyShort.set(currencyShort);
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public void setPolishMoney(double polishMoney) {
        this.polishMoney.set(polishMoney);
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom.set(validFrom);
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo.set(validTo);
    }

    public void setMoneyRate(double moneyRate) {
        this.moneyRate.set(moneyRate);
    }

    public String getCurrencyName() {
        return currencyName.get();
    }

    public StringProperty currencyNameProperty() {
        return currencyName;
    }

    public String getCurrencyShort() {
        return currencyShort.get();
    }

    public StringProperty currencyShortProperty() {
        return currencyShort;
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public double getPolishMoney() {
        return polishMoney.get();
    }

    public DoubleProperty polishMoneyProperty() {
        return polishMoney;
    }

    public LocalDate getValidFrom() {
        return validFrom.get();
    }

    public ObjectProperty<LocalDate> validFromProperty() {
        return validFrom;
    }

    public LocalDate getValidTo() {
        return validTo.get();
    }

    public ObjectProperty<LocalDate> validToProperty() {
        return validTo;
    }

    public double getMoneyRate() {
        return moneyRate.get();
    }

    public DoubleProperty moneyRateProperty() {
        return moneyRate;
    }

}
