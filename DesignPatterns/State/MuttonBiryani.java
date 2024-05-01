package DesignPatterns.State;

public class MuttonBiryani {
    private BiryaniState currentState;

    public MuttonBiryani() {
        currentState = new RawState();
    }

    public void setState(BiryaniState state){
        this.currentState = state;
    }

    public void cook() {
        currentState.cook(this);
    }

    public void serve() {
        currentState.serve(this);
    }
}
