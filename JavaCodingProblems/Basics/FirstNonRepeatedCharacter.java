package JavaCodingProblems.Basics;

import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {

    private static final int ASCII_SIZE = 256;

    public char firstNonRepeatedCharacter(String str) {
        int[] flags = new int[ASCII_SIZE];
        for (int i = 0; i < flags.length; i++) {
            flags[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (flags[ch] == -1) {
                flags[ch] = i; // character not seen, so store position
            } else {
                flags[ch] = -2; //character seen, store -2
            }

        }

        int position = Integer.MAX_VALUE;
        for (int i = 0; i < ASCII_SIZE; i++) {
            if (flags[i] >= 0) {
                position = Math.min(position, flags[i]);
            }
        }

        return position == Integer.MAX_VALUE ? Character.MIN_VALUE : str.charAt(position);

    }

    public char firstNonRepeatedCharacterV2(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.compute(ch, (k, v) -> v == null ? 1 : v + 1);

        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return Character.MIN_VALUE;
    }

    public char firstNonRepeatedCharacterJava8(String str) {
        Map<Integer, Long> map = str.chars()
                .mapToObj(c -> c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        return (char) (int) map.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst().map(Map.Entry::getKey).orElse(Integer.valueOf(Character.MIN_VALUE));

    }

}
