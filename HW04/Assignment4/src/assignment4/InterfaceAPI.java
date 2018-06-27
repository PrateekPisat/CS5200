package assignment4;
import java.text.ParseException;
import java.util.List;

public interface InterfaceAPI
{
    // input: follower handle, followee handle
    // returns: 0 on success, -1 if some exception.
    // effect: the follower will follow the followee
    // example: addFollower(@ann, @bob);
    public int addFollower(String follower, String followee);

    // input: user handle, tweet
    // returns: 0 on success, -1 on failure.
    // effect: the said tweet will be posted
    // example: postTweet(@ann, "I love Northeastern #neu")
    public int postTweet(Tweet t);

    // input: handle
    // returns: The list of Users that follow the given user.
    // example: getFollowers(@ann)
    public List<User> getFollowers(String handle);

    // input: User u
    // returns: 0 on success, -1 on failure.
    // effect: add the given user.
    // example: addUser(Users.make("@ann", "Ann", "ann@example.com", "password", "", 1, 0));
    public int addUser(User u);

    // input: String handle, int number of tweets
    // returns: List of Users
    // example: fetchHomeTimeline("@ann", 5)
    public List<Tweet> fetchHomeTimeline(String handle, int maxReturned);
}
