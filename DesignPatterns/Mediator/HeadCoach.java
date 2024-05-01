package DesignPatterns.Mediator;

import java.util.ArrayList;
import java.util.List;

import DesignPatterns.Flyweight.BayerLeverkusen.Player;

public class HeadCoach implements CoachMediator{

    private List<Player> players;

    public HeadCoach(){
        players = new ArrayList<>();
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    @Override
    public void sendMessage(Player sender, String message) {
       System.out.println("Message from:" + sender.getName() + ":" + message);
       for(Player player : players){
            if(!player.equals(sender)){
                player.receiveMessage(message);
            }
        }
    }

    
    
}
