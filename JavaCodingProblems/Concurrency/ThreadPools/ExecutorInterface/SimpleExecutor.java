package JavaCodingProblems.Concurrency.ThreadPools.ExecutorInterface;

import java.util.concurrent.Executor;

public class SimpleExecutor implements Executor {

    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }

    public static void main(String[] args) {
        SimpleExecutor executor = new SimpleExecutor();
        executor.execute(() -> System.out.println("Hello, World!"));
    }

}
