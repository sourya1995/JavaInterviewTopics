package JavaCodingProblems.DataStructures.Array;



public class GenericArray2<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray2(int size){
        array = (T[]) new Object[size];
    }

    public void set(int index, T value) {
        array[index] = value;
    }

    public T get(int index){
        return array[index];
    }

    public int length() {
        return array.length;
    }

    
}
