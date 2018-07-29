package splitwise;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {
    private String url;
    private String user;
    private String password;
    private Connection con = null;

    //Constructor
    DBConnect(String url)
    {
        ArrayList<String> words;
        this.url = url;
        words = new ArrayList<String>(loadFile());
        this.user = words.get(0).toString();
        this.password = words.get(1).toString();
    }

    // loadFile : -> List<String>
    // Returns : a list of string, containing the username and the password
    //          loaded from the file.
    // Example : new DBConnect("jdbc:mysql://localhost:3306/Twitter?autoReconnect=true&useSSL=false).loadFile()
    ArrayList<String> loadFile()
    {
        ArrayList<String> words = new ArrayList<String>();
        try {
            File f = new File(System.getProperty("user.dir")+ File.separator +
                                                 "database.secret");
            Scanner sc = new Scanner(f);
            while(sc.hasNext())
            {
                words.add(sc.next());
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return words;
    }

    // getConnection : -> Connection
    // Returns: the connection object, representing the connection to the
    //          the database.
    // Example: new DBConnect("jdbc:mysql://localhost:3306/Twitter?autoReconnect=true&useSSL=false).getConnection()
    public Connection getConnection()
    {
        if(con == null)
        {
            try {
                con = DriverManager.getConnection(url, user, password);
                        }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return con;
    }

    // closeConnection() : -> Connection
    // Effect : closes the current databse connection.
    // Example: new DBConnect("jdbc:mysql://localhost:3306/Twitter?autoReconnect=true&useSSL=false).closeConnection()
    public void closeConnection()
    {
        try
        {
        con.close();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
