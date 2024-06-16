package JavaCodingProblems.FunctionalStyleProgramming.ObserverPattern;

public class BrookhavenFireStation implements FireObserver {

    @Override
    public void fire(String address) {
       if(address.contains("Brookhaven")){
        System.out.println("Fire in Brookhaven");
       }
    }
    
}
