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

    
}
