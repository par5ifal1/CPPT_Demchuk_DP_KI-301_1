package KI301.Demchuk.Lab4;

public class CalculatorDriver {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        double x1 = 4;
        double result1 = calculator.Calculate(x1);
        System.out.println("Result for x1=" + x1 + ": " + result1);

        double x2 = 0;
        double result2 = calculator.Calculate(x2);
        System.out.println("Result for x2=" + x2 + ": " + result2);

        double x3 = -1;
        double result3 = calculator.Calculate(x3);
        System.out.println("Result for x3=" + x3 + ": " + result3);
    }
}
