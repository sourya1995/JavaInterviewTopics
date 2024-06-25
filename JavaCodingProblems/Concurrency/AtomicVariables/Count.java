package JavaCodingProblems.Concurrency.AtomicVariables;

public class Count implements Runnable{

    public static int count = 0; 

    public static int getCount() {
        return count;
    }

    @Override
    public void run() {
        count++;
    }

    
    
}
