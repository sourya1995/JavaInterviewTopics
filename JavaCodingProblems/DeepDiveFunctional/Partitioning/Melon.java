package JavaCodingProblems.DeepDiveFunctional.Partitioning;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.toList;



import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;






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
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 1200),
                new Melon("Gac", 3000), new Melon("Hemi", 2600),
                new Melon("Hemi", 1600), new Melon("Gac", 1200),
                new Melon("Apollo", 2600), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600));

        Map<Boolean, List<Melon>> byWeight = melons.stream().collect(partitioningBy(m -> m.getWeight() > 2000));
        Map<Boolean, List<Melon>> byWeightDistinct = melons.stream().distinct().collect(partitioningBy(m -> m.getWeight() > 2000));
        Map<Boolean, Long> byWeightAndCount = melons.stream().collect(partitioningBy(m -> m.getWeight() > 2000, counting()));
        Map<Boolean, Long> byWeightAndCountDistinct = melons.stream().distinct().collect(partitioningBy(m -> m.getWeight() > 2000, counting()));
        Map<Boolean, Melon> byWeightMax = melons.stream().collect(partitioningBy(m -> m.getWeight() > 2000, collectingAndThen(maxBy(comparingInt(Melon::getWeight)), Optional::get)));
        

    }
}
