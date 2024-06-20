package JavaCodingProblems.Concurrency.ThreadLifeCycle;

public class NewThread {
    public void newThread() {
        Thread t = new Thread(() -> {});
        System.out.println("Thread:" + t.getState());
    }

    public static void main(String[] args) {
        NewThread nt = new NewThread();
        nt.newThread();
    }
}
