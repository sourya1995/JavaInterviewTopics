package Collections.Lists;

public class User implements Comparable<User> {
    public final Long id;
    public final String username;

    public User(Long id, String username)  {
        this.id = id;
        this.username = username;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + "]";
    }

    @Override
    public int compareTo(User arg0) { //for natural ordering
        // TODO Auto-generated method stub
        return id.compareTo(arg0.id);
    }

}
