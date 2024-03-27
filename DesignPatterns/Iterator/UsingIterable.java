package DesignPatterns.Iterator;

import java.util.List;
import java.util.Arrays;

public class UsingIterable {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
       Iterable<Integer> iterable = numbers;
        for (Integer number : iterable) {
            System.out.println(number);
        }

        while(iterable.iterator().hasNext()){
            System.out.println(iterable.iterator().next());
        }

    }
}
