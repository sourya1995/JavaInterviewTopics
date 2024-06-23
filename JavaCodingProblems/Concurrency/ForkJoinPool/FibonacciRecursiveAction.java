package JavaCodingProblems.Concurrency.ForkJoinPool;

import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinTask;

public class FibonacciRecursiveAction extends RecursiveAction {
    private static final Logger LOGGER = Logger.getLogger(FibonacciRecursiveAction.class.getName());
    private static final int THRESHOLD = 10;
    private long nr;

    public FibonacciRecursiveAction(long nr) {
        this.nr = nr;
    }

    @Override
    protected void compute() {
        if (n <= THRESHOLD) {
            nr = fibonacci(n);
        } else {
            nr = ForkJoinTask.invokeAll(createSubtasks(n))
                    .stream()
                    .mapToLong(x -> x.fibonacciNumber())
                    .sum();
        }
    }

    private List<FibonacciRecursiveAction> createSubtasks(long n) {
        List<FibonacciRecursiveAction> subtasks = new ArrayList<>();
        FibonacciRecursiveAction fibonacciMinusOne = new FibonacciRecursiveAction(n - 1);
        FibonacciRecursiveAction fibonacciMinusTwo = new FibonacciRecursiveAction(n - 2);

        subtasks.add(fibonacciMinusOne);
        subtasks.add(fibonacciMinusTwo);

        return subtasks;
    }

    private long fibonacci(long n) {
        LOGGER.info(() -> "Number: " + n + "Thread:" + Thread.currentThread().getName());
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public long fibonacciNumber() {
        return nr;
    }

}
