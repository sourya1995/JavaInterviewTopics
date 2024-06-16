package JavaCodingProblems.FunctionalStyleProgramming.StrategyPattern;

public class NumberRemover implements RemoveStrategy {

    @Override
    public String execute(String s) {
        return s.replaceAll("\\d", " ");
    }
    
}
