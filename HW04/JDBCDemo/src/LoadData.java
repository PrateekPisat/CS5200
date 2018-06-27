
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LoadData
{
    // loadUsers
    // Effect : read "users.csv" and adds the users to the database.
    // example: new LoadData().loadUsers();
    public void loadUsers() throws Exception
    {
        List<String> words;
        String s;
        //The Balance of each record is grouped into three lists
        ArrayList<User> users = new ArrayList<User>();
        File f = new File(System.getProperty("user.dir")+ File.separator +
                                             "users.csv");
        Scanner sc = new Scanner(f);
        sc.nextLine();
        words = new ArrayList<String>();
        api a = new api();
        while(sc.hasNextLine())
        {
            s = sc.nextLine();
            //The following line of code ensures that no record has a balnk
            //entry.
            s = s.replace(",,", ", ,");
            StringTokenizer st1 = new StringTokenizer(s, ",");
            // temporarily store the data of each row in a list of strings.
            while(st1.hasMoreTokens())
                words.add(st1.nextToken());
            if(a.addUser(Users.makeUser(words.get(0).toString(),
                                        words.get(1).toString() ,
                                        words.get(2).toString() ,
                                        words.get(3).toString(),
                                        words.get(4).toString(),
                                        Integer.parseInt(
                                          words.get(5).toString()),
                                        Integer.parseInt(
                                          words.get(6).toString()))) == -1)
            {
                System.out.println("Something Went Wrong!");
                System.exit(-1);
            }
            words.removeAll(words);
        }
        a.closeConnection();
    }

    // loadTwets
    // effect : reads "tweets.csv" and loads the tweets in the database.
    // example : new LoadData().loadTweets();
    public void loadTweets() throws Exception
    {
        List<String> words;
        String s;
        //The Balance of each record is grouped into three lists
        ArrayList<User> users = new ArrayList<User>();
        File f = new File(System.getProperty("user.dir") + File.separator +
                                             "tweets.csv");
        Scanner sc = new Scanner(f);
        sc.nextLine();
        words = new ArrayList<String>();
        api a = new api();
        while(sc.hasNextLine())
        {
            s = sc.nextLine();
            //The following line of code ensures that no record has a balnk
            //entry.
            s = s.replace(",,", ", ,");
            StringTokenizer st1 = new StringTokenizer(s, ",");
            // temporarily store the data of each row in a list of strings.
            while(st1.hasMoreTokens())
                words.add(st1.nextToken());
            if(a.postTweet(Tweets.makeTweet(words.get(1).toString(),
                                            words.get(0).toString(),
                                            words.get(2).toString())) == -1)
            {
                System.out.println("Something Went Wrong!");
                System.exit(-1);
            }
            //System.out.println(words);
            words.removeAll(words);
        }
        a.closeConnection();
    }

    // loadFollows
    // Effect : reads "followers.csv" and adds them to the databse.
    // Example : new LoadData().loadFollows();
    public void loadFollows() throws Exception
    {
        List<String> words;
        String s;
        //The Balance of each record is grouped into three lists
        ArrayList<User> users = new ArrayList<User>();
        File f = new File(System.getProperty("user.dir")+ File.separator +
                                             "followers.csv");
        Scanner sc = new Scanner(f);
        sc.nextLine();
        words = new ArrayList<String>();
        api a = new api();
        while(sc.hasNextLine())
        {
            s = sc.nextLine();
            //The following line of code ensures that no record has a balnk
            //entry.
            s = s.replace(",,", ", ,");
            StringTokenizer st1 = new StringTokenizer(s, ",");
            // temporarily store the data of each row in a list of strings.
            while(st1.hasMoreTokens())
                words.add(st1.nextToken());
            if(a.addFollower(words.get(0),words.get(1)) == -1)
            {
                System.out.println("Something Went Wrong!");
                System.exit(-1);
            }
            words.removeAll(words);
        }
        a.closeConnection();
    }

    public static void main(String ar[]) throws Exception
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
