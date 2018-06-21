public class Users implements User
{
    String handle, name, email, password, desc;
    int is_person, is_hidden;
    
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
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getHandle() {
        return this.handle;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

    @Override
    public int isUser() {
        return this.is_person;
    }

    @Override
    public int isHidden() {
        return this.is_hidden;
    }
}