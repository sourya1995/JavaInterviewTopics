package DesignPatterns.Builder.ManchesterUnited;

public class ManchesterUnitedBuilderImpl implements ManchesterUnitedBuilder {

    private String manager;
    private String captain;
    private int squadSize;
    private String stadium;


    @Override
    public ManchesterUnitedBuilder setManager(String manager) {
       this.manager = manager;
        return this;
    }

    @Override
    public ManchesterUnitedBuilder setCaptain(String captain) {
       this.captain = captain;
        return this;
    }

    @Override
    public ManchesterUnitedBuilder setSquadSize(int squadSize) {
       this.squadSize = squadSize;
        return this;
    }

    @Override
    public ManchesterUnitedBuilder setStadium(String stadium) {
       this.stadium = stadium;
        return this;
    }

    @Override
    public ManchesterUnited build() {
       return new ManchesterUnited(captain, manager, squadSize, stadium);
    }
    
}
