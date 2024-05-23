package JavaCodingProblems.Basics;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReverseStrings {
    private static final String WHITESPACE = "";
    private static final Pattern PATTERN = Pattern.compile(" +");

    public String reverseWords(String str){
        String[] words = str.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();
        for(String word : words){
            StringBuilder reversedWord = new StringBuilder();
            for(int i = word.length() - 1; i >= 0; i--){
                reversedWord.append(word.charAt(i));
            }
            reversedString.append(reversedWord).append(WHITESPACE);
        }
        return reversedString.toString().trim();
            
    }

    public String reverseWords2(String str){

        return PATTERN.splitAsStream(str)
        .map(w -> new StringBuilder(w).reverse())
        .collect(Collectors.joining(" "));
    }


}
