package DesignPatterns.Flyweight.BayerLeverkusen;

public class Main {
    public static void main(String[] args) {
        PlayerFactory factory = new PlayerFactory();

        // Creating player instances
        Player player1 = factory.getPlayer("Kai Havertz", "German", "Right");
        Player player2 = factory.getPlayer("Kevin Volland", "German", "Left");
        Player player3 = factory.getPlayer("Jonathan Tah", "German", "Right");

        // Even though we create multiple instances, for players with the same nationality and preferred foot,
        // the factory returns the same instance, saving memory.
        System.out.println(player1 == player2); // false
        System.out.println(player1 == player3); // true

        // Display player information
        player1.display();
        player2.display();
        player3.display();
    }
}
