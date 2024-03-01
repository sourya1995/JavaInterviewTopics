package OOP.Constructors;

import java.util.Date;

public class FooKin implements Cloneable {
    int w;
    String x;
    float[] y;
    Date z;

    public FooKin clone() throws CloneNotSupportedException {
        FooKin result = new FooKin();
        // copy primitives by value
        result.w = this.w;
        // immutable objects like String can be copied by reference
        result.x = this.x;
        // The fields y and z refer to a mutable objects; clone them recursively.
        if (this.y != null) {
            result.y = this.y.clone();
        }
        if (this.z != null) {
            result.z = (Date) this.z.clone();
        }
        // Done, return the new object
        return result;
    }
}
