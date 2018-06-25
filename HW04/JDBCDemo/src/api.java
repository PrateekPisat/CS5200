import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class api implements InterfaceAPI
{
    // input: follower handle, followee handle
    // returns: 0 on success, -1 if some exception.
    // effect: the follower will follow the followee
    // example: addFollower(@ann, @bob);
    public int addFollower(String follower, String followee)
    {
        int follower_id = -1, followee_id = -1;
        try{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Twitter?autoReconnect=true&useSSL=false", "Prateek", "Pradnya&1");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select user_id from Users where handle = '"+ follower +"'");
        if(rs.next())
            follower_id = Integer.parseInt(rs.getString("user_id"));
        else
        {
            System.out.println(follower + " Does not exist!");
            return -1;
        }
        rs = st.executeQuery("select user_id from Users where handle = '"+ followee +"'");
        if(rs.next())
            followee_id = Integer.parseInt(rs.getString("user_id"));
        else
        {
            System.out.println(followee + " Does not exist!");
            return -1;
        }
        String query = "INSERT INTO `Twitter`.`Follows` (follower_id, followee_id) \n" +
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
            //return -1;
        }
        return 0;
    }

    // input: user handle, tweet
    // returns: 0 on success, -1 on failure.
    // effect: the said tweet will be posted
    // example: postTweet(@ann, "I love Northeastern #neu")
    public int postTweet(Tweet t) throws ParseException
    {
        int user_id=-1;
        try{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Twitter?autoReconnect=true&useSSL=false", "Prateek", "Pradnya&1");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select user_id from Users where handle = '"+ t.getHnadle() +"'");
        if(rs.next())
            user_id = Integer.parseInt(rs.getString("user_id"));
        else
        {
            System.out.println(t.getHnadle()+"Does not exist!, This");
            return -1;
        }
        String query = "INSERT INTO `Twitter`.`Tweets` (user_id, post, timestamp) \n" +
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
            //return -1;
        }
        return 0;
    }
    
    // input: handle
    // returns: The list of Users that follow the given user.
    // example: getFollowers(@ann)
    public List<User> getFollowers(String handle)
    {
        ArrayList<User> toReturn = new ArrayList();
        int user_id;
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Twitter?autoReconnect=true&useSSL=false", "Prateek", "Pradnya&1");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select user_id from Users where handle = '"+ handle +"'");
            if(rs.next())
                user_id = Integer.parseInt(rs.getString("user_id"));
            else
            {
                System.out.println(handle + " Does not exist!");
                return null;
            }
            rs = st.executeQuery("select name, handle, email, password, discription, is_person, is_hidden\n" +
                                "from\n" +
                                "(\n" +
                                "	select follower_id as 'Followees'\n" +
                                "	from follows\n" +
                                "	where Followee_id = "+ user_id +"\n" +
                                ")as t1 join users on(Followees = users.user_id)\n" +
                                "order by name;");
            while(rs.next())
            {
                toReturn.add(Users.makeUser(
                        rs.getString("handle"), 
                        rs.getString("name"), 
                        rs.getString("email"), 
                        rs.getString("email"), 
                        rs.getString("discription"),
                        Integer.parseInt(rs.getString("is_person")), 
                        Integer.parseInt(rs.getString("is_hidden"))));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        for(int i=0;i<toReturn.size();i++)
        {
            System.out.println(toReturn.get(i).getName());
        }
        return toReturn;
    }
    
    // input: User u
    // returns: 0 on success, -1 on failure.
    // effect: add the given user.
    // example: addUser(Users.make("@ann", "Ann", "ann@example.com", "password", "", 1, 0));
    public int addUser(User u) throws Exception
    {
        try{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Twitter?autoReconnect=true&useSSL=false", "Prateek", "Pradnya&1");
        String query = "INSERT INTO `Twitter`.`Users` (handle, name, email, password, discription, is_person, is_hidden) \n" +
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
            //return -1;
        }
        return 0;
    }

    // input: String handle, int number of tweets
    // returns: List of Users
    // example: fetchHomeTimeline("@ann", 5)
    public List<Tweet> fetchHomeTimeline(String handle, int maxReturned) throws Exception
    {
        ArrayList<Tweet> toReturn = new ArrayList<Tweet>();
        int user_id = -1;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Twitter?autoReconnect=true&useSSL=false", "Prateek", "Pradnya&1");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select user_id from Users where handle = '"+ handle +"'");
        if(rs.next())
            user_id = Integer.parseInt(rs.getString("user_id"));
        rs = st.executeQuery("select post as 'Tweets', handle, timestamp\n" +
                "from\n" +
                "(\n" +
                "	select followee_id\n" +
                "	from Follows\n" +
                "	where follower_id = "+user_id+"\n" +
                ") as t1, Tweets, Users\n" +
                "where Tweets.user_id = t1.followee_id and Users.user_id = Tweets.user_id\n" +
                "order by Tweets.timestamp desc, handle\n" +
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