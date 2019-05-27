package calculator.calculate.remuneration;

import calculator.calculate.MyMath;
import calculator.exceptions.CalculatorException;

public final class RemunerationBoss extends Remuneration {

    private double accidentContribution;//ubezpieczenie wypadkowe

    public RemunerationBoss(double accidentContribution) {
        super(0.0976, 0.065);
        this.accidentContribution = (accidentContribution/100);
    }

    private double tax(double grossAmount,double percent)
    {
        return grossAmount * percent;
    }

    @Override
    public void setInsurancePremium(Insurance insurance, double grossSalary) {
        this.insurancePremium = insurance.valueZus(grossSalary,this.pensionContribution) + insurance.valueZus(grossSalary,this.pension)
                + insurance.valueZus(grossSalary,this.accidentContribution) ;
    }

    @Override
    public double calculate(double grossAmount ) throws CalculatorException {
        if(this.insurancePremium<=0)
            throw new CalculatorException("Uwaga wartość całkowitej składki na ubezpieczenie nie została ustalona");

        return MyMath.roundTwo(grossAmount+insurancePremium+tax(grossAmount,0.0245)+tax(grossAmount,0.001));
    }
}
