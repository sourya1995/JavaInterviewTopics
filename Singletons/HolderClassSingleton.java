package Singletons;

public class HolderClassSingleton {
  
}

public class Singleton{
    private static class InstanceHolder {
        static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private Singleton() {
        // initialization logic here
    }
}
