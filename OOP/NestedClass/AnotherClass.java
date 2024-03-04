package OOP.NestedClass;

import OOP.NestedClass.OuterClassPrivate.InnerClass;

public class AnotherClass {
    public static void main(String[] args) {
        OuterClassPrivate2 outerClassPrivate2 = new OuterClassPrivate2();
        InnerClass innerClass = outerClassPrivate2.makeInnerClass();
        OuterClassPrivate2.InnerClass ix = outerClassPrivate2.makeOuterClass();
        Object x = outerClassPrivate2.makeInnerClass();
        System.out.println(x);
    }
}
