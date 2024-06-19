package JavaCodingProblems.DeepDiveFunctional.Composition;

import java.util.Objects;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;



public class Melon {

    private final String type;
    private final int weight;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.type);
        hash = 67 * hash + this.weight;
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
        return Objects.equals(this.type, other.type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Melon{");
        sb.append("type=").append(type);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        List<Melon> melons = Arrays.asList(new Melon("Gac", 2000),
                new Melon("Horned", 1600), new Melon("Apollo", 3000),
                new Melon("Gac", 3000), new Melon("Hemi", 1600));

        Predicate<Melon> p2000 = m -> m.getWeight() > 2000;
        Predicate<Melon> p300 = p2000.and(m -> m.getType().equals("Gac")).or(m -> m.getType().equals("Apollo"));
        Predicate<Melon> RestOf = p300.negate();
        Predicate<Melon> pNot2000 = Predicate.not(m -> m.getWeight() > 2000);

        List<Melon> result = melons.stream().filter(p300).collect(Collectors.toList());
        List<Melon> result2 = melons.stream().filter(RestOf).collect(Collectors.toList());
        List<Melon> result3 = melons.stream().filter(pNot2000).collect(Collectors.toList());






    }

}
