import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.sin;

/**
 * The Calculator class performs calculations on a list of numbers and handles file input/output.
 */
public class Calculator {

    /**
     * Calculate the result for each element in the ArrayList and write the results to a text file.
     *
     * @param arr An ArrayList of numbers on which calculations are performed.
     */
    public void calculate(ArrayList<Double> arr) {
        for (double el : arr) {
            try {
                if (el == 0)
                    throw new ArithmeticException(String.valueOf(el));
                writeTextData(2 * el / sin(el));

            } catch (ArithmeticException e) {
                System.out.println("Division by zero is not allowed!");
                e.printStackTrace();
            }
        }
    }

    /**
     * Read data from a file and store it in an ArrayList.
     *
     * @param fileName  The name of the file to read data from.
     * @param isBinary  True if the file contains binary data, false for decimal data.
     * @return An ArrayList of read data.
     */
    public ArrayList<Double> readFile(String fileName, boolean isBinary) {
        ArrayList<Double> arr = new ArrayList<>();

        try {
            FileReader fr = new FileReader(fileName);
            Scanner sc = new Scanner(fr);

            if (isBinary) {
                while (sc.hasNext())
                    arr.add((double) Integer.parseInt(sc.nextLine(), 2));
            } else {
                while (sc.hasNext())
                    arr.add(Double.valueOf(sc.nextLine()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return arr;
    }

    /**
     * Write the calculated result to a text file in both decimal and binary formats.
     *
     * @param y The calculated result to be written to the file.
     */
    public void writeTextData(double y) {
        try {
            FileWriter fw = new FileWriter("result.txt", true);
            fw.write("Decimal result: " + y + "\n");
            fw.write("Binary result: " + (y < 0 ? "-" : "+")
                    + Integer.toBinaryString(abs((int) y))
                    + "."
                    + Integer.toBinaryString(
                    Integer.parseInt(
                            String.valueOf(y % 1).substring(3, 8)
                    )
            )
                    + "\n");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}