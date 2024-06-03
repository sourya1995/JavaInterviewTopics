package JavaCodingProblems.DataStructures.Array;

import java.lang.reflect.Array;


public class GenericArray<T> {
    private T[] array;

    public GenericArray(Class<T> clazz, int size) {
        array = (T[]) Array.newInstance(clazz, size);
    }

    public void set(int index, T value) {
        array[index] = value;
    }

    public T get(int index){
        return array[index];
    }

    public int length(){
        return array.length;
    }
}
