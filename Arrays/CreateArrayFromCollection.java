package Arrays;

import java.util.HashSet;
import java.util.Set;

public class CreateArrayFromCollection {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");

        Object[] objectArray = set.toArray();
        System.out.println(objectArray);
        String[] stringArray = set.toArray(new String[set.size()]);
        System.out.println(stringArray);

        String[] strings = set.stream().toArray(String[]::new);
        System.out.println(strings);
    }

}
