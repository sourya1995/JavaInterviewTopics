package JavaCodingProblems.FunctionalStyleProgramming.StrategyPattern;

public class Remover {
    private Remover() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String remove(String s, RemoveStrategy strategy){
        return strategy.execute(s);
    }
}
