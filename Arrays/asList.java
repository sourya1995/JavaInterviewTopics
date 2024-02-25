package Arrays;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class asList {

    public static void main(String[] args) {
        String[] stringArray = { "foo", "bar", "baz" };
        List<String> stringList = Arrays.asList(stringArray); // if you add here, array will get affected - not supported
        System.out.println(stringList);
        List<String> stringListCopied = new ArrayList<String>(Arrays.asList(stringArray)); // adding here does not
                                                                                           // affect the array
        System.out.println(stringListCopied);

        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(stringArray));
        System.out.println(list);

        ArrayList list2 = new ArrayList<>();
        Collections.addAll(list2, stringArray);
        System.out.println(list2);
    }
}
