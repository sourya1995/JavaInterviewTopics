package Cloning.DeepCopy;


public class Sheep {
    private int weight;
    private String name;
    public Sheep(int weight, String name) {
        this.weight = weight;
        this.name = name;
    }
    
    public static Sheep newInstance(Sheep other){
        return new Sheep(other.weight, other.name);
    }
    
}
