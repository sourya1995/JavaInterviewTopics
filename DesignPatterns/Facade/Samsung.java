package DesignPatterns.Facade;

public class Samsung implements MobileShop {

    @Override
    public void modelNo() {
       System.out.println("Samsung Galaxy S20");
    }

    @Override
    public void prices() {
        System.out.println("Rs. 10,000");
    }
    
}
