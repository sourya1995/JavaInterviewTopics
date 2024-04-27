package DesignPatterns.Builder.ManchesterUnited;

public interface ManchesterUnitedBuilder {
    ManchesterUnitedBuilder setManager(String manager);
    ManchesterUnitedBuilder setCaptain(String captain);
    ManchesterUnitedBuilder setSquadSize(int squadSize);
    ManchesterUnitedBuilder setStadium(String stadium);
    ManchesterUnited build();
}
