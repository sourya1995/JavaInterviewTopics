package JavaCodingProblems.Basics;

import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;



public class MostFrequentCharacter {
    public static char findMostFrequentCharacter(String input) {
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException("Input must not be null or empty");
        }

        Map<Character, Integer> charCountMap = new HashMap<>();
        for(char c : input.toCharArray()){
            if(Character.isWhitespace(c)){
                continue;
            }
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        char mostFrequentCharacter = '\0';
        int maxCount = -1;
        for(Map.Entry<Character, Integer> entry : charCountMap.entrySet()){
            if(entry.getValue() > maxCount){
                mostFrequentCharacter = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostFrequentCharacter;




    }

    public static char findMostFrequentCharacter2(String input) {
        return input.chars()
        .filter(c -> !Character.isWhitespace(c))
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey)
        .orElseThrow(() -> new IllegalStateException("No character found"));
    }


}
