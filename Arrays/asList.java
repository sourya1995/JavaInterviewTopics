package Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class asList {
    

    public static void main(String[] args) {
        String[] stringArray = { "foo", "bar", "baz" };
        List<String> stringList = Arrays.asList(stringArray); //if you add here, array will get affected
        System.out.println(stringList);
        List<String> stringListCopied = new ArrayList<String>(Arrays.asList(stringArray)); //adding here does not affect the array
        System.out.println(stringListCopied);
    }
}
