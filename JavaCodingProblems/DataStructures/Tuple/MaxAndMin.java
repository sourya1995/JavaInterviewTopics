package JavaCodingProblems.DataStructures.Tuple;

import java.util.Map;
import java.util.Comparator;


public class MaxAndMin {
    
    public static<T> Map.Entry<T, T> array(T[] arr, Comparator<? super T> comp){
        T min = arr[0];
        T max = arr[0];

        for(T elem: arr){
            if(comp.compare(min, elem) > 0) {
                min = elem;
            } else if(comp.compare(max, elem) < 0){
                max = elem;
            }
        }

        return entry(min, max);
    }
}
