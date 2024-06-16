package JavaCodingProblems.FunctionalStyleProgramming.TemplateMethodPattern;

public abstract class PizzaMaker {
    public void make(Pizza pizza){
        makeDough(pizza);
        addToppingIngredients(pizza);
        bake(pizza);
    }

    

    private void makeDough(Pizza pizza) {
        System.out.println("Making Dough");
    }

    public abstract void addToppingIngredients(Pizza pizza);
        //to be implemented by subclasses
    

    private void bake(Pizza pizza) {
        System.out.println("Baking");

    }
        
}
