package JavaCodingProblems.DeepDiveFunctional.Match;

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
    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    
}
