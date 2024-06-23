package JavaCodingProblems.Concurrency.ForkJoinPool;

import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinTask;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.concurrent.atomic.LongAdder;

public class SumCountedCompleter extends CountedCompleter<Long> {
    private static final Logger LOGGER = Logger.getLogger(SumCountedCompleter.class.getName());
    private static final int THRESHOLD = 10;
    private static final LongAdder sumAll = new LongAdder();

    private final List<Integer> workList;

    public SumCountedCompleter(CountedCompleter<Long> countedCompleter, List<Integer> workList) {
        super(countedCompleter);
        this.workList = workList;
    }

    @Override
    public void compute() {
        if (workList.size() <= THRESHOLD) {
            partialSum(workList);
        } else {
            int size = workList.size();
            List<Integer> workListLeft = workList.subList(0, (size + 1) / 2);
            List<Integer> workListRight = workList.subList((size + 1) / 2, size);
            addToPendingCount(2);
            SumCountedCompleter leftTask = new SumCountedCompleter(this, workListLeft);
            SumCountedCompleter rightTask = new SumCountedCompleter(this, workListRight);
            leftTask.fork();
            rightTask.fork();
        }
        tryComplete();
    }

    @Override
    public Long getRawResult() {

        return sumAll.sum();
    }

    @Override
    public void onCompletion(CountedCompleter<?> caller) {
        LOGGER.info(() -> "Thread complete" + Thread.currentThread().getName());
    }

    private Integer partialSum(List<Integer> workList) {
        int sum = workList.stream().mapToInt(e -> e).sum();

        sumAll.add(sum);
        LOGGER.info(() -> "Partial sum: " + workList + " = "
                + sum + "\tThread: " + Thread.currentThread().getName());
        return sum;
    }

}
