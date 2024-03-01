package OOP.Constructors;

public class Foo {
    private int field1, field2;
    private String field3;

    public Foo(int field1, int field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + field1;
        result = prime * result + field2;
        result = prime * result + ((field3 == null) ? 0 : field3.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Foo other = (Foo) obj;
        if (field1 != other.field1)
            return false;
        if (field2 != other.field2)
            return false;
        if (field3 == null) {
            if (other.field3 != null)
                return false;
        } else if (!field3.equals(other.field3))
            return false;
        return true;
    }

    
}
