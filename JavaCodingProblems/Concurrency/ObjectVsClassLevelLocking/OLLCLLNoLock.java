package JavaCodingProblems.Concurrency.ObjectVsClassLevelLocking;

public class OLLCLLNoLock {

        public synchronized  void nonStaticMethod() {
            System.out.println("NonStaticMethod:" + Thread.currentThread().getName());
            while(true){}
        }
    
        public synchronized static void staticMethod() {
            System.out.println("StaticMethod:" + Thread.currentThread().getName());
            while(true) {}
        }

        public void notSynchronizedMethod() {
            System.out.println("not synchronized method:" + Thread.currentThread().getName);
        }
    
}
 /*two threads can concurrently execute the methods here */