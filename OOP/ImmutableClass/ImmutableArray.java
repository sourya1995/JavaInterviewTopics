package OOP.ImmutableClass;

public class ImmutableArray {
    private final int[] array;

    public ImmutableArray(int[] array) {
        this.array = array.clone(); // copy the array
    }

    public int[] getValue() {
        return array.clone();
    }

}
