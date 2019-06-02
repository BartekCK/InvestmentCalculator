package pl.calculator.calculate;

public class MyMath {

    public static double roundTwo(double number)
    {
        number *=100;
        number = Math.round(number);
        number /=100;
        return number;
    }
}
