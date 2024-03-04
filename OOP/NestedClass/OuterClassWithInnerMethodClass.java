package OOP.NestedClass;

public class OuterClassWithInnerMethodClass {
    private void outerMethod() {
        final int outerInt = 1;
        class MethodLocalInnerClass {
            private void print() {
                System.out.println("outerInt = " + outerInt);
            }
        }
        MethodLocalInnerClass inner = new MethodLocalInnerClass();
        inner.print();
    }

    public static void main(String[] args) {
        OuterClassWithInnerMethodClass outer = new OuterClassWithInnerMethodClass();
        outer.outerMethod();
    }
}
