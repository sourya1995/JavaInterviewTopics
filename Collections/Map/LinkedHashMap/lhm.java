package Collections.Map.LinkedHashMap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class lhm {
    public static void main(String[] args) {
        LinkedHashMap<String, String> lhm = new LinkedHashMap<>();
        lhm.put("Ramesh", "Intermediate");
        lhm.put("Shiva", "B-Tech");
        lhm.put("Santosh", "B-Com");
        lhm.put("Asha", "Msc");
        lhm.put("Raghu", "M-Tech");

        System.out.println(lhm);
        Set set = lhm.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry m = (Map.Entry) it.next();
            System.out.println(m.getKey() + " " + m.getValue());
        }
        System.out.println("The key contains: " + lhm.containsKey("Ramesh"));
        System.out.println("The value contains: " + lhm.get("Asha"));
        
    }
}
