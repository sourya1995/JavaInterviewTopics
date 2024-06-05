package JavaCodingProblems.DataStructures.Map.CollectionConversion;
import java.util.*;

public class ToArray {
    List<String> names = Arrays.asList("ana", "mario", "vio");
    //Object[] namesArray = names.toArray(new String[names.size()]);
    Object[] namesArray = names.toArray(String[]::new);
}
