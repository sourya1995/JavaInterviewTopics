package DesignPatterns.Flyweight.BayerLeverkusen;

public class ConcretePlayer implements Player {

    private String name;
    private String nationality;
    private String preferredFoot;

    public ConcretePlayer(String name, String nationality, String preferredFoot) {
        this.name = name;
        this.nationality = nationality;
        this.preferredFoot = preferredFoot;
    }

    @Override
    public void display() {
        System.out.println("Name: " + name + ", Nationality: " + nationality + ", Preferred Foot: " + preferredFoot);
    }
}
