package Streams.IO;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

public class InputStreamToString {
    public String inputStreamToString(InputStream inputStream) throws Exception {
        StringWriter writer = new StringWriter();
        char[] buffer = new char[1024];
        try (Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        }
        return writer.toString();
    }
}
