package JavaCodingProblems.Basics;

public class LongestCommonPrefix {

    public static String findLongestCommonPrefix(String[] strings) {
        String commonPrefix = strings[0];

        for (String currentString : strings) {
            while (!currentString.startsWith(commonPrefix)) {
                if (commonPrefix.isEmpty()) {
                    return " ";
                }
                commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
            }
        }
        return commonPrefix;
    }
}
