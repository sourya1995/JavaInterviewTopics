package JavaCodingProblems.Basics;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Permutations {

    public static Set<String> permuteAndStore(String str) {
        return permuteAndStore("", str);
    }

    private static Set<String> permuteAndStore(String prefix, String str) {
        Set<String> Permutations = new HashSet<>();
        int n = str.length();

        if (n == 0) {
            Permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                Permutations.addAll(permuteAndStore(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n)));
            }
        }
        return Permutations;
    }

    public static void permuteAndStoreJava8(String prefix, String str) {
        int n = str.length();

        if(n == 0){
            System.out.println(prefix + "");
        } else {
            IntStream.range(0, n)
            .parallel()
            .forEach(i -> permuteAndStoreJava8(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n)));
        }

    }
}
