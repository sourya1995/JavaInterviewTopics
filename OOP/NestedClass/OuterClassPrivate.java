package OOP.NestedClass;

public class OuterClassPrivate {
    public class InnerClass {
        private int x;

        private void anInnerMethod() {
        }
    }

    public InnerClass aMethod() {
        InnerClass innerClass = new InnerClass();
        innerClass.x = 10;
        innerClass.anInnerMethod();
        return innerClass;
    }
}

/* 
 * all of this stuff is legal
 */