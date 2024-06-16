package JavaCodingProblems.FunctionalStyleProgramming.TemplateMethodPattern;

public class NeapolitanPizza extends PizzaMaker {

    @Override
    public void addToppingIngredients(Pizza pizza) {
       System.out.println("Adding: mozzarella, tomatoes, basil, oregano, olive oil");
    }
    
}
