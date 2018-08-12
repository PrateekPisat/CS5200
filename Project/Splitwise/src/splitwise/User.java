package splitwise;

public interface User 
{
    // getUserId: void -> int
    // Returns: this user's id
    // example: new Users(1, "Alice", "alice@example.com", "Password", "7816058640", 120.0).getUserId() -> 1
    int getUserId();
    
    // getUserName: void -> String
    // Returns: the user's name;
    // example: new Users(1, "Alice", "alice@example.com", "Password", "7816058640", 120.0).getUserName() -> "Alice"
    String getUserName();
    
    // getUserEmail: void -> String
    // Returns: the user's email
    // example: new Users(1, "Alice", "alice@example.com", "Password", "7816058640", 120.0).getEmail() -> "alice@example.com"
    String getEmail();
    
    // getPassword: void -> String
    // Returns: the user's password
    // example: new Users(1, "Alice", "alice@example.com", "Password", "7816058640", 120.0).getUserId() -> "Password"
    String getPassword();
    
    // getPhone: void -> String
    // Returns: the user's phone number
    // example: new Users(1, "Alice", "alice@example.com", "Password", "7816058640", 120.0).getPhone() -> "7816058540"
    String getPhone();
    
    // getBudget: void -> float
    // Returns: the user's budget
    // example: new Users(1, "Alice", "alice@example.com", "Password", "7816058640", 120.0).getBudget() -> 120.0
    float getBudget();
}
