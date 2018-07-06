package assignment4;


public interface Tweet {
    // getTweet() : -> String
    // Returns: the text of the tweet
    // Example: makeTweet("@ann", "HEllo", 2018-06-29 12:52:23).getTweet(); -> "HEllo";
    String getTweet();
    // getHandle() : -> String
    //Returns : the twitter handle of the user who posted this tweet
    // Example: makeTweet("@ann", "HEllo", 2018-06-29 12:52:23).getHandle(); -> "@ann";
    String getHandle();
    // getTimestamp : -> String
    //Returns : the timestamp when the tweet
    // Example: makeTweet("@ann", "HEllo", 2018-06-29 12:52:23).getTimestamp(); -> 2018-06-29 12:52:23;
    String getTimestamp();
}
