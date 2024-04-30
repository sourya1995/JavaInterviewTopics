package DesignPatterns.Command;

public class DefendCommand implements Command{

    private BayernMunichTeam team;

    public DefendCommand(BayernMunichTeam team) {
        this.team = team;
    }

    @Override
    public void execute() {
       team.defend();
    }
    
}
