package calculator.calculate;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class DecreasingInstallmentFx {
    private IntegerProperty number = new SimpleIntegerProperty();
    private DoubleProperty value = new SimpleDoubleProperty();

    public DecreasingInstallmentFx(int number, double value) {
        this.number.set(number);
        this.value.set(value);
    }

    public int getNumber() {
        return number.get();
    }

    public IntegerProperty numberProperty() {
        return number;
    }

    public void setNumber(int number) {
        this.number.set(number);
    }

    public double getValue() {
        return value.get();
    }

    public DoubleProperty valueProperty() {
        return value;
    }

    public void setValue(double value) {
        this.value.set(value);
    }
}
