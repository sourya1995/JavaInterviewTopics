package JavaCodingProblems.FunctionalStyleProgramming.DecoratorPattern;

public class Nuts extends CakeDecorator{

    public Nuts(Cake cake) {
        super(cake);
    }

    @Override
    public String decorate() {
        return super.decorate() + decorateWithNuts();
    }

    private String decorateWithNuts() {
        return " with nuts";
    }
    
    
}
