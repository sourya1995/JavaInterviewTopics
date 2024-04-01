package Static;

public class TestStatic {
    static int staticVariable;

    static {
        staticVariable = 11; //runs when class first loads
    }

    int nonStaticVariable = 5;

    static void doSomething() { 
        staticVariable = 10; //can access static variable from static methods
    }

    void add() {
        nonStaticVariable += staticVariable; //can access both non static variables and static variables from non static methods
    }

    static class StaticInnerClass {
        int number;

        public StaticInnerClass(int _number) {
            number = _number;
        }

        void doSomething() {
            number += staticVariable; //can access number and staticVariable, but non nonStaticVariable
        }

        int getNumber() {
            return number;
        }
        
    }

    public static void main(String[] args) {
        TestStatic object1 = new TestStatic();
        System.out.println(object1.staticVariable); //11
        System.out.println(TestStatic.staticVariable); //11
    }
}
