package JavaCodingProblems.DataStructures.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.Arrays;



public class Main {
      public static void main(String[] args) {
        Map<Integer, Melon> mapOfMelon = new HashMap<>();
        mapOfMelon.put(1, new Melon("Apollo", 3000));
        mapOfMelon.put(2, new Melon("Jade Dew", 3500));
        mapOfMelon.put(3, new Melon("Cantaloupe", 1500));

        Melon melon = mapOfMelon.replace(2, new Melon("Gac", 1000));
        System.out.println(mapOfMelon);

        BiFunction<Integer, Melon, Melon> function = (k, v) -> v.getWeight() > 0 ? new Melon(v.getType(), 1000) : v;
        mapOfMelon.replaceAll(function);
        System.out.println(mapOfMelon);


    }

    public static <A, B> boolean equalsWithArrays(Map<A, B[]> first, Map<A, B[]> second){
        if(first.size() != second.size()) return false;
        
        return first.entrySet().stream().allMatch(e ->  Arrays.equals(e.getValue(), second.get(e.getKey())));
    }
}
