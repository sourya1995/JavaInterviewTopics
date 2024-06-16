package JavaCodingProblems.FunctionalStyleProgramming.ObserverPattern;

public class Main {

    public static void main(String[] args) {
        FireStation firestation = new FireStation();
        firestation.registerFireStation(new BrookhavenFireStation());
        firestation.registerFireStation(new ViningsFireStation());

        firestation.registerFireStation((String adderss) -> {
            if (adderss.contains("Brookhaven")) {
                System.out.println("Brookhaven Fire Station");
            } else {
                System.out.println("Vinings Fire Station");
            }
        });

        firestation.registerFireStation((String address) -> {
            if (address.contains("Vinings")) {
                System.out.println("Vinings Fire Station");
            } else {
                System.out.println("Brookhaven Fire Station");
            }
        });

    }
}