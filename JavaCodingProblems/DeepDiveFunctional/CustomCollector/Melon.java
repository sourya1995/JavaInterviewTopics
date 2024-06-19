package JavaCodingProblems.DeepDiveFunctional.CustomCollector;

import java.util.List;

public class Melon {

    private final String type;
    private final int weight;
    private final List<String> grown;

    public Melon(String type, int weight, List<String> grown) {
        this.type = type;
        this.weight = weight;
        this.grown = grown;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public List<String> getGrown() {
        return grown;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + weight;
        result = prime * result + ((grown == null) ? 0 : grown.hashCode());
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
        if (grown == null) {
            if (other.grown != null) {
                return false;
            }
        } else if (!grown.equals(other.grown)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Melon [type=" + type + ", weight=" + weight + ", grown=" + grown + "]";
    }

}
