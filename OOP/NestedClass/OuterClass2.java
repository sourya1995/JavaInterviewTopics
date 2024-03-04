package OOP.NestedClass;

public class OuterClass2 {
    private int aField;

    public void aMethod() {
    }

    private class NestedClass {
        private int innerField;

        private NestedClass() {
            innerField = aField; // can access field from static context
            aMethod(); // can access method from static context
        }

        private NestedClass(OuterClass2 instance) {
            innerField = instance.aField; // legal
            instance.aMethod(); // legal
        }
    }

    public static void aStaticMethod() {
        NestedClass nested = new NestedClass(); //illegal
    }

    public void aNonStaticMethod() {
        NestedClass nested = new NestedClass(); //legal
    }
}

