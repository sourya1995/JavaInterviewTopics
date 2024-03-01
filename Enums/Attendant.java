package Enums;

/**
 *
 * @author sourya
 *         here is an example of Singleton design pattern using enums
 *         it is thread safe, creates a single instance,and provides serialization
 */

public enum Attendant {
    INSTANCE;

    private Attendant() {

    }

    public void sayHello() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        Attendant.INSTANCE.sayHello();
    }
}
