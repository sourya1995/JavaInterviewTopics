package JavaCodingProblems.Concurrency.ObjectVsClassLevelLocking;

public class CLL2 {
    public void method(){
        synchronized(CLL2.class){
            System.out.println("example");
        }
    }
}
