package JavaCodingProblems.DeepDiveFunctional.Join;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

        String melonNames = melons.stream().map(Melon::getType).distinct().sorted().collect(Collectors.joining(",", "Available melons: ", " Take it "));
        System.out.println(melonNames);

        int sumWeightsGrams = melons.stream().collect(Collectors.summingInt(Melon::getWeight));
        
        int sumWeightsGramsReduce = melons.stream().collect(Collectors.reducing(0, m -> m.getWeight(), (m1, m2) -> m1 + m2));
        int sumWeightsGramsReduce2 = melons.stream().collect(Collectors.reducing(0, m -> m.getWeight(), Integer::sum));
        System.out.println("Total weight in grams: " + sumWeightsGramsReduce);

        String str = "Lorem Ipsum is simply dummy text ...";

        long numberOWords = Stream.of(str).map(m -> m.split("\\s+")).flatMap(Arrays::stream).filter(w -> w.trim().length() > 0).count();
        long numberOWordsCollect = Stream.of(str).map(m -> m.split("\\s+")).flatMap(Arrays::stream).filter(w -> w.trim().length() > 0).collect(Collectors.counting());
        long numberOWordsCollect3 = Stream.of(str).map(m -> m.split("\\s+")).flatMap(Arrays::stream).filter(w -> w.trim().length() > 0).collect(Collectors.reducing(0L, m -> 1L, Long::sum));
        System.out.println(numberOWords);


    }
}
