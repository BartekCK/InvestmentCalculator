package calculator.calculate;

import javafx.collections.ObservableList;

public interface LoansCalculate {

    default double parametrQ(double percent){
        double a = 1+((percent/100)/12);
        a *= 100000;
        a = Math.round(a);
        a /= 100000;
        return a;
    }
    void amountInstallment(double initValue,int countMonth);
    double getResultInstallment();
    ObservableList<DecreasingInstallmentFx> getListFx();
}
