package JavaCodingProblems.Basics;

import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class RemoveAGivenCharacter {
    public static String removeCharacter(String str, char ch){
        return str.replaceAll(Pattern.quote(String.valueOf(ch)), "");
    }

    public static String removeCharacter2(String str, char ch){
        StringBuilder sb = new StringBuilder();
        char[] chArray = str.toCharArray();

        for(char c : chArray){
            if(c != ch){
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static String removeCharacter3(String str, char ch) {
        return str.chars()
        .filter(c -> c != ch)
        .mapToObj(c -> String.valueOf((char) c))
        .collect(Collectors.joining());
    }
}
