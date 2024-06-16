package JavaCodingProblems.FunctionalStyleProgramming.ExecuteAroundPattern;

import java.util.Scanner;

public class Main {

    private static double getFirst(Scanner scanner) {
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        }
        return Double.NaN;
    }

    private static double sumAll(Scanner scanner) {
        double sum = 0.0d;
        while (scanner.hasNextDouble()) {
            sum += scanner.nextDouble();
        }
        return sum;
    }

}
