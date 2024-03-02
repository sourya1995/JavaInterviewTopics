package Annotations;

public class OverrideExample {
    abstract class Animal {
        public abstract void makeNoise();
    }

    class Dog extends Animal {
        @Override
        public void makeNoise() {
            System.out.println("Bark");
        }
    }

}
