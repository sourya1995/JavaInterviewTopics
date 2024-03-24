package Singletons;

public class MySingleton {
    private static volatile MySingleton instance = null;

    private MySingleton() {}

    public static MySingleton getInstance() {
        MySingleton result = instance;
        if(result == null) {
            synchronized(MySingleton.class) {
                result = instance;
                if(result == null) {
                    instance = result = new MySingleton();
                }
            }
        }
        return result;
    }


}
