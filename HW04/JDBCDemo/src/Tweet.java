/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prateek
 */
public interface Tweet {
    //Returns the tweet
    String getTweet();
    
    //Returns the twitter handle of the user who posted this tweet
    String getHnadle();
    //Returns the timestamp
    String getTimestamp();
}
