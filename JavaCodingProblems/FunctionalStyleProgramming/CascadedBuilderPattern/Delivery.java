package JavaCodingProblems.FunctionalStyleProgramming.CascadedBuilderPattern;

import java.util.function.Consumer;

public final class Delivery {

    public Delivery firstName(String firstName) {
        System.out.println(firstName);
        return this;
    }

    public Delivery lastName(String lastName) {
        System.out.println(lastName);
        return this;
    }

    public Delivery address(String address) {
        System.out.println(address);
        return this;
    }

    public static void deliver(Consumer<Delivery> parcel) {
        Delivery delivery = new Delivery();
        parcel.accept(delivery);
    }

    public static void main(String[] args) {
        Delivery.deliver(d -> d.firstName("John").lastName("Doe").address("123 Main St."));
    }

}
