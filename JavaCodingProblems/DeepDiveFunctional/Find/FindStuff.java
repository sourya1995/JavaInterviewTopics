package JavaCodingProblems.DeepDiveFunctional.Find;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;

public class FindStuff {

    public static void main(String[] args) {
        List<String> melons = Arrays.asList(
                "Gac", "Cantaloupe", "Hemi", "Gac", "Gac",
                "Hemi", "Cantaloupe", "Horned", "Hemi", "Hemi");

        Optional<String> anyMelon = melons.stream().findAny();

        if(anyMelon.isEmpty()){
            System.out.println("khaali hai bhai");
        } else {
            System.out.println("A melon was found" + anyMelon.get());
        }

        String anyApollo = melons.stream().filter(m -> m.equals("Apollo")).findAny().orElse("nah");

        Optional<String> firstMelon = melons.stream().findFirst();

        if(!firstMelon.isEmpty()){
            System.out.println("The first melon is" + firstMelon.get());
        } else {
            System.out.println("kuch nahi hai bhai");
        }

        String firstApollo = melons.stream().filter(m -> m.equals("Apollo")).findFirst().orElse("nah");
        List<Integer> ints = Arrays.asList(4, 8, 4, 5, 5, 7);

        int result = ints.stream().map(x  -> x * x - 1).filter(x -> x % 2 == 0).findFirst().orElse(-1);

        System.out.println(result);



        System.out.println(anyApollo);
        System.out.println(firstApollo);

    }
}
