
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LoadData
{
    public void loadUsers() throws Exception
    {
        List<String> words;
        String s;
        //The Balance of each record is grouped into three lists
        ArrayList<User> users = new ArrayList<User>();
        File f = new File(System.getProperty("user.dir")+ File.separator + "users.csv");
        Scanner sc = new Scanner(f);
        sc.nextLine();
        words = new ArrayList<String>();
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
            if(new api().addUser(Users.makeUser(words.get(0).toString(),
                                             words.get(1).toString() ,
                                             words.get(2).toString() , 
                                             words.get(3).toString(), 
                                             words.get(4).toString(), 
                                             Integer.parseInt(words.get(5).toString()), 
                                             Integer.parseInt(words.get(6).toString()))) == -1)
            {
                System.out.println("Something Went Wrong!");
                System.exit(-1);
            }
            words.removeAll(words);
        }
    }
    
    public void loadTwets() throws Exception
    {
        List<String> words;
        String s;
        //The Balance of each record is grouped into three lists
        ArrayList<User> users = new ArrayList<User>();
        File f = new File(System.getProperty("user.dir")+ File.separator + "tweets.csv");
        Scanner sc = new Scanner(f);
        sc.nextLine();
        words = new ArrayList<String>();
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
            if(new api().postTweet(Tweets.makeTweet(words.get(1).toString(), words.get(0).toString(), words.get(2).toString())) == -1)
            {
                System.out.println("Something Went Wrong!");
                System.exit(-1);
            }
            //System.out.println(words);
            words.removeAll(words);
        }
    }
    
    public void loadFollows() throws Exception
    {
        List<String> words;
        String s;
        //The Balance of each record is grouped into three lists
        ArrayList<User> users = new ArrayList<User>();
        File f = new File(System.getProperty("user.dir")+ File.separator + "followers.csv");
        Scanner sc = new Scanner(f);
        sc.nextLine();
        words = new ArrayList<String>();
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
            if(new api().addFollower(words.get(0),words.get(1)) == -1)
            {
                System.out.println("Something Went Wrong!");
                System.exit(-1);
            }
            words.removeAll(words);
        }
    }
    
    public static void main(String ar[]) throws Exception
    {
        LoadData l = new LoadData();
       // l.loadUsers();
       // l.loadTwets();
       //l.loadFollows();
        new api().fetchHomeTimeline("@ann", 5);
    }
}
