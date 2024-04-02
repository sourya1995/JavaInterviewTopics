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
                Thread t = new Thread(new DoSomethingInAThread(latch));
                t.start();
            }
            latch.await();
            System.out.println("in main thread after completion of" + numberOfThreads + "threads");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
