package Collections.Unmodifiable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyPojoClass {
    private List<Integer> intList = new ArrayList<>();

    public void addValueToList(Integer value) {
        intList.add(value);
    }

    public List<Integer> getIntList(){
        return Collections.unmodifiableList(intList);
    }

}
