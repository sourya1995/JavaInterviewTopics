package JavaCodingProblems.DeepDiveFunctional.Collect;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.TreeSet;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import java.util.stream.Stream;


public class Melon {

    private String type;
    private int weight;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + weight;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Melon other = (Melon) obj;
        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }
        if (weight != other.weight) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Melon [type=" + type + ", weight=" + weight + "]";
    }

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public static void main(String[] args) {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Cantaloupe", 2600));

        List<Integer> weightsList = melons.stream().map(Melon::getWeight).filter(x -> x >= 1000).collect(Collectors.toList()); //gives an ArrayList
        System.out.println(weightsList);
        System.out.println(weightsList.getClass());

        List<Integer> weightsArray = melons.stream().map(Melon::getWeight).filter(x -> x >= 1000).collect(Collectors.toCollection(ArrayList::new)); //gives an ArrayList
        System.out.println(weightsArray);
        System.out.println(weightsArray.getClass());

        Set<Integer> weightsSet = melons.stream().map(Melon::getWeight).filter(x -> x >= 1000).collect(Collectors.toSet());
        System.out.println(weightsSet);
        System.out.println(weightsSet.getClass());

        Set<Integer> weightsHashSet = melons.stream().map(Melon::getWeight).filter(x -> x >= 1000).collect(Collectors.toCollection(HashSet::new));
        System.out.println(weightsHashSet);
        System.out.println(weightsHashSet.getClass());

        Set<Integer> weightsTreeSet = melons.stream().map(Melon::getWeight).filter(x -> x >= 1000).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(weightsTreeSet);
        System.out.println(weightsTreeSet.getClass()); //natural order

        Map<String, Integer> weightsMap = melons.stream().distinct().collect(Collectors.toMap(Melon::getType, Melon::getWeight));
        System.out.println(weightsMap);
        System.out.println(weightsMap.getClass());

        Map<Integer, Integer> weightsMapRandom = melons.stream().distinct()
                .map(x -> Map.entry(new Random().nextInt(Integer.MAX_VALUE), x.getWeight())).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
        System.out.println(weightsMapRandom);
        System.out.println(weightsMapRandom.getClass());

        Map<String, Integer> weightsMapUpdated = melons.stream().distinct().collect(Collectors.toMap(Melon::getType, Melon::getWeight, (oldValue, newValue) -> oldValue));
        System.out.println(weightsMapUpdated);
        System.out.println(weightsMapUpdated.getClass());

        Map<String, Integer> comparisonMap = melons.stream().sorted(Comparator.comparingInt(Melon::getWeight)).collect(Collectors.toMap(Melon::getType, Melon::getWeight, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(comparisonMap);
        System.out.println(comparisonMap.getClass());

        String str = "Lorem Ipsum is simply Ipsum Lorem not simply Ipsum";
        Map<String, Integer> frequencyMap = Stream.of(str).map(w -> w.split("\\s+")).flatMap(Arrays::stream).collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));
        System.out.println(frequencyMap);
        System.out.println(frequencyMap.getClass());








    }

}
