package pl.calculator.calculate.remuneration;

import pl.calculator.exceptions.CalculatorException;

public interface Taxes {
    double calculate(double grossAmount) throws CalculatorException;
    void setInsurancePremium(Insurance insurance, double grossSalary);
}
