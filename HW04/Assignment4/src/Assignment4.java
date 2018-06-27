import java.util.ArrayList;
public class Assignment4 {

    public static void main(String[] args) throws Exception
    {
        LoadData l = new LoadData();
        l.loadUsers();
        l.loadTweets();
        l.loadFollows();
        ArrayList<Tweet> t1 = new ArrayList<Tweet>(new api().fetchHomeTimeline("@ann", 5));
        for(Tweet t : t1)
        {
            System.out.println(t.getTweet() + " by " + t.getHandle());
        }
         ArrayList<User> s = new ArrayList<User>(new api().getFollowers("@ann"));
         for(User u : s)
         {
             System.out.println(u.getName());
         }
    }

}
