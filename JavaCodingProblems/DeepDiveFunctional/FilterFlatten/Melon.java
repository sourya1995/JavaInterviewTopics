package JavaCodingProblems.DeepDiveFunctional.FilterFlatten;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.teeing;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Melon {

    private final String type;
    private final int weight;
    private final List<String> pests;

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
        this.pests = new ArrayList<>();
    }

    public Melon(String type, int weight, List<String> pests) {
        this.type = type;
        this.weight = weight;
        this.pests = pests;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public List<String> getPests() {
        return pests;
    }

    @Override
    public String toString() {
        return type + "(" + weight + "g)" + (pests.size() > 0 ? " " + pests : "");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + this.weight;
        hash = 53 * hash + Objects.hashCode(this.pests);
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
        if (!Objects.equals(this.pests, other.pests)) {
            return false;
        }
        return true;

    }

    public static void main(String[] args) {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Hemi", 2000), new Melon("Crenshaw", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600));

        List<Melon> melonsGrown = Arrays.asList(
                new Melon("Honeydew", 5600,
                        Arrays.asList("Spider Mites", "Melon Aphids", "Squash Bugs")),
                new Melon("Crenshaw", 2000,
                        Arrays.asList("Pickleworms")),
                new Melon("Crenshaw", 1000,
                        Arrays.asList("Cucumber Beetles", "Melon Aphids")),
                new Melon("Gac", 4000,
                        Arrays.asList("Spider Mites", "Cucumber Beetles")),
                new Melon("Gac", 1000,
                        Arrays.asList("Squash Bugs", "Squash Vine Borers")));


        /*I want to take all the melons that are heavier than 2,000 g and group them by
their type. For each type, add them to the proper container (there is a container for each type –
just check the container's labels). */
        Map<String, Set<Melon>> byType = melons.stream().collect(groupingBy(Melon::getType, filtering(m -> m.getWeight() < 2000, toSet())));
        Map<String, Set<Melon>> byTypeNormal = melons.stream().filter(m -> m.getWeight() > 2000).collect(groupingBy(Melon::getType, toSet())); //traditional way, but predicate failures won't appear

        /*This time, I am interested only in the melons of the Hemi type. There are two
containers: one for Hemi melons lighter than (or equal to) 2,000 g and one for Hemi melons
heavier than 2,000 g. */
        Map<Boolean, Set<Melon>> melonsFiltering = melons.stream().collect(partitioningBy(m -> m.getWeight() > 2000, filtering(m -> m.getType().equals("Hemi"), toSet())));
        Map<Boolean, Set<Melon>> melonsFilteringNormal = melons.stream().filter(m -> m.getType().equals("Hemi")).collect(partitioningBy(m -> m.getWeight() > 2000, toSet()));


        /* For each type of melon, I want the list of weights in ascending order */
        Map<String, TreeSet<Integer>> ascOrder = melons.stream().collect(groupingBy(Melon::getType, mapping(Melon::getWeight, toCollection(TreeSet::new))));

        /*I want two lists. One should contain the melon types lighter than (or equal to) 2,000 g and the other one should contain the rest of the types. */
        Map<Boolean, Set<String>> partitionWeight = melons.stream().collect(partitioningBy(m -> m.getWeight() > 2000, mapping(Melon::getType, toSet())));

        /*For each type of melon, I want a list of their pests. */
        Map<String, Set<String>> pestMap = melonsGrown.stream().collect(groupingBy(Melon::getType, flatMapping(m -> m.getPests().stream(), toSet())));

        /* I want two lists. One should contain the pests of melons lighter than 2,000 g,
and the other should contain the pests of the rest of melons.
         */
        Map<Boolean, Set<String>> pestsFlatMapping = melonsGrown.stream().collect(partitioningBy(m -> m.getWeight() > 2000, flatMapping(m -> m.getPests().stream(), toSet())));

        /*Teeing Example */
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<String, Double> result = numbers.stream().collect(Collectors.teeing(Collectors.summingDouble(Integer::doubleValue), Collectors.averagingDouble(Integer::doubleValue), (sum, avg) -> Map.of("Sum", sum, "Average", avg)));
        //JDK 12

        double sum = numbers.stream()
           .mapToDouble(Integer::doubleValue)
           .sum();
        double average = numbers.stream()
           .mapToDouble(Integer::doubleValue)
           .average()
           .orElse(0.0); // Handle case where average is not defined

        Map<String, Double> resultNormal = Map.of("Sum", sum, "Average", average); //traditional way

        System.out.println(result);


    }
}
