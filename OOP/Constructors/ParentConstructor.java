package OOP.Constructors;

public class ParentConstructor {
    class Parent {
        private String name;
        private int age;

        public Parent() {
        }

        public Parent(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }

    class Child extends Parent {
        public Child() {
            super("John", 42); // this works
        }

    }
}
