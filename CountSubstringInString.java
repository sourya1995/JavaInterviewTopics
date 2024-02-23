import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CountSubstringInString {
    public static int countStringInString(String searchText, String text) {
        Pattern pattern = Pattern.compile(searchText);
        Matcher matcher = pattern.matcher(text);

        int stringOccurrences = 0;
        while (matcher.find()) {
            stringOccurrences++;
        }

        return stringOccurrences;
    }

    public static void main(String[] args) {
        // Your main method code here

        String text = "One fish, two fish, three fish, four fish";
        System.out.println(countStringInString("fish", text));
        System.out.println(countStringInString(",", text));
     
    }
}
