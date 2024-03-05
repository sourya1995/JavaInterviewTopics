package OOP.Inheritance;
/* 
 * Some salient points about this code
 * UNRELATED CLASSES - Man, Cat, Dog - Man has capabilities through interfaces
 * RELATED CLASSES - Cat and Dog extend Animal - so they change behaviour through extension of BASE CLASSES
 */

public class AbstractClassAndInterface {

    public static void main(String[] args) {
        Dog dog = new Dog("Jack", 16);
        Cat cat = new Cat("Joe", 20);
        System.out.println("Dog:" + dog);
        System.out.println("Cat:" + cat);
        dog.remember();
        dog.protectOwner();
        Learn dl = dog;
        dl.learn(); // calling the method on interface type
        cat.remember();
        cat.protectOwner();
        Climb cl = cat;
        cl.climb();
        Man man = new Man("Ravindra", 40);
        System.out.println("Man:" + man);
        Climb cm = man;
        cm.climb();
        Think tm = man;
        tm.think();
        Learn lm = man;
        lm.learn();
        Apply am = man;
        am.apply();
    }
}

/*
 * shared attributes - name, life expectancy
 * abstract methods - remember() and protectOwner()
 * CONSTRUCTOR IS PRESENT
 * 
 */

abstract class Animal {
    String name;
    int lifeExpectancy;

    public Animal(String name, int lifeExpectancy) {
        this.name = name;
        this.lifeExpectancy = lifeExpectancy;
    }

    public abstract void remember();

    public abstract void protectOwner();

    @Override
    public String toString() {
        return "Animal [name=" + name + ", lifeExpectancy=" + lifeExpectancy + "]";
    }

}

/*
 * implements remember() and protectOwner() from abstract class
 * Dog can learn, but cat cannot - use INTERFACE
 * Dog is not a man, but can learn
 */

class Dog extends Animal implements Learn {
    public Dog(String name, int age) {
        super(name, age);
    }

    public void remember() {
        System.out.println(this.getClass().getSimpleName() + "can remember for 5 minutes");
    }

    public void protectOwner() {
        System.out.println(this.getClass().getSimpleName() + "can protect owner");
    }

    public void learn() {
        System.out.println(this.getClass().getSimpleName() + "can learn");
    }
}

/*
 * implements remember() and protectOwner() from abstract class
 * Cat can climb, but dog cannot - use INTERFACE
 * Cat is not a man, but can climb
 */

class Cat extends Animal implements Climb {
    public Cat(String name, int age) {
        super(name, age);
    }

    public void remember() {
        System.out.println(this.getClass().getSimpleName() + "can remember for 16 hours");
    }

    public void protectOwner() {
        System.out.println(this.getClass().getSimpleName() + "cannot protect owner");
    }

    public void climb() {
        System.out.println(this.getClass().getSimpleName() + "can climb");
    }
}

interface Climb {
    void climb();
}

interface Think {
    void think();
}

interface Learn {
    void learn();
}

interface Apply {
    void apply();
}

/*
 * Man is NOT AN ANIMAL, but can think, apply, learn and climb - USE INTERFACE
 * Man is not an animal, a dog, or a cat- but it has some of the capabilities of
 * the other two- INTERFACES
 */
class Man implements Think, Learn, Apply, Climb {
    String name;
    int age;

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void climb() {
        // TODO Auto-generated method stub
        System.out.println("I can climb:" + this.getClass().getSimpleName());
    }

    @Override
    public void apply() {
        // TODO Auto-generated method stub
        System.out.println("I can apply:" + this.getClass().getSimpleName());
    }

    @Override
    public void learn() {
        // TODO Auto-generated method stub
        System.out.println("I can learn:" + this.getClass().getSimpleName());
    }

    @Override
    public void think() {
        // TODO Auto-generated method stub
        System.out.println("I can think:" + this.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        return "Man [name=" + name + ", age=" + age + "]";
    }

}
