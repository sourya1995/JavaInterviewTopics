package DesignPatterns.TemplateMethod;

public class TemplatePatternDemo {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class c1 = Class.forName(args[0]);
        Game game = (Game) c1.newInstance();
        game.play();
    }
}
