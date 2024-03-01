package Enums;

public enum Season {
    WINTER,
    SPRING,
    SUMMER,
    FALL;

    public static void display(Season s) {
        System.out.println(s.name());
    }

public static void main(String[] args) {
    display(Season.WINTER);

    Season[] seasons = Season.values();
    for (Season season : seasons) {
        System.out.println(season.name());
    }
}

}
