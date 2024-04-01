package Concurrency.ForkJoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SummingTask extends RecursiveTask<Integer> {
    private static final int MAX_BATCH_SIZE = 10;
    private final List<Integer> numbers;
    private final int minInclusive, maxExclusive;

    
    public SummingTask(List<Integer> numbers) {
        this(numbers, 0, numbers.size());
    }


    public SummingTask(List<Integer> numbers, int minInclusive, int maxExclusive) {
        this.numbers = numbers;
        this.minInclusive = minInclusive;
        this.maxExclusive = maxExclusive;
    }

    @Override
    public Integer compute() {
        if(maxExclusive - minInclusive > MAX_BATCH_SIZE) {
            int mid = (minInclusive + maxExclusive) / 2;
            SummingTask leftTask = new SummingTask(numbers, minInclusive, mid);
            SummingTask rightTask = new SummingTask(numbers, mid, maxExclusive);
            leftTask.fork();
            int rightResult = rightTask.compute();
            int leftResult = leftTask.join();

            return leftResult + rightResult;
        } else {
            int sum = 0;
            for(int i = minInclusive; i < maxExclusive; i++) {
                sum += numbers.get(i);
            }
            return sum;
        }

    }

    ForkJoinPool pool = new ForkJoinPool();
    ForkJoinTask<Integer> task = pool.submit(new SummingTask(numbers));
    int result = task.join();

    
    
}

   

