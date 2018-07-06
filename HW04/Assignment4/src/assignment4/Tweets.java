package assignment4;


public class Tweets implements Tweet
{
    String post, handle, timestamp;

    // Constructor
    protected Tweets(String post, String handle, String timestamp)
    {
        this.post = post;
        this.handle = handle;
        this.timestamp = timestamp;
    }

    // Static Factory Method
    static Tweet makeTweet(String post, String handle, String timestamp)
    {
        return new Tweets(post, handle, timestamp);
    }

    // getTweet() : -> String
    // Returns: the text of the tweet
    // Example: makeTweet("@ann", "HEllo", 2018-06-29 12:52:23).getTweet(); -> "HEllo";
    @Override
    public String getTweet() {
        return this.post;
    }

    // getHandle() : -> String
    //Returns : the twitter handle of the user who posted this tweet
    // Example: makeTweet("@ann", "HEllo", 2018-06-29 12:52:23).getHandle(); -> "@ann";
    @Override
    public String getHandle() {
        return this.handle;
    }

    // getTimestamp : -> String
    //Returns : the timestamp when the tweet
    // Example: makeTweet("@ann", "HEllo", 2018-06-29 12:52:23).getTimestamp(); -> 2018-06-29 12:52:23;
    @Override
    public String getTimestamp() {
        return this.timestamp;
    }

}
