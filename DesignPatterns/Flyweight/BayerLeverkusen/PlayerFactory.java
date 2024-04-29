package DesignPatterns.Flyweight.BayerLeverkusen;

import java.util.HashMap;
import java.util.Map;

public class PlayerFactory {

    private Map<String, Player> players = new HashMap<>();

    public Player getPlayer(String name, String nationality, String preferredFoot) {
        String key = nationality + "-" + preferredFoot;
        if (!players.containsKey(key)) {
            players.put(key, new ConcretePlayer(name, nationality, preferredFoot));
        }
        return players.get(key);
    }
}
