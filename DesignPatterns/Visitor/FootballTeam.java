package DesignPatterns.Visitor;

public interface FootballTeam {
    void accept(FootballStatisticVisitor visitor);
}
