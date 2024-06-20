package JavaCodingProblems.Concurrency.ObjectVsClassLevelLocking;

public class OLLandCLL {
    public synchronized void nonStaticMethod() {
        System.out.println("NonStaticMethod:" + Thread.currentThread().getName());
        while(true){}
    }

    public synchronized static void staticMethod() {
        System.out.println("StaticMethod:" + Thread.currentThread().getName());
        while(true) {}
    }
}

/* Two threads can execute the two methods concurrently, because they acquire locks on different objects */