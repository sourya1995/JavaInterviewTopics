package Generics;

public class Param<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Param<Integer> param = new Param<>();
        param.setValue(100);
        System.out.println(param.getValue());

        Param<String[]> stringArrayParam; //legal
        Param<int[][]> int2dArrayParam; //legal
        Param<Param<Object>> objectNestedParam; //legal
    }

}

/* T is type parameter */
