package JavaCodingProblems.DeepDiveFunctional.NullSafeFunctional;

import java.util.stream.Stream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class StreamStuff {
    public static<T> Stream<T> elementAsStream(T element){
        return Stream.ofNullable(element); 
        /*ofNullable(): This method takes an object as input. 
        If the object is not null, it creates a stream containing that single object. 
        If the object is null, it creates an empty stream. */
    }

    public static<T> Stream<T> collectionAsStreamWithNulls(Collection<T> element){
        return Stream.ofNullable(element).flatMap(Collection::stream);
    }

    public static<T> Stream<T> collectionAsStreamWithoutNulls(Collection<T> element){
        return element.stream().flatMap(Stream::ofNullable);
    } //collection can contain null values, but itself cannot be null

    public static<T> Stream<T> collectionAsStream(Collection<T> element){
        return Stream.ofNullable(element).flatMap(Collection::stream).flatMap(Stream::ofNullable);
    } // collectionAsStream can contain null, can itself be null



    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(5, null, 6, null, 1, 2);
        System.out.println(StreamStuff.collectionAsStreamWithNulls(ints).count());
        System.out.println(StreamStuff.collectionAsStreamWithoutNulls(ints).count());
    }
}
