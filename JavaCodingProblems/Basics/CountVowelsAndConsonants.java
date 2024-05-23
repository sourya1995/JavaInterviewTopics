package JavaCodingProblems.Basics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Collectors.counting;

/**
 *
 * @author johnw
 */
public class CountVowelsAndConsonants {

    private static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static Pair<Integer, Integer> countVowelsAndConsonants(String input) {
        input = input.toLowerCase();
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (VOWELS.contains(ch)) {
                vowels++;
            } else if(ch >= 'a' && ch <= 'z'5) {
                consonants++;
            }
        }
        return new Pair<Integer, Integer>(vowels, consonants);

    }

    class Pair {

        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static Pair<Integer, Integer> countVowelsAndConsonants2(String input){
        Map<Boolean, Long> result = input.chars()
        .mapToObj(c -> (char) c)
        .filter(ch -> (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
        .collect(Collectors.partitioningBy(ch -> VOWELS.contains(ch), counting()));

        return new Pair<Integer, Integer>(result.get(true).intValue(), result.get(false).intValue());

    }
}
