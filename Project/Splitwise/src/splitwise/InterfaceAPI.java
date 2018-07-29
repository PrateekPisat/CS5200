package splitwise;


import java.text.ParseException;
import java.util.List;

public interface InterfaceAPI
{
    // login: String String -> Int
    // Input: the email and the password
    // Output: The user's id on success, -1 of failure.
    // Example: login("Alice", "Password") -> 1
    public int login(String email, String pass);
    
    // register: String, String, String, String,Int -> Int
    // Input: The new user's name, email, password, phone, access previlleges.
    // Output: 1 on success, -1 on failure.
    // Example: register("Bob", "bob@example.com", "Password", "1234567890", 0) -> 1
    public int register(String name, String email, String pass, String phone, int isHidden);
}
