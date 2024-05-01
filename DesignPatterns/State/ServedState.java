package DesignPatterns.State;

public class ServedState implements BiryaniState {

    @Override
    public void cook(MuttonBiryani biryani) {
       System.out.println("cannot cook served Biryani");
    }

    @Override
    public void serve(MuttonBiryani biryani) {
       System.out.println("Mutton Biryani already served");
    }
    
}
