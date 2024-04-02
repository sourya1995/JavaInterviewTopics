package Concurrency.CountDownLatchConcept;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        try{
            int numberOfThreads = 5;
            if(args.length < 1){
                System.out.println("usage: java countdownLatch demo");
                return;
            }
            try{
                numberOfThreads = Integer.parseInt(args[0]);

            }catch(NumberFormatException ne){
                ne.printStackTrace();
            }
            CountDownLatch latch = new CountDownLatch(numberOfThreads);
            for(int n = 0; n < numberOfThreads; n++){
                Thread t = new Thread(new DoSomethingInAThread(latch)); //each instance of DoSomethingInAThread decrements the latch counter by 1
                t.start();
            }
            latch.await(); //block main thread until latch is released (equal to zero)
            System.out.println("in main thread after completion of" + numberOfThreads + "threads");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
