package JavaCodingProblems.DeepDiveFunctional.Composition;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
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

        Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);
        Comparator<Melon> byType = Comparator.comparing(Melon::getType);

        List<Melon> sortedMelons = melons.stream().sorted(byWeight).collect(Collectors.toList());

        Comparator<Melon> byWeightAndType = Comparator.comparing(Melon::getType).thenComparing(Melon::getWeight);
        List<Melon> sortedMelon3 = melons.stream().sorted(byWeightAndType).collect(Collectors.toList()); // String.CASE_INSENSITIVE_ORDER
                                                                                                         // for caps

        Function<Double, Double> f = x -> x * 2;
        Function<Double, Double> g = x -> Math.pow(x, 2);
        Function<Double, Double> gf = f.andThen(g);
        double resultgf = gf.apply(4d); // 64.0
        Function<Double, Double> fg = f.compose(g); // 8.0 execute g first
        double resultfg = fg.apply(4d);
        System.out.println(resultgf);
        System.out.println(resultfg);



    }

}
