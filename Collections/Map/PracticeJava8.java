package Collections.Map;

import java.util.HashMap;
import java.util.Map;

public class PracticeJava8 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Cristiano", 877);
        map.put("Lionel", 822);
        map.put("Robert", 675);
        map.put("Zlatan", 580);
        map.put("Thierry", 417);
        map.put("Romario", 800);
        map.put("Angel", 203);
        map.put("Rooney", 366);
        map.put("Suarez", 560);
        map.put("Ramos", 130);
        System.out.println(map.getOrDefault("Berbatov", 340)); // if not present, you get 340
        System.out.println(map.get("Berbatov"));
        // map.forEach((k,v) -> System.out.println(k + " " + v)); //printall
        System.out.println(map.computeIfAbsent("Edin", k -> map.get("Rooney") + 20)); // Edin Dzeko was not present, so
                                                                                      // we calculate and enter
        // map.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println(map.computeIfPresent("Zlatan", (k, v) -> v - 5));
        System.out.println(map.compute("Zlatan", (k, v) -> v + 5));
        System.out.println(map.merge("Cristiano", 50, (k, v) -> map.get("Zlatan")+10)); //Cristiano was present, so update Cristiano - Zlatan's tally + 10
        map.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println(map.merge("Zamorano", 50, (k, v) -> map.get("Zlatan") + 10)); //Zamorano was not present, so update Zamorano - 50
        map.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println(map.computeIfPresent("Cristiano", (k, v) -> v + 287));
        map.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println(map.computeIfAbsent("Zamorano", k -> map.get("Angel") - 3)); //Zamorano is already present, so won't affect
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
