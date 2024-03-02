package OOP.ImmutableClass;

public class ImmutableArray {
    private final int[] array;

    public ImmutableArray(int[] array) {
        this.array = array.clone();
    }

    public int[] getValue() {
        return array.clone();
    }

    
}
