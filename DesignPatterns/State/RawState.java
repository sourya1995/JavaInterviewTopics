package DesignPatterns.State;

public class RawState implements BiryaniState {
    @Override
    public void cook(MuttonBiryani biryani){
        System.out.println("cooking");
        biryani.setState(new MarinatedState());
    }

    @Override
    public void serve(MuttonBiryani biryani){
        System.out.println("cannot serve raw food");
    }
    
}
