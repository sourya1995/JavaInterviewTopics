package JavaCodingProblems.FunctionalStyleProgramming.StrategyPattern;

public class Main {
    private String text;
    String noNr = Remover.remove(text, s -> s.replaceAll("\\d", ""));
    String noStr = Remover.remove(text, s -> s.replaceAll("\\s", ""));
}
