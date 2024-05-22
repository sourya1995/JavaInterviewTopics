package JavaCodingProblems.Basics;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountingDuplicateCharacters {
    public Map<Character, Integer> countDuplicateCharacters(String str){
        Map <Character, Integer> result = new HashMap<>();
        for(char c : str.toCharArray()){
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        return result;

    }

    public Map<Character, Integer> countDuplicateCharacters2(String str){
        Map <Character, Integer> result = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            result.compute(c, (k, v) -> (v == null) ? 1 : v + 1);
        }

        return result;

    }

    public Map<Character, Long> countDuplicateCharactersJava8(String str){
        Map<Character, Long> result = str.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return result;

    }

    public Map<String, Integer> countDuplicateCharactersUnicode(String str){
        Map<String, Integer> result = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            int cp = str.codePointAt(i);
            String ch = String.valueOf(Character.toChars(cp)); //convert codePoint to integer -> character -> string
            if(Character.charCount(cp) == 2){
                i++; //skip the next character because surrogate pair
            }

            result.compute(ch, (k, v) -> (v == null) ? 1 : v + 1);
        }
        return result;

    }

    public Map<String, Long> countDuplicateCharactersUnicodeJava8(String str){
        Map<String, Long> result = str.codePoints()
            .mapToObj(cp -> String.valueOf(Character.toChars(cp)))
            .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        return result;


    }

}
