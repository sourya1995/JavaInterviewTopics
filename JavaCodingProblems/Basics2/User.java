
import java.util.Date;

public final class User {

    private final String nickname;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Date created;

    private User(UserBuilder builder){
        this.nickname = builder.nickname;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.created = builder.created;
    }

    public static UserBuilder getBuilder(String nickname, String password){
        return new User.UserBuilder(nickname, password);
    }

    public static final class UserBuilder {

        private final String nickname;
        private final String password;
        private String firstName;
        private String lastName;
        private String email;
        private final Date created;

        public UserBuilder(String nickname, String password){
            this.nickname = nickname;
            this.password = password;
            this.created = new Date();
        }

        public UserBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public UserBuilder email(String email){
            this.email = email;
            return this;
        }

        public User build(){
            return new User(this);
        }


    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreated() {
        return new Date(created.getTime());
    }

  
    

    public static void main(String[] args) {
        User user2 = getBuilder("nickname", "password")
        .email("email")
        .firstName("firstName")
        .lastName("lastName")
        .build();

    }

}
