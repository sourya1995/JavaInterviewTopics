package Collections.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SortingComparable {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(33L, "A"));
        users.add(new User(22L, "B"));
        users.add(new User(11L, "C"));
        Collections.sort(users);
        for (User user : users) {
            System.out.println(user);
        }

        Collections.sort(users, new Comparator<User>() {

            @Override
            public int compare(User left, User right) {
                // TODO Auto-generated method stub
                return left.username.compareTo(right.username);
            }

        }); // for custom ordering, overriding Comparable
        for (User user : users) {
            System.out.println(user);
        }

        users.sort((l, r) -> l.username.compareTo(r.username)); // lambda expression of Java8

        //List of Integers to String
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<String> strings = numbers.stream().map(Object::toString).collect(Collectors.toList());
       

    }
}
