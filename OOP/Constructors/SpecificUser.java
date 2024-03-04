package OOP.Constructors;

public class SpecificUser extends User {
    private String specificUserID;

    public SpecificUser(String specificUserID, long userID, String name) {
        super(userID, name); //args of the original class
        this.specificUserID = specificUserID;
    }

    public static void main(String[] args) {
        User user = new User(879745, "John");
        SpecificUser specificUser = new SpecificUser("1AAAA", 877777, "Jim");
        User anotherSpecificUser = new SpecificUser("2BBBB", 877777, "Jim");

        System.out.println(user.getClass());
        System.out.println(specificUser.getClass());
        System.out.println(anotherSpecificUser.getClass());
    }

}
