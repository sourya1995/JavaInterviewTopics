package OOP.ImmutableClass;

import java.util.List;
import java.util.ArrayList;

public final class Names {
    private final List<String> names;

    public Names(List<String> names) {
        // this.names = names; - will use the same names collection
        this.names = new ArrayList<String>(names); // creating a new list, but with the same values - COPIED
    }

    public List<String> getNames() {
        // return names; - returning the same list, but altered
        return new ArrayList<String>(names); // returning a new list, but with the same values - COPIED
    }

    public int size() {
        return names.size();
    }

    public String getName(int index) {
        return names.get(index);
    }

    public static void main(String[] args) {
        List<String> namesList = new ArrayList<String>();
        namesList.add("Average Joe");
        Names names = new Names(namesList);
        System.out.println(names.size());
        namesList.add("Magic Mike");
        System.out.println(names.size());
    }

}
