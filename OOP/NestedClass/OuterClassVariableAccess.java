package OOP.NestedClass;

public class OuterClassVariableAccess {
    private int counter;

    public class InnerClass {
        private int counter;

        public void method() {
            System.out.println("I can access my counter: " + counter);
            System.out.println("I can access my outer counter: " + OuterClassVariableAccess.this.counter);// works
            counter = OuterClassVariableAccess.this.counter;
        }
    }
}
