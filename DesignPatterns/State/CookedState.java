package DesignPatterns.State;

public class CookedState implements BiryaniState {

    @Override
    public void cook(MuttonBiryani biryani) {
        System.out.println("Biryani is cooked");
    }

    @Override
    public void serve(MuttonBiryani biryani) {
        System.out.println("Serving the Biryani");
        biryani.setState(new ServedState());
    }

}