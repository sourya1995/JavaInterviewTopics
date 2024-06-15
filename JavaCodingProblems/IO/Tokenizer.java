package JavaCodingProblems.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Collections;

import javax.swing.text.AbstractDocument;

public class Tokenizer {
    public static List<String> get(Path path, Charset ch, String delimiter) throws IOException {
        String delimiterStr = Pattern.quote(delimiter);
        List<String> content = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path, ch)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiterStr);
                content.addAll(Arrays.asList(values));
            }
        }

        return content;
    }

    public static List<String> getV2(Path path, Charset ch, String delimiter) throws IOException {
        String delimiterStr = Pattern.quote(delimiter);
        List<String> content = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path, ch)) {
            String line;
            while ((line = br.readLine()) != null) {
                content.addAll(Stream.of(line.split(delimiterStr)).collect(Collectors.toList()));
            }
        }

        return content;
    }

    public static List<String> getV3(Path path, Charset ch, String delimiter) throws IOException {
        try (Stream<String> lines = Files.lines(path, ch)) {
            return lines.map(l -> l.split(Pattern.quote(delimiter))) // or Files.readAllLines for small files
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());
        }
    }

    public static List<String> getV4(Path path, Charset ch, String delimiter) throws IOException {

        Pattern pattern = Pattern.compile(Pattern.quote(delimiter));
        List<String> result = new ArrayList<String>();

        try (BufferedReader reader = Files.newBufferedReader(path, ch)) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(pattern.splitAsStream(line).collect(Collectors.joining(";")));
            }
        }
        return result;
    }

    public static List<String> getV5(Path path, Charset ch, String... delimiters) throws IOException {
        String[] escapedDelimiters = new String[delimiters.length];
        Arrays.setAll(escapedDelimiters, i -> Pattern.quote(delimiters[i]));
        String delimiterStr = String.join("|", escapedDelimiters);

        List<String> content = new ArrayList<String>();
        try (BufferedReader reader = Files.newBufferedReader(path, ch)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(delimiterStr);
                content.addAll(Arrays.asList(values));

            }
        }

        return content;
    }

    public static List<String> getV6(Path path, Charset ch, String delimiters) throws IOException {
        StringTokenizer st;
        List<String> content = new ArrayList<String>();
        try (BufferedReader reader = Files.newBufferedReader(path, ch)) {
            String line;
            while ((line = reader.readLine()) != null) {
                st = new StringTokenizer(line, delimiters);
                while (st.hasMoreTokens()) {
                    content.add(st.nextToken());
                }
            }
        }
        return content;
    }

    public static List<String> getV7(Path path, Charset ch, String delimiter) throws IOException {
       
        List<String> content = new ArrayList<String>();
        try (BufferedReader reader = Files.newBufferedReader(path, ch)) {
            String line;
            while ((line = reader.readLine()) != null) {
               content.addAll(Collections.list(new StringTokenizer(line, delimiter)).stream().map(t -> (String) t).collect(Collectors.toList()));
            }
        }
        return content;
    }

    public static List<String> getV8(Path path, Charset ch, String...delimiters) throws IOException {
        String delimiterStr = String.join("//", delimiters);
        StringTokenizer st;
        List<String> content = new ArrayList<String>();
        try (BufferedReader reader = Files.newBufferedReader(path, ch)) {
            String line;
            while ((line = reader.readLine()) != null) {
                st = new StringTokenizer(line, delimiterStr);
                while (st.hasMoreElements()) {
                    content.add(st.nextToken());
                }
            }
        }
        return content;
    }

}
