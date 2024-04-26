package DesignPatterns.Facade;

public class Nothing implements MobileShop {

    @Override
    public void modelNo() {
       System.out.println("Nothing phone");
    }

    @Override
    public void prices() {
       System.out.println("70,000");
    }
    
}
