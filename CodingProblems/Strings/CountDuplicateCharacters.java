package CodingProblems.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountDuplicateCharacters {

    public Map<Character, Integer> countDuplicateCharacters(String str) {
        Map<Character, Integer> result = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            result.compute(ch, (k, v) -> v == null ? 1 : ++v);
        }

        return result;

    }

    public Map<Character, Long> countDuplicateCharactersFunctional(String str) {
        Map<Character, Long> result = str.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return result;
    }

    
    public Map<String, Integer> countDuplicateCharactersASCII(String str) {
        Map<String, Integer> result = new HashMap<String, Integer>();
        for (int i = 0; i < str.length(); i++) {
            int cp = str.codePointAt(i);
            String ch = String.valueOf(Character.toChars(cp));
            if(Character.charCount(cp) == 2){
                i++;
            }
            result.compute(ch, (k, v) -> (v == null) ? 1 : v + 1);
        }

        return result;

    }

    
    public Map<String, Long> countDuplicateCharactersFunctionalASCII(String str) {
        Map<String, Long> result = str.codePoints()
            .mapToObj(c -> String.valueOf(Character.toChars(c)))
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return result;
    }


}
