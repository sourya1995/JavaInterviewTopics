package Conversions.Bytes;

import java.nio.charset.StandardCharsets;

public class ConvertBytes {
    public static void main(String[] args) {
        byte[] bytes = "test".getBytes(StandardCharsets.UTF_8); //String to byte array
        String testString = new String(bytes, StandardCharsets.UTF_8); //byte array to String
    }
}
