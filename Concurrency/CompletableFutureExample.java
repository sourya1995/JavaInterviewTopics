package Concurrency;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static CompletableFuture<Integer> calculateShippingPrice(int weightInGrams){
        return CompletableFuture.supplyAsync(() -> {
            int shippingCosts = weightInGrams / 100;
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                
            }
            return shippingCosts;
        });
    }

    public static void main(String[] args) {
        int price = 15;
        int weightInGrams = 900;

        calculateShippingPrice(weightInGrams).thenAccept(shippingPrice -> {
            System.out.println("Your total price is" + (price + shippingPrice));
        });

        System.out.println("Please hold on, calculating shipping price");
    }
}
