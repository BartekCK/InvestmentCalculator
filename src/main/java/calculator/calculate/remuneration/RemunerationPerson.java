package calculator.calculate.remuneration;

import calculator.calculate.MyMath;
import calculator.exceptions.CalculatorException;

public final class RemunerationPerson extends Remuneration{

    private double diseasePremium;//składka chorobowa
    private double healthInsurance;//składki na ubezpieczenie zdrowotne
    private double whereLives;

    public RemunerationPerson(double whereLives) throws CalculatorException {
        super(9.76/100,1.5/100);
        if(whereLives!= 111.25 && whereLives!= 139.06 )
            throw new CalculatorException("Błąd kosztów uzyskania przychodów");
        this.healthInsurance = 0.09;
        this.diseasePremium = 2.45/100;
        this.whereLives = whereLives;

    }

    public void setInsurancePremium(Insurance insurance, double grossSalary) {
         this.insurancePremium = insurance.valueZus(grossSalary,this.pensionContribution) + insurance.valueZus(grossSalary,this.pension)
                + insurance.valueZus(grossSalary,this.diseasePremium) ;

    }

    private double calculateHealthInsurance(double grossAmount)   {
        return (grossAmount - this.insurancePremium) * this.healthInsurance;
    }

    private double taxThreshold(double grossAmount)
    {
        if(grossAmount*12 <85528)
        {
            return grossAmount*0.18 - 46.33;
        }else
            return grossAmount*0.32 - 46.33;
    }

    private int incomeTaxMinusHealthInsurance (double grossAmount, double whereLives){
        Insurance insurance = new Insurance() {
            @Override
            public double valueZus(double grossAmount, double percent) {
                return grossAmount - percent;
            }
        };

        return (int) Math.round(insurance.valueZus(taxThreshold(grossAmount - this.insurancePremium - whereLives),
                (grossAmount-this.insurancePremium)*0.0775));
    }


    public double calculate(double grossAmount ) throws CalculatorException {


        if(this.insurancePremium<=0)
            throw new CalculatorException("Uwaga wartość całkowitej składki na ubezpieczenie nie została ustalona");


        return MyMath.roundTwo(grossAmount - this.insurancePremium - calculateHealthInsurance(grossAmount)
                - incomeTaxMinusHealthInsurance(grossAmount,this.whereLives));

    }

}
