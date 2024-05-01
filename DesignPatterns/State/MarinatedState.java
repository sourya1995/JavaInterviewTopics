package DesignPatterns.State;

public class MarinatedState implements BiryaniState {
    @Override
    public void cook(MuttonBiryani biryani) {
        System.out.println("Marinated state");
        biryani.setState(new CookedState());
    }

    @Override
    public void serve(MuttonBiryani biryani) {
        System.out.println("cannot serve marinated Biryani");
    }
}
