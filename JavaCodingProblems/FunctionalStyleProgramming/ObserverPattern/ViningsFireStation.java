package JavaCodingProblems.FunctionalStyleProgramming.ObserverPattern;

public class ViningsFireStation implements FireObserver {

    @Override
    public void fire(String address) {
        if(address.contains("Vinings")){
            System.out.println("Fire detected at " + address);
        }
    }
    
}
