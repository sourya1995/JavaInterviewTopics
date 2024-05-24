package JavaCodingProblems.Basics;

public class CountOccurrencesOfACharacter {
    public static int countCertainCharacter(String str, char c) {
        return str.length() - str.replace(String.valueOf(c) , "").length();

    }

    public static int countCertainCharacter2(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    public String removeWhitespaces(String str) {
        return str.replaceAll("\\s", "");
    }



}
