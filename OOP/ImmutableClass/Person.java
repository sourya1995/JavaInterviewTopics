package OOP.ImmutableClass;

public class Person {
    private final String name;
    // private final String ssn;

    public Person(String name) {
        this.name = name;
        // this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    /*
     * public String getSsn() {
     * return ssn;
     * }
     */

} // otherwise, use a private constructor and a public static factory method

/* setters should do nothing, or throw exceptions */
