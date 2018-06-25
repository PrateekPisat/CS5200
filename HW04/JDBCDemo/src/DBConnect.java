import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {
    private String url;
    private String user;
    private String password;
    
    private Connection con = null;
    
    DBConnect(String url, String user, String password)
    {
        this.url = url;
        this.user = user;
        this.password = password;
    }
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
