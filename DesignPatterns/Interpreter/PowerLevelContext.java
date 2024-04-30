package DesignPatterns.Interpreter;

import java.util.HashMap;
import java.util.Map;

public class PowerLevelContext {
    private Map<String, Integer> powerLevels;

    public PowerLevelContext() {
        powerLevels = new HashMap<>();
        powerLevels.put("Goku", 9000);
        powerLevels.put("Vegeta", 8000);
    }

    public int getPowerLevel(String character){ 
        return powerLevels.getOrDefault(character, 0);

    }

    public void setPowerLevel(String character, int powerLevel){
        powerLevels.put(character, powerLevel);
    }
    

    
}
