package OOP.ImmutableClass;

public final class PersonImmutable {
    private final String name;
    private final int age;

    public PersonImmutable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


}
