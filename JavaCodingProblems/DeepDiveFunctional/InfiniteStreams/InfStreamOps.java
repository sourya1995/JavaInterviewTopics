package JavaCodingProblems.DeepDiveFunctional.InfiniteStreams;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.function.Supplier;
import java.security.SecureRandom;



public class InfStreamOps {

    private static String randomPassword() {
        String chars = "abcd0123!@#$";
        return new SecureRandom().ints(8, 0, chars.length())
                .mapToObj(i -> String.valueOf(chars.charAt(i)))
                .collect(Collectors.joining());

    }
    public static void main(String[] args) {
        // Stream<Integer> infStream = Stream.iterate(1, n -> n <= 10, n -> n + 1);

        // Stream<Integer> infStream2 = Stream.iterate(1, n -> n <= 10, n -> n + 1 % 2 == 0 ? new Random().nextInt(20) : -1 * new Random().nextInt(10));
        // // infStream.limit(10).forEach(System.out::println);
        // List<Integer> result = infStream
        // .filter(i -> i % 2 == 0)
        // .limit(10)
        // .collect(Collectors.toList());
        // // System.out.println(result);
        // List<Integer> result3 = infStream.filter(i -> i % 2 == 0).limit(1200).collect(Collectors.toList());
        // System.out.println(result3);
        IntStream rndInfStream = new Random().ints(20, 48, 126); //primitive
        String result4 = rndInfStream.
                peek(s -> System.out.println("\tstream(): + s")).mapToObj(n -> String.valueOf((char) n)).
                peek(s -> System.out.println("\tmapToObj(): + s ")).collect(Collectors.joining());
        System.out.println(result4);

        Supplier<String> passwordSupplier = InfStreamOps::randomPassword;
        // System.out.println(passwordSupplier.get());
        Stream<String> passwordStream = Stream.generate(passwordSupplier);
        passwordStream.limit(10).forEach(System.out::println);



    }
}
