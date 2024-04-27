package DesignPatterns.Builder.ManchesterUnited;

public class ManchesterUnitedDirector {

    public ManchesterUnited buildTeam(ManchesterUnitedBuilder builder) {
        return builder.setManager("Sir Alex Ferguson")
                .setCaptain("Ryan Giggs")
                .setSquadSize(25)
                .setStadium("Old Trafford")
                .build();
    }
}
