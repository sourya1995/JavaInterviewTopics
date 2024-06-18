package JavaCodingProblems.DeepDiveFunctional.Match;

import java.util.Arrays;
import java.util.List;


public class MatchStuff {

    List<String> melons = Arrays.asList(
            "Gac", "Cantaloupe", "Hemi", "Gac", "Gac", "Hemi",
            "Cantaloupe", "Horned", "Hemi", "Hemi");

    boolean isGac = melons.stream().anyMatch(m -> m.equals("Gac"));
    boolean isNoneGac = melons.stream().noneMatch(m -> m.equals("Gac"));
    boolean isAllGac = melons.stream().allMatch(m -> m.equals("Gac"));
    boolean nameLargerThan2 = melons.stream().allMatch(m -> m.length() > 2);

    List<Melon> melons2 = Arrays.asList(new Melon("Gac", 2000),
            new Melon("Hemi", 1600), new Melon("Gac", 3000),
            new Melon("Apollo", 2000), new Melon("Horned", 1700));

    int totalWeight = melons2.stream().mapToInt(Melon::getWeight).sum();
    int maxWeight = melons2.stream().mapToInt(Melon::getWeight).max().orElse(-1);
    int minWeight = melons2.stream().mapToInt(Melon::getWeight).min().orElse(-1);

    int totalReduce = melons2.stream().map(Melon::getWeight).reduce(0, (m1, m2) -> m1 + m2);
    int minReduce = melons2.stream().map(Melon::getWeight).reduce(Integer::min).orElse(-1);




}
