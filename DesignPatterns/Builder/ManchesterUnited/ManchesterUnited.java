package DesignPatterns.Builder.ManchesterUnited;

public class ManchesterUnited {
    private String manager;
    private String captain;
    private int squadSize;
    private String stadium;

    public ManchesterUnited(String captain, String manager, int squadSize, String stadium) {
        this.captain = captain;
        this.manager = manager;
        this.squadSize = squadSize;
        this.stadium = stadium;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ManchesterUnited{");
        sb.append("manager=").append(manager);
        sb.append(", captain=").append(captain);
        sb.append(", squadSize=").append(squadSize);
        sb.append(", stadium=").append(stadium);
        sb.append('}');
        return sb.toString();
    }




}
