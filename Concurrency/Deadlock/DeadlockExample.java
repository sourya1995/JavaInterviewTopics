package Concurrency.Deadlock;

public class DeadlockExample {

    public static void main(String[] args) {
        final Deadlock dl = new Deadlock();
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                dl.methodA();
            }

        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    dl.method2();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        t1.setName("first");
        t2.setName("second");
        t1.start();
        t2.start();

    }
}
