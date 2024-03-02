package OOP.ImmutableClass;

public class MutablePerson extends Person {
    private String newName;

    public MutablePerson(String name) {
        super(name);
    }

    public String getNewName() {
        return newName;
    }

    @Override
    public String getName() {
        return newName;
    }

    public void setName(String name) {
        newName = name;
    }

}
