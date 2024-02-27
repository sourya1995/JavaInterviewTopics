package Collections.Unmodifiable;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        MyPojoClass pojo = new MyPojoClass();
        pojo.addValueToList(42);
        System.out.println(pojo.getIntList());

        List<Integer> list = pojo.getIntList();
        List<Integer> list2 = new ArrayList<>(pojo.getIntList());
        list2.add(69); //list.add(69) will not work
        
        System.out.println(list2); //42, 69
        System.out.println(list); //42
    }
}
