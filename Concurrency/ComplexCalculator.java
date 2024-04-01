package Concurrency;

import java.util.concurrent.Callable;

public class ComplexCalculator implements Callable<String> {

    @Override
    public String call() throws Exception {
       Thread.sleep(1000);
       System.out.println("Result of a lengthy 10 second calculation");
       return "Complex Result";
    }

}
