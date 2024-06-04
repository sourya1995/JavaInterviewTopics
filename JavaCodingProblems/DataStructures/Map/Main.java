package JavaCodingProblems.DataStructures.Map;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



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

        Map<String, Melon> melons = new HashMap<>();
        melons.put("delicious", new Melon("Apollo", 3000));
        melons.put("refreshing", new Melon("Jade Dew", 3500));
        melons.put("famous", new Melon("Cantaloupe", 1500));
        


    }

    public static <A, B> boolean equalsWithArrays(Map<A, B[]> first, Map<A, B[]> second){
        if(first.size() != second.size()) return false;

        return first.entrySet().stream().anyMatch(e -> Arrays.equals(e.getValue(), second.get(e.getKey())));
    }

    public static<K, V> TreeMap<K, V> sortByKeyTreeMap(Map<K, V> map){
        return new TreeMap<>(map);
    } //sorted by natural ordering - will be sorted by natural ordering

    public static<K, V> Map<K, V> sortByKeyStream( Map<K, V> map, Comparator<? super K> c){
       return map.entrySet()
       .stream()
       .sorted(Map.Entry.comparingByKey(c))
       .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static<K, V> Map<K, V> sortByValueStream(Map<K, V> map, Comparator<? super V> c){
        return map.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(c))
        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new)); //LinkedHashMap preserves insertion order
    }

    public static<K extends Comparable, V> List<K> sortByKeyList(Map<K, V> map){
        List<K> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        return list;
    }

    public static<K, V extends Comparable> List<V> sortByValueList(Map<K, V> map) {
        List<V> list = new ArrayList<>(map.values());
        Collections.sort(list);
        return list;

    }

    public static<K, V> HashMap<K, V> shallowCopy(Map<K, V> map){
        HashMap<K, V> copy =  new HashMap<>();
        copy.putAll(map);

        return copy;
    }

    public static<K, V> HashMap<K, V> shallowCopyJava8(Map<K, V> map){
        Set<Entry<K, V>> entries = map.entrySet();
        HashMap<K, V> copy = (HashMap<K, V>) entries.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        copy.putAll(map);

        return copy;
    }

    public static<K, V> Map<K, V> deepCopy(Map<K, V> map){
        Map<K, V> copy = new HashMap<>();
        map.forEach((k, v) -> copy.put(k, v));
        return copy;
    }

    public static<K, V> Map<K, V> mergeMaps(Map<K, V> map1, Map<K, V> map2) {
        Map<K, V> map = new HashMap<>(map1);
       map2.forEach((k, v) -> map.merge(k, v, (v1, v2) -> v2) );
        return map;

    }





}
