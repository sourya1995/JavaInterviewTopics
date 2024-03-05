package OOP.Inheritance;

public class VariableShadowing {
    static class Car {
        public int gearRatio = 8;

        public String accelerate() {
            return "accelerate: Car";
        }
    }

    static class SportsCar extends Car {
        public int gearRatio = 9;

        public String accelerate() {
            return "accelerate: SportsCar";
        }

        public void test() {

        }
    }

    public static void main(String[] args) {
        Car car = new SportsCar();
        System.out.println(car.gearRatio + " " + car.accelerate());
    }
}
