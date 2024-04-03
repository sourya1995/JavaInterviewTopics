package Concurrency.Interruption;

import java.util.concurrent.BlockingQueue;

public class MustFinishHandler implements Runnable{

    static class Task {}

    private final BlockingQueue<Task> queue;
    
    public MustFinishHandler(BlockingQueue<Task> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        boolean shouldInterrupt = false;
        while(true){
            try {
                Task task = queue.take();
                if(task.isEndOfTasks()){
                    if(shouldInterrupt){
                        Thread.currentThread().interrupt();
                    }
                    return;
                }
                handle(task);
            } catch (InterruptedException e) {
                shouldInterrupt |= true;
            }
            }
        }

        private void Handle(Task task) {
            // Handle task
        }
    }

    
    

