package JavaCodingProblems.FunctionalStyleProgramming;

import java.util.List;
import java.util.ArrayList;

public class Melon {
    private final String type;
    private final int weight;
    private final String origin;

    public Melon(String type, int weight, String origin) {
        this.type = type;
        this.weight = weight;
        this.origin = origin;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Melon{");
        sb.append("type=").append(type);
        sb.append(", weight=").append(weight);
        sb.append(", origin=").append(origin);
        sb.append('}');
        return sb.toString();
    }

    public static List<Melon> filterByType(List<Melon> melons, String type) {
        List<Melon> result = new ArrayList<>();
        for (Melon m : melons) {
            if (m != null && type.equalsIgnoreCase(m.getType())) {
                result.add(m);
            }
        }
        return result;

    }

    public static List<Melon> filterByWeight(List<Melon> melons, int weight) {
        List<Melon> result = new ArrayList<>();
        for (Melon m : melons) {
            if (m != null && weight == m.getWeight()) {
                result.add(m);
            }
        }
        return result;

    }

    public static List<Melon> filterByWeightAndType(List<Melon> melons, int weight, String type) {
        List<Melon> result = new ArrayList<>();
        for (Melon m : melons) {
            if (m != null && weight == m.getWeight() && type.equals(m.getType())) {
                result.add(m);
            }
        }
        return result;

    }

    public static List<Melon> filterMelons(List<Melon> melons, MelonPredicate predicate) {
        List<Melon> result = new ArrayList<>();

        for (Melon melon : melons) {
            if (melon != null && predicate.test(melon)) {
                result.add(melon);
            }
        }
        return result;
    }

    /*
     * List<Melon> gacs = Filters.filterMelons(
     * melons, new GacMelonPredicate());
     * 
     * List<Melon> huge = Filters.filterMelons(
     * melons, new HugeMelonPredicate());
     */

    public static void main(String[] args) {
        List<Melon> melons = new ArrayList<>();

        List<Melon> europeans = Melon.filterMelons(
                melons, new MelonPredicate() {
                    @Override
                    public boolean test(Melon melon) {
                        return "europe".equalsIgnoreCase(melon.getOrigin());
                    }
                });

        List<Melon> europeanLambda = Melon.filterMelons(melons, (Melon melon) -> "europe".equalsIgnoreCase(melon.getOrigin()));
    }

}
