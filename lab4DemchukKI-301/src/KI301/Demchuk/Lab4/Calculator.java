package KI301.Demchuk.Lab4;

import static java.lang.Math.sin;

/**
 * The `Calculator` class represents an object for performing calculations.
 * This class contains the `Calculate` method that performs calculations based on the input value `x`.
 */
public class Calculator {

    /**
     * Calculates a value based on the input value `x`.
     *
     * @param x The input value.
     * @return The calculated result.
     */
    public double Calculate(double x){
        double res;

        try {
            if (x == 0)
                throw new ArithmeticException();
            res = (2 * x) / sin(x);
        }catch (ArithmeticException e){
            System.out.println("Division by zero is not allowed!");
            e.printStackTrace();
            res = 0;
        }

        return res;
    }
}
