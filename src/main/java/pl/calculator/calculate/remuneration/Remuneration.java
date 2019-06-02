package pl.calculator.calculate.remuneration;

abstract class Remuneration implements Taxes {
    double pensionContribution;//składka emerytalna
    double pension;//składka rentowa

    double insurancePremium;//składki na ubezpieczenie

    Remuneration(double pensionContribution, double pension) {
        this.pensionContribution = pensionContribution;
        this.pension = pension;
    }
}
