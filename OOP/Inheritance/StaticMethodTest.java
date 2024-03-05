package OOP.Inheritance;

public class StaticMethodTest {
    static class Parent {
        public static void staticMethod() {
            System.out.println("Inside Parent.staticMethod");
        }
    }

    static class Child extends Parent {
        public static void staticMethod() {
            System.out.println("Inside Child.staticMethod");
        }
    }

    public static void main(String[] args) {
        Parent parent = new Child();
        parent.staticMethod();
        ((Child) parent).staticMethod();
    }
}
