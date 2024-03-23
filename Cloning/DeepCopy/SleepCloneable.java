package Cloning.DeepCopy;

public class SleepCloneable implements Cloneable {
    private String name;
    private int age;

    public SleepCloneable( String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        SleepCloneable s1 = new SleepCloneable("Dolly", 20);
        try {
            SleepCloneable dolly = (SleepCloneable) s1.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // cast to SleepCloneable because 
    }



}
