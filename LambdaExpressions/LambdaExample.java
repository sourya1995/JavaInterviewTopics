package LambdaExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaExample {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Jeroen", 20));
        personList.add(new Person("Jack", 5));
        personList.add(new Person("Lisa", 19));
        print(personList, p -> p.getAge() >= 18);

    }

    private static void print(List<Person> personList, Predicate<Person> checker) {

        for (Person person : personList) {
            if (checker.test(person)) {
                System.out.println(person + "matches your expression");
            } else {
                System.out.println(person + "does not match your expression");
            }
        }
    }
}

/* The print(personList, p -> p.getAge() >= 18); method takes a lambda expression (because the Predicate is
used a parameter) where you can define the expression that is needed. The checker's test method checks if this
expression is correct or not: checker.test(person).

You can easily change this to something else, for example to print(personList, p ->
p.getName().startsWith("J"));. This will check if the person's name starts with a "J" */
