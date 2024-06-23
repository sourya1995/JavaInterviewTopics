package JavaCodingProblems.Concurrency.ForkJoinPool;

import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.ArrayList;

public class SumRecursiveTask extends RecursiveTask<Integer> {
    private static final Logger LOGGER = Logger.getLogger(SumRecursiveTask.class.getName());
    private static final int THRESHOLD = 10;
    private final List<Integer> workList;

    public SumRecursiveTask(List<Integer> workList) {
        this.workList = workList;
    }

    @Override
    protected Integer compute() {
        if (workList.size() < THRESHOLD) {
            return partialSum(workList);
        }

        return ForkJoinTask.invokeAll(createSubtasks())
                .stream()
                .mapToInt(ForkJoinTask::join)
                .sum();

    }

    private List<SumRecursiveTask> createSubtasks() {
        List<SumRecursiveTask> subtasks = new ArrayList<>();
        int size = workList.size();

        List<Integer> workListLeft = workList.subList(0, (size + 1) / 2);
        List<Integer> workListRight = workList.subList((size + 1) / 2, size);
        subtasks.add(new SumRecursiveTask(workListLeft));
        subtasks.add(new SumRecursiveTask(workListRight));

        return subtasks;
    }

    private Integer partialSum(List<Integer> workList) {
        int sum = workList.stream().mapToInt(e -> e).sum();
        LOGGER.info(() -> "Partial sum: " + workList + " = "
                + sum + "\tThread: " + Thread.currentThread().getName());
        return sum;
    }

}
