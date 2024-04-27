package DesignPatterns.Builder.ManchesterUnited;

public class Main {

    public static void main(String[] args) {
        ManchesterUnitedBuilder builder = new ManchesterUnitedBuilderImpl();
        ManchesterUnitedDirector director = new ManchesterUnitedDirector();
        ManchesterUnited manchesterUnited = director.buildTeam(builder);
        System.out.println(manchesterUnited.toString());
    }

}
