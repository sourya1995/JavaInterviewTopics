package JavaCodingProblems.Basics;
import java.util.HashMap;
import java.util.Map;


public class CheckAnagrams {
    public static boolean isAnagram(String str1, String str2) {

        if (str1 == null || str2 == null) {
            return false;
        }
        
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        for(char c : str1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for(char c : str2.toCharArray()) {
            if(!map1.containsKey(c)) {
                return false;
            }
            map1.put(c, map1.get(c) - 1);
            if(map1.get(c) == 0) {
                map1.remove(c);
            }
        }

        return map1.isEmpty(); //if true, return - ANAGRAMS else not
    }



     


}
