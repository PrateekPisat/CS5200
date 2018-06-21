
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class api
{
    // input: follower handle, followee handle
    // effect: the follower will follow the followee
    // example: addFollower(@ann, @bob);
    public int addFollower(String follower, String followee)
    {
        int follower_id = -1, followee_id = -1;
        try{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/twitter", "Prateek", "Pradnya&1");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select user_id from users where handle = '"+ follower +"'");
        if(rs.next())
            follower_id = Integer.parseInt(rs.getString("user_id"));
        else
        {
            System.out.println(follower + " Does not exist!");
            return -1;
        }
        rs = st.executeQuery("select user_id from users where handle = '"+ followee +"'");
        if(rs.next())
            followee_id = Integer.parseInt(rs.getString("user_id"));
        else
        {
            System.out.println(followee + " Does not exist!");
            return -1;
        }
        String query = "INSERT INTO `Twitter`.`follows` (follower_id, followee_id) \n" +
                           "VALUES \n" +
                           "(?, ?)";
        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt (1, follower_id);
        preparedStmt.setInt (2, followee_id);
        // execute the preparedstatement
        preparedStmt.execute();
        con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
    
    // input: user handle, tweet
    // effect: the said tweet will be posted
    // example: postTweet(@ann, "I love Northeastern #neu")
    public int postTweet(Tweet t) throws ParseException
    {
        int user_id=-1;
        try{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/twitter", "Prateek", "Pradnya&1");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select user_id from users where handle = '"+ t.getHnadle() +"'");
        if(rs.next())
            user_id = Integer.parseInt(rs.getString("user_id"));
        else
        {
            System.out.println(t.getHnadle()+"Does not exist!, This");
            return -1;
        }
        String query = "INSERT INTO `Twitter`.`tweets` (user_id, post, timestamp) \n" +
                           "VALUES \n" +
                           "(?, ?, ?)";
        // create the mysql insert preparedstatement
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1=formatter1.parse(t.getTimestamp());  
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt (1, user_id);
        preparedStmt.setString (2, t.getTweet());
        preparedStmt.setDate (3, sqlDate);
        // execute the preparedstatement
        preparedStmt.execute();
        con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
    
    public int addUser(User u) throws Exception
    {
        try{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/twitter", "Prateek", "Pradnya&1");
        String query = "INSERT INTO `Twitter`.`users` (handle, name, email, password, discription, is_person, is_hidden) \n" +
                           "VALUES \n" +
                           "(?, ?, ?, ?, ?, ?, ?)";
        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString (1, u.getHandle());
        preparedStmt.setString (2, u.getName());
        preparedStmt.setString (3, u.getEmail());
        preparedStmt.setString (4, u.getPassword());
        preparedStmt.setString (5, u.getDesc());
        preparedStmt.setInt (6, u.isUser());
        preparedStmt.setInt (7, u.isHidden());
        
        // execute the preparedstatement
        preparedStmt.execute();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
    
    public List<Tweet> fetchHomeTimeline(String handle, int maxReturned) throws Exception
    {
        ArrayList<Tweet> toReturn = new ArrayList<Tweet>();
        int user_id = -1;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/twitter", "Prateek", "Pradnya&1");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select user_id from users where handle = '"+ handle +"'");
        if(rs.next())
            user_id = Integer.parseInt(rs.getString("user_id"));
        rs = st.executeQuery("select post as 'Tweets', handle, timestamp\n" +
                "from\n" +
                "(\n" +
                "	select followee_id\n" +
                "	from follows\n" +
                "	where follower_id = "+user_id+"\n" +
                ") as t1, tweets, users\n" +
                "where tweets.user_id = t1.followee_id and users.User_id = tweets.user_id\n" +
                "order by tweets.timestamp desc, name\n" +
                "limit " + maxReturned + ";");
        while(rs.next())
        {
            toReturn.add(Tweets.makeTweet(rs.getString("Tweets"), rs.getString("handle"), rs.getString("timestamp")));
        }
        System.out.println("Tweet by Handle");
        for(int i=0;i<toReturn.size();i++)
        {
            System.out.println(toReturn.get(i).getTweet() + " by " + toReturn.get(i).getHnadle());
        }
        return toReturn;
    }
}
