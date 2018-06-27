package assignment4;
public class Users implements User
{
    String handle, name, email, password, desc;
    int is_person, is_hidden;

    // Constructor
    protected Users(String handle, String name, String email, String password, String desc, int is_person, int is_hidden)
    {
        this.handle = handle;
        this.name = name;
        this.email = email;
        this.password = password;
        this.desc = desc;
        this.is_person = is_person;
        this.is_hidden = is_hidden;
    }

    //static factory method
    static User makeUser(String handle, String name, String email, String password, String desc, int is_person, int is_hidden)
    {
        return new Users(handle, name, email, password, desc, is_person, is_hidden);
    }

    // getName : -> String
    // returns : the name of this user
    // example : makeUser("@ann", "Ann","ann@example.com", "Password", "", 1, 0). getName() -> "Ann"
    @Override
    public String getName() {
        return this.name;
    }

    // getHandle : -> String
    // returns : the handle of this user.
    // example : makeUser("@ann", "Ann","ann@example.com", "Password", "", 1, 0). getHandle() -> "@ann"
    @Override
    public String getHandle() {
        return this.handle;
    }

    // getEmail : -> String
    // returns : the email-id of this user
    // example : makeUser("@ann", "Ann","ann@example.com", "Password", "", 1, 0). getEmail() -> "ann@example.com"
    @Override
    public String getEmail() {
        return this.email;
    }

    // getPassword
    // returns : the password of this user
    // example : makeUser("@ann", "Ann","ann@example.com", "Password", "", 1, 0). getPassword() -> "Password"
    @Override
    public String getPassword() {
        return this.password;
    }

    // getDesc : -> String
    // returns : the discription of the user
    // example : makeUser("@ann", "Ann","ann@example.com", "Password", "", 1, 0). getDesc() -> ""
    @Override
    public String getDesc() {
        return this.desc;
    }

    // isUser : -> String
    // returns : 1 if the user is a person, 0 if the user represents an organization
    // example : makeUser("@ann", "Ann","ann@example.com", "Password", "", 1, 0). getisUser() -> 1
    @Override
    public int isUser() {
        return this.is_person;
    }

    // isHidden : -> String
    // returns : 1 is the user profile is hidden, 0 if not.
    // example : makeUser("@ann", "Ann","ann@example.com", "Password", "", 1, 0). getisHidden() -> 0
    @Override
    public int isHidden() {
        return this.is_hidden;
    }
}
