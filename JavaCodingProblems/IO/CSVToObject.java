package JavaCodingProblems.IO;

import java.nio.file.Path;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.regex.Pattern;

public class CSVToObject {
    public static List<List<String>> readCSVAsObject(Path path, Charset cs, String delimiter) throws IOException {
        List<List<String>> result = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path, cs)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                result.add(Arrays.asList(values));

            }

        }

        return result;
    }

    // For POJOs
    public static List<Club> readClub(Path path, Charset cs, String delimiter) throws IOException {
        List<Club> result = new ArrayList<Club>();
        try (BufferedReader br = Files.newBufferedReader(path, cs)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(Pattern.quote(delimiter));
                result.add(new Club(values[0], Integer.valueOf(values[1])));

            }
        }

        return result;

    }

}
