package DesignPatterns.Facade;

public class IPhone implements  MobileShop{

    @Override
    public void modelNo() {
       System.out.println("iPhone 13 Pro Max");
    }

    @Override
    public void prices() {
       System.out.println("Rs. 100,000");
    }
    
}
