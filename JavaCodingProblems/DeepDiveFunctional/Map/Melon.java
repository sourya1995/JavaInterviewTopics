package JavaCodingProblems.DeepDiveFunctional.Map;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Collection;

public class Melon {

    private String type;
    private int weight;

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public static void main(String[] args) {
        List<Melon> melons = Arrays.asList(new Melon("Gac", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700));

        List<String> melonNames = melons.stream().map(Melon::getType).collect(Collectors.toList());
        List<Integer> melonWeights = melons.stream().map(Melon::getWeight).collect(Collectors.toList());
        /*  List<Melon> lighterMelons = melons.stream()
                .map(m -> m.setWeight(m.getWeight() - 500))
                .collect(Collectors.toList()); */ //wont do anything

        List<Melon> lighterMelons = melons.stream()
                .map(m -> {
                    m.setWeight(m.getWeight() - 500);
                    return m;
                })
                .collect(Collectors.toList());

        List<Melon> lighterMelonsPeek = melons.stream()
                .peek(m -> m.setWeight(m.getWeight() - 500))
                .collect(Collectors.toList()); //doesn't modify the data structure - BAD PRACTICE

        Melon[][] melonsArray = {
            {new Melon("Gac", 2000), new Melon("Hemi", 1600)},
            {new Melon("Gac", 2000), new Melon("Apollo", 2000)},
            {new Melon("Horned", 1700), new Melon("Hemi", 1600)}
        };

        Stream<Melon[]> streamOfMelonsArray = Arrays.stream(melonsArray);
        streamOfMelonsArray.map(Arrays::stream).distinct().collect(Collectors.toList()); //wont work because it looks for distinct Stream<Melon>

        streamOfMelonsArray.flatMap(Arrays::stream).distinct().collect(Collectors.toList()); //gives each element as unique

        List<List<String>> melonLists = Arrays.asList(
                Arrays.asList("Gac", "Cantaloupe"),
                Arrays.asList("Hemi", "Gac", "Apollo"),
                Arrays.asList("Gac", "Hemi", "Cantaloupe"),
                Arrays.asList("Apollo"),
                Arrays.asList("Horned", "Hemi"),
                Arrays.asList("Hemi"));

       melonLists.stream().map(Collection::stream).distinct(); //returns Stream<Stream<String>> 

       List<String> distinctNames = melonLists.stream().flatMap(Collection::stream).distinct().collect(Collectors.toList());

    }

}
