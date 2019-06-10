package pl.calculator.university.thread;

public class AgreeCash {
    boolean bankAgrees;
    boolean bankAgreesAboutCredit;
    double value;

    public boolean isBankAgrees() {
        return bankAgrees;
    }

    public void setBankAgrees(boolean bankAgrees) {
        this.bankAgrees = bankAgrees;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isBankAgreesAboutCredit() {
        return bankAgreesAboutCredit;
    }

    public void setBankAgreesAboutCredit(boolean bankAgreesAboutCredit) {
        this.bankAgreesAboutCredit = bankAgreesAboutCredit;
    }
}
