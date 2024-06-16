package JavaCodingProblems.FunctionalStyleProgramming;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public final class Doubles {

    private Doubles() {
        throw new AssertionError("cannot be instantiated");
    }

    public static double read(ScannerDoubleFunction snf) throws IOException {
        if (snf == null) {
            throw new IllegalArgumentException("Lambda cannot be null");
        }

        try (Scanner scanner = new Scanner(Path.of("file.txt"), StandardCharsets.UTF_8)) {
            return snf.readDouble(scanner);
        }
    }
}
