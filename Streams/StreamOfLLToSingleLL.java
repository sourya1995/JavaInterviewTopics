package Streams;

import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamOfLLToSingleLL<T> {

    public void processStream() {
        Stream<LinkedList<T>> listStream = Stream.of(new LinkedList<>(), new LinkedList<>());
        Optional<LinkedList<T>> bigList = listStream.reduce(/*
                                                             * new LinkedList<>() here is an identity, cannot be wrapped
                                                             * in an Optional
                                                             */(LinkedList<T> list1, LinkedList<T> list2) -> {
            LinkedList<T> returnList = new LinkedList<>(list1);
            returnList.addAll(list2);
            return returnList;
        });

        bigList.ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        StreamOfLLToSingleLL<String> instance = new StreamOfLLToSingleLL<>();
        instance.processStream();
    }

};
