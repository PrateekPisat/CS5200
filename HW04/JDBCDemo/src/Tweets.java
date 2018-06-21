public class Tweets implements Tweet
{
    String post, handle, timestamp;
    protected Tweets(String post, String handle, String timestamp)
    {
        this.post = post;
        this.handle = handle;
        this.timestamp = timestamp;
    }
    
    static Tweet makeTweet(String post, String handle, String timestamp)
    {
        return new Tweets(post, handle, timestamp);
    }
    
    @Override
    public String getTweet() {
        return this.post;
    }

    @Override
    public String getHnadle() {
        return this.handle;
    }

    @Override
    public String getTimestamp() {
        return this.timestamp;
    }
    
}