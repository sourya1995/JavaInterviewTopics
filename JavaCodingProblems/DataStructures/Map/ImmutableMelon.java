package JavaCodingProblems.DataStructures.Map;



import java.util.Arrays;
import java.util.List;
import java.util.Collections;


public class ImmutableMelon {
    private final String type;
    private final int weight;
    public ImmutableMelon(String type, int weight) {
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
        ImmutableMelon other = (ImmutableMelon) obj;
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
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableMelon{");
        sb.append("type=").append(type);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        ImmutableMelon melon1 = new ImmutableMelon("Crenshaw", 2000);
        ImmutableMelon melon2 = new ImmutableMelon("Gac", 1200);
        List<ImmutableMelon> LIST = Collections.unmodifiableList(Arrays.asList(melon1, melon2));
        List <ImmutableMelon> LIST2 = List.of(melon1, melon2);

        System.out.println(LIST);
        System.out.println(LIST2);

    }

    

    
}

