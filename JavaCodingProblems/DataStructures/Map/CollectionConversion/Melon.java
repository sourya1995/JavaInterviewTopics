package JavaCodingProblems.DataStructures.Map.CollectionConversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.function.UnaryOperator;




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
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + weight;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Melon other = (Melon) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (weight != other.weight)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Melon [type=" + type + ", weight=" + weight + "]";
    }

    public static void main(String[] args) {
        List<Melon> melons = new ArrayList<>();
        melons.add(new Melon("Apollo", 3000));
        melons.add(new Melon("Jade Dew", 3500));
        melons.add(new Melon("Cantaloupe", 1500));
        melons.add(new Melon("Gac", 1600));
        melons.add(new Melon("Hami", 1400));

        List<String> melonsByType = Arrays.asList("Apollo", "Gac", "Crenshaw", "Hami");
        List<Melon> results = melons.stream().filter(t -> melonsByType.contains(t.getType())).collect(Collectors.toList()); //uses a for loop internally
        System.out.println(results);

        //faster way to convert to a list based on the predicate
        Set<String> melonsByType2 = melonsByType.stream().collect(Collectors.toSet());
        List<Melon> resultsSet = melons.stream().filter(t -> melonsByType2.contains(t.getType())).collect(Collectors.toList());

        //replace a melon
        for(int i = 0; i < melons.size(); i++) {
            if(melons.get(i).getWeight() < 3000){
                melons.set(i, new Melon(melons.get(i).getType(), 3000));
            }
        }
        //Java 8
        UnaryOperator<Melon> operator = t  -> (t.getWeight() < 3000) ? new Melon(t.getType(), 3000) : t;
       


    }

}
