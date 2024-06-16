package JavaCodingProblems.FunctionalStyleProgramming.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class FireStation implements FireStationRegister {

    private final List<FireObserver> fireObservers = new ArrayList<>();

    @Override
    public void registerFireStation(FireObserver fireObserver) {
        if (fireObserver != null) {
            fireObservers.add(fireObserver);
        }
    }

    public void unregisterFireStation(FireObserver fireObserver) {
        fireObservers.remove(fireObserver);
    }

    @Override
    public void notifyFireStations(String address) {
        if (address != null) {
            for (FireObserver fireObserver : fireObservers) {
                fireObserver.fire(address);
            }
        }
    }

}
