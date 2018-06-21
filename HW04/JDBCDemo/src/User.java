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
    //Returns the user name
    String getName();
    //return the user handle
    String getHandle();
    //returns the user email
    String getEmail();
    //returns the user password
    String getPassword();
    //returns the user Descrpition
    String getDesc();
    //returns 1 for user, 0 for organization
    int isUser();
    //returns 1 for hidden, 0 otherwise
    int isHidden();
}
