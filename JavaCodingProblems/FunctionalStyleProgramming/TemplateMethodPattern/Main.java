package JavaCodingProblems.FunctionalStyleProgramming.TemplateMethodPattern;
import java.util.function.Consumer;

public class Main {

    Pizza pizza = new Pizza();
    PizzaMaker nMaker = new NeapolitanPizza();

    nMaker.make (pizza);

    Pizza sPizza = new Pizza();
    new PizzaLambda().make(sPizza, (Pizza p) -> System.out.println("tomato, onion, anchovies, herbs"));


}
