// A user instance represents a registered user.
package splitwise;

public class Users implements User
{
    // Class Variables
    String name, email, pass, phone;
    int id;
    float budget;
    
    // constructor
    Users(int id, String name, String email, String pass, String phone, float budget)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
        this.budget = budget;
    }
    
    // getUserId: void -> int
    // Returns: this user's id
    // example: new Users(1, "Alice", "alice@example.com", "Password", "7816058640", 120.0).getUserId() -> 1
    @Override
    public int getUserId() {
        return id;
    }

    // getUserName: void -> String
    // Returns: the user's name;
    // example: new Users(1, "Alice", "alice@example.com", "Password", "7816058640", 120.0).getUserName() -> "Alice"
    @Override
    public String getUserName() {
        return name;
    }

    // getUserEmail: void -> String
    // Returns: the user's email
    // example: new Users(1, "Alice", "alice@example.com", "Password", "7816058640", 120.0).getEmail() -> "alice@example.com"
    @Override
    public String getEmail() {
        return email;
    }

    // getPassword: void -> String
    // Returns: the user's password
    // example: new Users(1, "Alice", "alice@example.com", "Password", "7816058640", 120.0).getUserId() -> "Password"
    @Override
    public String getPassword() {
        return pass;
    }

    // getPhone: void -> String
    // Returns: the user's phone number
    // example: new Users(1, "Alice", "alice@example.com", "Password", "7816058640", 120.0).getPhone() -> "7816058540"
    @Override
    public String getPhone() {
        return phone;
    }

    // getBudget: void -> float
    // Returns: the user's budget
    // example: new Users(1, "Alice", "alice@example.com", "Password", "7816058640", 120.0).getBudget() -> 120.0
    @Override
    public float getBudget() {
        return budget;
    }
    
}
