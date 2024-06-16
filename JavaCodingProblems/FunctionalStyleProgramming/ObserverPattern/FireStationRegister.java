package JavaCodingProblems.FunctionalStyleProgramming.ObserverPattern;

public interface FireStationRegister {
    void registerFireStation(FireObserver fireObserver);
    void notifyFireStations(String address);
}
