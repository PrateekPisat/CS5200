package splitwise;

public class Users implements User
{
    String name, email, pass, phone;
    int id;
    float budget;
    
    Users(int id, String name, String email, String pass, String phone, float budget)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
        this.budget = budget;
    }
    
    @Override
    public int getUserId() {
        return id;
    }

    @Override
    public String getUserName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return pass;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public float getBudget() {
        return budget;
    }
    
}
