package JavaCodingProblems.FunctionalStyleProgramming.TemplateMethodPattern;

public class GreekPizza extends PizzaMaker {

    @Override
    public void addToppingIngredients(Pizza pizza) {
       System.out.println("Add sauce and cheese");
    }
    
}
