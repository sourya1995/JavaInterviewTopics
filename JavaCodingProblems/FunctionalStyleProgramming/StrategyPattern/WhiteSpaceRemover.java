package JavaCodingProblems.FunctionalStyleProgramming.StrategyPattern;

public class WhiteSpaceRemover implements RemoveStrategy{

    @Override
    public String execute(String s) {
        return s.replaceAll("\\s", "");
    }
    
}
