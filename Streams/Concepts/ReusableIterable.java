package Streams.Concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReusableIterable {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("FOO", "BAR");
        Iterable<String> iterable = () -> list.stream().map(String::toLowerCase).iterator();
        for (String s : iterable) {
            System.out.println(s);
        }

        for(String s : iterable){
            System.out.println(s);
        }

        
    }
}
