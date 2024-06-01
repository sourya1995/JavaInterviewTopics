package JavaCodingProblems.DataStructures.Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;


public class Melon {
    private final String type;
    private final int weight;

    public Melon(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    
    public static void main(String[] args) {
        Melon[] melons = {
            new Melon("Cantaloupe", 1500),
            new Melon("Honeydew", 1800),
            new Melon("Watermelon", 2000),
            new Melon("Galia", 1600),
            new Melon("Canary", 1700)
        };

        /*Method 1 of sorting */
        Arrays.sort(melons, new Comparator<Melon>() {
            @Override
            public int compare(Melon a, Melon b){
                return Integer.compare(a.getWeight(), b.getWeight());
            }
        });

        /*Method 2 of sorting */
        Arrays.sort(melons, (a, b) -> Integer.compare(a.getWeight(), b.getWeight()));

        /*Method 3 of sorting, uses ForkJoinPool behind the scenes*/
        Arrays.parallelSort(melons, new Comparator<Melon>() {
            @Override
            public int compare(Melon a, Melon b) {
                return Integer.compare(a.getWeight(), b.getWeight()); //for descending order, multiply by -1
            }
        });

        /*Method 4 of sorting, uses ForkJoinPool behind the scenes */
        Arrays.parallelSort(melons, (a, b) -> Integer.compare(a.getWeight(), b.getWeight()));

        System.out.println(Arrays.toString(melons));

        Integer[] integers = new Integer[] {3, 1, 5};
        Arrays.sort(integers, Collections.reverseOrder());
        for(int leftHead = 0, rightHead = integers.length - 1; leftHead < rightHead; leftHead++, rightHead--){
            int temp = integers[leftHead];
            integers[leftHead] = integers[rightHead];
            integers[rightHead] = temp;
        }

        int[] descIntegers = Arrays.stream(integers)
        .mapToObj(i -> i)
        .sorted((i1, i2) -> Integer.compare(i2, i1))
        .mapToInt(Integer::intValue)
        .toArray();

        System.out.println(Arrays.toString(descIntegers));

    }
}
