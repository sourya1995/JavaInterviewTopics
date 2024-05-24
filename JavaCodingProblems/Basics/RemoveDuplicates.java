package JavaCodingProblems.Basics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;



public class RemoveDuplicates {
    
    public static String removeDuplicates(String str){
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(char ch : charArray){
            if(sb.indexOf(String.valueOf(ch)) == -1){
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static String removeDuplicates2(String str){
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        
        for(char ch : charArray){
           if(set.add(ch)){
                sb.append(ch);
           }
        }

        return sb.toString();
    }

    
    public static String removeDuplicates3(String str){
        return Arrays.asList(str.split("")).stream()
        .distinct()
        .collect(Collectors.joining());
    }


}
