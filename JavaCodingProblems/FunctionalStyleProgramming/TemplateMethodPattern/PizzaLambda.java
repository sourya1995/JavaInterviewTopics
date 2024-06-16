package JavaCodingProblems.FunctionalStyleProgramming.TemplateMethodPattern;

import java.util.function.Consumer;


public class PizzaLambda {
    public void make(Pizza pizza, Consumer<Pizza> addToppingIngredients){
        makeDough(pizza);
        addToppingIngredients.accept(pizza);
        bake(pizza);
    }

    private void bake(Pizza pizza) {
      System.out.println(" baked");
    }

    private void makeDough(Pizza pizza) {
       System.out.println( " made");
    }
}
