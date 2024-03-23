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

    public static void main(String[] args) {
        Sheep original = new Sheep(50, "Dolly");
        Sheep copy = Sheep.newInstance(original);
        System.out.println("Original: " + original.name + ", " + original.weight);
        System.out.println("Copy: " + copy.name + ", " + copy.weight);


    }
    
}
