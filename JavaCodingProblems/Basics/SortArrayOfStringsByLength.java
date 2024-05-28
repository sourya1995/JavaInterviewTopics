package JavaCodingProblems.Basics;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayOfStringsByLength {
    public static void sortArrayByLength(String[] strs){
       Arrays.sort(strs, Comparator.comparingInt(String::length));
       Arrays.sort(strs, Comparator.comparing(String::length).reversed()); //for desc
    }

    public static String[] sortArrayByLength(String[] strs){
        return Arrays.stream(strs)
        .sorted(Comparator.comparingInt(String::length))
        .toArray(String[]::new);

        //return Arrays.stream(strs)
    //    .sorted(Comparator.comparing(String::length).reversed())
    //    .toArray(String[]::new); for desc

    }
}
