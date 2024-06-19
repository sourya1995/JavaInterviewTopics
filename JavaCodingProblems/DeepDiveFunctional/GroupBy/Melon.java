package JavaCodingProblems.DeepDiveFunctional.GroupBy;

import java.util.Objects;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.Collection;
import java.util.Optional;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.maxBy;

public class Melon {

    enum Sugar {
        LOW, MEDIUM, HIGH, UNKNOWN
    }

    private final String type;
    private final int weight;
    private final Sugar sugar;

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
        this.sugar = Sugar.UNKNOWN;
    }

    public Melon(String type, int weight, Sugar sugar) {
        this.type = type;
        this.weight = weight;
        this.sugar = sugar;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public Sugar getSugar() {
        return sugar;
    }

    @Override
    public String toString() {
        return type + "(" + weight + "g)" + (sugar != Sugar.UNKNOWN ? " " + sugar : "");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + this.weight;
        hash = 53 * hash + Objects.hashCode(this.sugar);
        return hash;
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
        final Melon other = (Melon) obj;
        if (this.weight != other.weight) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.sugar, other.sugar)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Melon> melons = Arrays.asList(
                new Melon("Crenshaw", 1200),
                new Melon("Gac", 3000), new Melon("Hemi", 2600),
                new Melon("Hemi", 1600), new Melon("Gac", 1200),
                new Melon("Apollo", 2600), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600)
        );

        List<Integer> allWeights = new ArrayList<>(100);

        Map<String, List<Melon>> byTypeInList = melons.stream()
                .collect(groupingBy(Melon::getType));

        System.out.println(byTypeInList);

        Map<Integer, List<Melon>> byWeightInList = melons.stream()
                .collect(groupingBy(Melon::getWeight));

        System.out.println(byWeightInList);
        /* 
        Map<Sugar, List<Melon>> bySugarInList = melons.stream()
                .collect(groupingBy(Melon::getSugar));

        System.out.println(bySugarInList); */

        //to eliminate duplicates, we need to use set
        Map<String, Set<Melon>> byTypeInSet = melons.stream()
                .collect(groupingBy(Melon::getType, toSet()));

        System.out.println(byTypeInSet);

        //or we can also use distinct with List
        Map<Integer, List<Melon>> byWeightInListDistinct = melons.stream()
                .distinct()
                .collect(groupingBy(Melon::getWeight));

        System.out.println(byWeightInListDistinct);

        //use TreeMap for ordering
        Map<Integer, Set<Melon>> byWeightInSetOrder = melons.stream()
                .collect(groupingBy(Melon::getWeight, TreeMap::new, toSet()));

        System.out.println(byWeightInSetOrder);

        Map<String, Set<Melon>> byTypeInSetOrder = melons.stream()
                .collect(groupingBy(Melon::getType, TreeMap::new, toSet()));
        System.out.println(byTypeInSetOrder);

        //divide all weights into 10 chunked lists
        final AtomicInteger count = new AtomicInteger();
        Collection<List<Integer>> chunkWeights = allWeights.stream().collect(Collectors.groupingBy(c -> count.getAndIncrement() / 10)).values();
        System.out.println(chunkWeights);

        //create a map, where all melons are grouped by weight
        Map<Integer, Set<String>> byWeightInSetOrdered = melons.stream().collect(groupingBy(Melon::getWeight, TreeMap::new, mapping(Melon::getType, toSet())));

        //count each type
        Map<String, Long> typesCount = melons.stream().collect(groupingBy(Melon::getType, TreeMap::new, counting()));

        //count each type by weight
        Map<Integer, Long> weightsCount = melons.stream().collect(groupingBy(Melon::getWeight, TreeMap::new, counting()));

        //max Melon by type
        Map<String, Optional<Melon>> maxMelonByType = melons.stream().collect(groupingBy(Melon::getType, maxBy(comparingInt(Melon::getWeight))));

        //max Melon by type 
        Map<String, Integer> maxMelonByTypeOtherWay = melons.stream().collect(groupingBy(Melon::getType, collectingAndThen(maxBy(comparingInt(Melon::getWeight)), m -> m.orElseThrow().getWeight())));

        Map<String, Melon[]> byTypeArray = melons.stream()
                .collect(groupingBy(Melon::getType, collectingAndThen(
                        Collectors.toList(), l -> l.toArray(Melon[]::new))));

    }
}
