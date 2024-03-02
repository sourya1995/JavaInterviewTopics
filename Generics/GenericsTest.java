package Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class GenericsTest {
    public static void main(String[] args) {
        FruitHelper fruitHelper = new FruitHelper();
        List<Fruit> fruits = new ArrayList<Fruit>();
        fruits.add(new Apple());
        fruits.add(new Banana());
        fruitHelper.addApple(fruits);
        fruitHelper.eatAll(fruits);

        Collection<Banana> bananas = new ArrayList<>();
        bananas.add(new Banana());
        fruitHelper.eatAll(bananas);

        Collection<Apple> apples = new ArrayList<>();
        fruitHelper.addApple(apples); // Allowed
        apples.add(new GrannySmith()); 
        fruitHelper.eatAll(apples);

        Collection<Object> objects = new ArrayList<>();
        objects.add(new Shoe());
       

    }
}
