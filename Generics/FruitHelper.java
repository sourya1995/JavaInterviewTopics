package Generics;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

// Wildcards

class Shoe {
}

class IPhone {
}

interface Fruit {
}

class Apple implements Fruit {
}

class Banana implements Fruit {
}

class GrannySmith extends Apple {
}

public class FruitHelper {
    public void eatAll(Collection<? extends Fruit> fruits) {
    }

    public void putAll(Collection<? super Apple> apples) {
    }

    public <T> List<T> makeList(T t1, T t2) {
        List<T> result = new ArrayList<T>();
        result.add(t1);
        result.add(t2);
        return result;

    }
}
