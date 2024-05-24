package JavaCodingProblems.Basics;

import java.util.stream.IntStream;

public class Palindrome {

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (right > left) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;

        }
        return true;
    }

    public static boolean isPalindrome2(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        
        
        }
        return true;
    }

    public static boolean isPalindrome3(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static boolean isPalindrome4(String str) {
        return IntStream.range(0, str.length() / 2)
        .noneMatch(p -> str.charAt(p) != str.charAt(str.length() - p - 1));
    }

}
