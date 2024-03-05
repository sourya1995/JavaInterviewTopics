package OOP.Inheritance;

public class StaticInheritance {
    public static int num = 5;

    public static void sayHello() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        StaticInheritance.sayHello();
        System.out.println(StaticInheritance.num);

        SubClass.sayHello();
        SubClass.sayHello(true);
        StaticOverride.sayHello();
        System.out.println(StaticOverride.num);
    }
}
