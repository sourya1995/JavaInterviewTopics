package DesignPatterns.Command;

public class AttackCommand implements Command {

    private BayernMunichTeam team;

    public AttackCommand(BayernMunichTeam team) {
        this.team = team;
    }

    @Override
    public void execute() {
       team.attack();
    }
    
}

//Command
