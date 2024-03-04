package OOP.NestedClass;

public class OuterClass {
    public class InnerClass {
        public int x = 5;
    }

    public InnerClass createInner() {
        return new InnerClass();

    }

}

