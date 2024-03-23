package Cloning.DeepCopy;

public class SheepCopyConsrtuctor {
    private String name;
    private int weight;
    public SheepCopyConsrtuctor(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public SheepCopyConsrtuctor(SheepCopyConsrtuctor original) {
       this.name = original.name;
       this.weight = original.weight;
    }

    public static void main(String[] args) {
        SheepCopyConsrtuctor original = new SheepCopyConsrtuctor("Dolly", 50);
        SheepCopyConsrtuctor copy = new SheepCopyConsrtuctor(original);
        System.out.println(original.name + " " + original.weight);
        System.out.println(copy.name + " " + copy.weight); 
    }
    }

/* deep copy - copying the fields of existng object, to a NEW OBJECT -> NEW REFERENCE */