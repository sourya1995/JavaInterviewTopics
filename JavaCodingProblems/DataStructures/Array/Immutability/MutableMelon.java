package JavaCodingProblems.DataStructures.Array.Immutability;

import java.util.Collections;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;



public class MutableMelon {
    private String type;
    private int weight;
    public MutableMelon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }
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
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.type);
        hash = 89 * hash + this.weight;
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
        final MutableMelon other = (MutableMelon) obj;
        if (this.weight != other.weight) {
            return false;
        }
        return Objects.equals(this.type, other.type);
    }
    @Override
    public String toString() {
        return "MutableMelon [type=" + type + ", weight=" + weight + "]";
    }

  /*   private final MutableMelon melon1 = new MutableMelon("Crenshaw", 2000);
    private final MutableMelon melon2 = new MutableMelon("Gac", 1200);
    
    private final List<MutableMelon> melons = Collections.unmodifiableList(Arrays.asList(melon1, melon2));
    melon1.setWeight(0);
    melon2.setWeight(0); */
 

    public static void main(String[] args) {
       
       
     
        MutableMelon melon1 = new MutableMelon("Crenshaw", 2000);
        MutableMelon melon2 = new MutableMelon("Gac", 1200);
        
        List<MutableMelon> melons = Collections.unmodifiableList(Arrays.asList(melon1, melon2));
        List<MutableMelon> melons2 = Collections.unmodifiableList(Arrays.asList(new MutableMelon("Crenshaw", 2000), new MutableMelon("Gac", 1200)));
        List<MutableMelon> melons3 = List.of(melon1, melon2);
        
        melon1.setWeight(0);
        melon2.setWeight(0); //UNMODIFIABLE

        MutableMelon melon3 = melons2.get(0);
        MutableMelon melon4 = melons2.get(1);
        
        melon3.setWeight(0);
        melon4.setWeight(0); //UNMODIFIABLE

        MutableMelon melon5 = melons3.get(0);
        melon5.setWeight(0); //UNMODIFIABLE


        // Print melons to verify changes
        System.out.println(melons);
        System.out.println(melon3 + " " + melon4);  
        System.out.println(melon5);
        
    }

    

    

    
}
