package JavaCodingProblems.FunctionalStyleProgramming.DecoratorPattern;

public class BaseCake implements Cake {

    @Override
    public String decorate() {
       System.out.println("Base cake");
    }
    
}
