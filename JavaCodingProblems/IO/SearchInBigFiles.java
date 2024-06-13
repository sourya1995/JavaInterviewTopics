package JavaCodingProblems.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.regex.Pattern;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SearchInBigFiles {
    private static int CountStringInString(String string, String toFind) {
        return string.split(Pattern.quote(toFind), -1).length - 1;
    }

    // BufferedReader
    public static int countOccurrences(Path path, String text, Charset ch) throws IOException {
        int count = 0;

        try (BufferedReader br = Files.newBufferedReader(path, ch)) {
            String line;
            while ((line = br.readLine()) != null) {
                count += CountStringInString(line, text);
            }
        }

        return count;
    }

    // Files.readAlllines() - uses memory
    public static int countOccurrencesRAM(Path path, String text, Charset ch) throws IOException {
        return Files.readAllLines(path, ch)
                .parallelStream() // or stream
                .mapToInt((p) -> CountStringInString(p, text))
                .sum();
    }

    // Files.lines() - converts to Stream<String>

    public static int countOccurrencesJava8(Path path, String text, Charset ch) throws IOException {
        return Files.lines(path, ch)
                .parallel()
                .mapToInt((p) -> CountStringInString(p, text))
                .sum();
    }

    // using Scanner
    public static int countOccurrencesScanner(Path path, String text, Charset ch) throws IOException {
        long count;
        try (Scanner scanner = new Scanner(path, ch)
                .useDelimiter(Pattern.quote(text))) {
            count = scanner.tokens().count() - 1;

        }

        return (int) count;
    }
    
    //TODO
      public static long countOccurrencesV5(Path path, String text) throws IOException {

        if (path == null || text == null) {
            throw new IllegalArgumentException("Path/text cannot be null");
        }

        if (text.isBlank()) {
            return 0;
        }

        final byte[] texttofind = text.getBytes(StandardCharsets.UTF_8);

        long count = 0;
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {

            long position = 0;
            long length = fileChannel.size();
            while (position < length) {

                long remaining = length - position;
                long bytestomap = (long) Math.min(MAP_SIZE, remaining);
                MappedByteBuffer mbBuffer = fileChannel.map(MapMode.READ_ONLY, position, bytestomap);

                long limit = mbBuffer.limit();
                long lastSpace = -1;
                long firstChar = -1;
                while (mbBuffer.hasRemaining()) {

                    boolean isFirstChar = false;
                    while (firstChar != 0 && mbBuffer.hasRemaining()) {

                        byte currentByte = mbBuffer.get();

                        if (Character.isWhitespace((char) currentByte)) {
                            lastSpace = mbBuffer.position();
                        }

                        if (texttofind[0] == currentByte) {
                            isFirstChar = true;
                            break;
                        }
                    }

                    if (isFirstChar) {

                        boolean isRestOfChars = true;

                        int j;
                        for (j = 1; j < texttofind.length; j++) {
                            if (!mbBuffer.hasRemaining() || texttofind[j] != mbBuffer.get()) {
                                isRestOfChars = false;
                                break;
                            }
                        }

                        if (isRestOfChars) {
                            count++;
                            lastSpace = -1;
                        }

                        firstChar = -1;
                    }
                }

                if (lastSpace > -1) {
                    position = position - (limit - lastSpace);
                }

                position += bytestomap;
            }
        }

        return count;
    }
}
