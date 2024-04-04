package Concurrency.ThreadLocalConcept;

public class SharedObject implements Runnable {
    private static final int ITERATIONS = 10;
    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            // TODO Auto-generated method stub
            return 0;
        }
    };

    @Override
    public void run() {
       for (int i = 0; i < ITERATIONS; i++) {
            synchronized (threadLocal) { //ONLY ONE THREAD CAN ACCES THIS PART AT A TIME
                int value = threadLocal.get();
                System.out.println(Thread.currentThread().getName() + ": " + value);
                threadLocal.set(value + 1);
                try{
                    threadLocal.notifyAll();
                    if(i < ITERATIONS - 1)
                        threadLocal.wait(); //WAIT UNTIL ANOTHER THREAD CALLS NOTIFYALL
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        
       }
    }
    
}
