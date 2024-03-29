package Polymorphism;

import java.util.ArrayList;
import java.util.List;

public class PolymorphismDemo {

    public static void main(String[] args) {
        List<FlyingMachine> machines = new ArrayList<FlyingMachine>();
        machines.add(new FlyingMachine());
        machines.add(new Jet());
        machines.add(new Helicopter());
        machines.add(new Jet());

        new MakeThingsFly().letTheMachinesFly(machines);

    }
}

class MakeThingsFly {

    public void letTheMachinesFly(List<FlyingMachine> flyingMachines) {
        for (FlyingMachine machine : flyingMachines) {
            machine.fly();
        }
    }
}

class FlyingMachine {

    public void fly() {
        System.out.println("no implementation");
    }
}

class Jet extends FlyingMachine {

    @Override
    public void fly() {
        System.out.println("Start, taxi, fly");
    }

    public void bombardment() {
        System.out.println("Fire missile");
    }
}

class Helicopter extends FlyingMachine {
    @Override
    public void fly() {
        System.out.println("Start vertically, hover, fly");
    }
}
