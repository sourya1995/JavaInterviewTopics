package JavaCodingProblems.FunctionalStyleProgramming.LambdaBasedDecorator;

public class Cake {

    private final String decorations;

    public Cake(String decorations) {
        this.decorations = decorations;
    }

    public Cake decorate(String decorations) {
        return new Cake(getDecorations() + decorations);
    }

    public String getDecorations() {
        return decorations;
    }

}
