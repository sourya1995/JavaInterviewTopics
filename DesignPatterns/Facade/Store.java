package DesignPatterns.Facade;

public class Store {
    private MobileShop iphone;
    private MobileShop samsung;
    private MobileShop nothing;

    public Store() {
        iphone = new IPhone();
        samsung = new Samsung();
        nothing = new Nothing();
    }

   public void iPhoneSale() {
        iphone.modelNo();
        iphone.prices();
   }

   public void samsungSale() {
        samsung.modelNo();
        samsung.prices();
   }

   public void nothingSale() {
        nothing.modelNo();
        nothing.prices();
   }

   

}
