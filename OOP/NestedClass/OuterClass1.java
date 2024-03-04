package OOP.NestedClass;

public class OuterClass1 {
    private int aField;

    public void aMethod() {
    }

    private static class StaticNestedClass {
        private int innerField;

        private StaticNestedClass() {
            innerField = aField; // can't access field from static context
            aMethod(); // can't access method from static context
        }

        private StaticNestedClass(OuterClass1 instance) {
            innerField = instance.aField; //legal
            instance.aMethod(); //legal
        }
    }

    public static void aStaticMethod() {
        StaticNestedClass nested = new StaticNestedClass(); //legal
    }

}


