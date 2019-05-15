package calculator.calculate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BankCalculate implements LoansCalculate,DepositCalculate{

    private double resultInstallment;
    private double q;
    private int countMonth;
    private double percent;
    private ObservableList<DecreasingInstallmentFx> listFx = FXCollections.observableArrayList();


    @Override
    public double depositProfit(double initValue, double percent, double countDay) {
        return MyMath.roundTwo(initValue*(percent/100)*(countDay/365));
    }

    @Override
    public double parametrQ(double percent) {
        this.q = LoansCalculate.super.parametrQ(percent);
        this.percent = percent/100;
        return this.q;
    }

    @Override
    public void amountInstallment(double initValue, int countMonth) {
        this.countMonth = countMonth;
        this.resultInstallment = ((initValue*Math.pow(q,countMonth))*(q-1))/(Math.pow(q,countMonth)-1);
        calculateDecreasingInstallment(initValue,countMonth);
    }

    public double getResultInstallment() {
        resultInstallment=MyMath.roundTwo(resultInstallment);
        return resultInstallment;
    }

    public double getResultValue1() {
        return MyMath.roundTwo(resultInstallment*countMonth);
    }

    public double getResultValue2() {
        double sum=0;
        for (DecreasingInstallmentFx fx : listFx) {
            sum = sum + fx.getValue();
        }
        return MyMath.roundTwo(sum);
    }

    private void calculateDecreasingInstallment(double initValue, int countMonth)
    {

        for (int x=1;x<countMonth+1;x++)
        {
            DecreasingInstallmentFx decreasingInstallmentFx = new DecreasingInstallmentFx(x,MyMath.roundTwo((initValue/countMonth)*(1+(countMonth-x+1)*percent/12)));
            listFx.add(decreasingInstallmentFx);
        }

    }

    public ObservableList<DecreasingInstallmentFx> getListFx() {
        return listFx;
    }


}
