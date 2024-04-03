package Concurrency.Interruption;

import java.util.concurrent.BlockingQueue;

public class TaskHandler implements Runnable {

    static class Task{} 
    private final BlockingQueue<Task> queue;

    

    public TaskHandler(BlockingQueue<Task> queue) {
        this.queue = queue;
    }
    private void handle(Task){
        //handling
    }



    @Override
    public void run() {
       while(!Thread.currentThread().isInterrupted()){ //check for interrupt - if yes, exit loop
           try {
                Task task = queue.take();
                task.execute();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
       }
    }

   
    
}


/* Example of code that stops handling tasks upon interruption */