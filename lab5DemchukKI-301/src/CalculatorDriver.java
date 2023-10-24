import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CalculatorDriver {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try {
            FileWriter fw = new FileWriter("result.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Test text data
        ArrayList<Double> values = new ArrayList<>();
        values.add(1.0);
        values.add(-2.0);
        values.add(0.0);
        values.add(3.0);

        try {
            FileWriter fw = new FileWriter("textData.txt", false);
            for(double value: values)
                fw.write(value + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        values = calculator.readFile("textData.txt", false);
        calculator.calculate(values);

        // Test text data
        ArrayList<Integer> binaryValues = new ArrayList<>();

        binaryValues.add(1);
        binaryValues.add(-10);
        binaryValues.add(0);
        binaryValues.add(11);

        try {
            FileWriter fw = new FileWriter("binaryData.txt", false);
            for(int value: binaryValues)
                fw.write(value + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        values = calculator.readFile("binaryData.txt", true);
        calculator.calculate(values);
    }
}