package Singletons;

public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return INSTANCE;
    }
} //we cannot have any static fields/methods inside here - this is not thread safe
