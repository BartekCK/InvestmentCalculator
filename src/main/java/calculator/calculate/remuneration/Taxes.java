package calculator.calculate.remuneration;

import calculator.exceptions.CalculatorException;

public interface Taxes {
    double calculate(double grossAmount) throws CalculatorException;
    void setInsurancePremium(Insurance insurance, double grossSalary);
}
