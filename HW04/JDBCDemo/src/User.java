/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prateek
 */
public interface User {
    // getName : -> String
    // returns : the name of this user
    // example : makeUser("@ann", "Ann","ann@example.com", "Password", "", 1, 0). getName() -> "Ann"
    String getName();
    // getHandle : -> String
    // returns : the handle of this user.
    // example : makeUser("@ann", "Ann","ann@example.com", "Password", "", 1, 0). getHandle() -> "@ann"
    String getHandle();
    // getEmail : -> String
    // returns : the email-id of this user
    // example : makeUser("@ann", "Ann","ann@example.com", "Password", "", 1, 0). getEmail() -> "ann@example.com"
    String getEmail();
    // getPassword
    // returns : the password of this user
    // example : makeUser("@ann", "Ann","ann@example.com", "Password", "", 1, 0). getPassword() -> "Password"
    String getPassword();
    // getDesc : -> String
    // returns : the discription of the user
    // example : makeUser("@ann", "Ann","ann@example.com", "Password", "", 1, 0). getDesc() -> ""
    String getDesc();
    // isUser : -> String
    // returns : 1 if the user is a person, 0 if the user represents an organization
    // example : makeUser("@ann", "Ann","ann@example.com", "Password", "", 1, 0). getisUser() -> 1
    int isUser();
    // isHidden : -> String
    // returns : 1 is the user profile is hidden, 0 if not.
    // example : makeUser("@ann", "Ann","ann@example.com", "Password", "", 1, 0). getisHidden() -> 0
    int isHidden();
}
