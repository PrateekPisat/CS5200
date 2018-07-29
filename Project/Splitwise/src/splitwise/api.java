package splitwise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class api implements InterfaceAPI
{
    // Setting up the DBConnection
    DBConnect dbc = new DBConnect(
    "jdbc:mysql://localhost:3306/Splitwise?autoReconnect=true&useSSL=false");
    
    // login: String String -> Int
    // Input: the email and the password
    // Output: The user's id on success, -1 of failure.
    // Example: login("Alice", "Password") -> 1
    public int login(String email, String password)
    {
        try
        {
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Users_id from Users \n" +
                                           "where email = '"+ email +"' and "
                                           + "password = '"+ password + "'");
            if(rs.next())
            {
                return Integer.parseInt(rs.getString("Users_id"));
            }
            else
            {
                st.close();
                rs.close();
                return -1;
            }
        }
        catch(SQLException e)
        {e.printStackTrace();}
        return -1;
    }
    
    // register: String, String, String, String,Int -> Int
    // Input: The new user's name, email, password, phone, access previlleges.
    // Output: 1 on success, -1 on failure.
    // Example: register("Bob", "bob@example.com", "Password", "1234567890", 0) -> 1
    public int register(String name, String email, String pass, String phone, int isHidden)
    {
        try
        {
            Connection con = dbc.getConnection();
            String query = "INSERT INTO `Splitwise`.`Users` \n" +
                           "(`Name`, `Email`, `Password`, `Phone`, `Hide_Data`)\n" +
                           "values(?, ?, ?, ?, ?);";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setString(2, email);
            preparedStmt.setString(3, pass);
            preparedStmt.setString(4, phone);
            preparedStmt.setInt(5, isHidden);
            preparedStmt.execute();
            preparedStmt.close();
            return 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return -1;
        }
    }
    
    // getUserName
    String getUserName(int user_id)
    {
        try{
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Name from Users \n" +
                                           "where Users_id = '"+ user_id +"'");
            if(rs.next())
            {
                return rs.getString("Name");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    float getCredit(int user_id)
    {
        try{
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select COALESCE(sum(Amount),0) as 'Credit'\n" +
                                           "from Ledger\n" +
                                           "where Creditor = "+ user_id +" and debtor <> "+ user_id +"");
            if(rs.next())
            {
                return Float.parseFloat(rs.getString("Credit"));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    float getDebit(int user_id)
    {
        try{
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select COALESCE(sum(Amount),0) as 'Debit'\n" +
                                           "from Ledger\n" +
                                           "where Debtor = "+ user_id +" and Creditor <> "+ user_id +"");
            if(rs.next())
            {
                return Float.parseFloat(rs.getString("Debit"));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    public int createBill(String name, String Desc, int paid_by, Timestamp date)
    {
        try{
            if(name.equals(""))
            {
                System.out.println("Name Can't be Blank");
                return -2;
            }
            Connection con = dbc.getConnection();
            String query = "INSERT INTO `Splitwise`.`Bills` \n" +
                           "(`Name`,`Description`, `Date`, `Paid_By`)\n" +
                           "VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString(1, name);
            preparedStmt.setString(2, Desc);
            preparedStmt.setTimestamp(3, date);
            preparedStmt.setInt(4, paid_by);
            preparedStmt.execute();
            ResultSet rs = preparedStmt.getGeneratedKeys();
            if(rs.next())
                return rs.getInt(1);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    // getBill : int -> Bill
    // Input: Bill ID
    // Output: Bill associated with that bill id, if no bill is found, 
    //         returns NULL 
    //example: getBill(1) -> new Bill(1, "Stop-n-Shop Groceries", "2018-07-01 
    //                                03:36:00", 
    //                                "Groceries I brought at Stop n Shop", 1)
    Bill getBill(int id)
    {
        try
        {
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Bills \n" +
                                           "where Bills_id = '"+ id +"'");
            if(rs.next())
            {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                Date dt = formatter.parse(rs.getString("Date"));
                return new Bills(Integer.parseInt(rs.getString("Bills_id")),
                                rs.getString("Name"),
                                dt, rs.getString("Description"), 
                                Integer.parseInt(rs.getString("Paid_By")));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    // addItem() : Int, Int, String, Float -> Int
    // Input: the bill number, item number, item name, item cost
    // Effect: inserts an item.
    // Output: 1 on succesfull insertion of item, -1 on failure
    // Example: addItem(1, 1, "Bread", 2.03) -> 1
    public int addItem(int item_id, int bill_id, String name, float cost)
    {
        try
        {
            Connection con = dbc.getConnection();
            String query = "INSERT INTO `Splitwise`.`Bill_Items` \n" +
                           "(`Item_id`, `Bills_id`, `Name`, `Cost`) \n" +
                           "VALUES \n" +
                            "(?, ?, ?, ?);";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, item_id);
            preparedStmt.setInt(2, bill_id);
            preparedStmt.setString(3, name);
            preparedStmt.setFloat(4, cost);
            preparedStmt.execute();
            return 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    // deleteBill : int -> int 
    // Input: the bill id of the bill to be deleted.
    // Output: 1 on success, -1 on failure.
    // Effect: the said bill is deleted
    // Example: deleteBill(1) -> 1
    public int deleteBill(int bill_id)
    {
        try{
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            String query = "delete from Bills where Bills_id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, bill_id);
            preparedStmt.execute();
            return 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    // getUserList : void -> Vector<Items>
    // Output: returns the a vector of items representing the user_id and their
    //         name.
    // Example: getUserList() -> [new Item(1, 'Alice'), new Item(2, 'Bob')]
    public Vector<Item> getUsersList()
    {
        Vector<Item> v = new Vector<Item>();
        try{
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Users_id, Name from Users \n");
            while(rs.next())
            {
                v.add(new Item(Integer.parseInt(rs.getString("Users_id")), rs.getString("Name")));
            }
            return v;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    // sendRequest : int int -> int
    // Input: the bill id of the bill and user id of the user to who the 
    //        bill is to be sent.
    // Output: 1 on success, -1 on failure.
    // Example: sendRequest(1, 5) -> 1
    public int sendRequest(int bill_id, int user_id)
    {
        try
        {
            Connection con = dbc.getConnection();
            String query = "INSERT INTO `Splitwise`.`Bill_Requests` \n" +
                           "(`To_id`, `Bills_id`) \n" +
                           "VALUES \n" +
                            "(?, ?);";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, user_id);
            preparedStmt.setInt(2, bill_id);            
            preparedStmt.execute();
            return 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    // getPendingRequests : int -> int
    // Input: the user id of the user
    // Output: the number of pending bill requests on success, -1 on fialure.
    // Example: getPendingRequests(1) - > 1
    public int getPendingRequests(int user_id)
    {
        try{
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select count(Bills_id) as 'Pending Requests'\n" +
                                           "from Bill_Requests\n" +
                                           "where To_id="+ user_id +";");
            if(rs.next())
            {
                return Integer.parseInt(rs.getString("Pending Requests"));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    // getBillRequestsFor : int -> List<Bill>
    // Input: user is for the user
    // Output: A list of bills on success
    // Example: getBillRequestsFor(1) -> [Bill1, Bill2]
    public List<Bill> getBillRequestsFor(int user_id)
    {
        try{
            List<Bill> bills = new ArrayList<Bill>();
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Bills_id \n" +
                                           "from Bill_Requests \n" +
                                           "where To_id = "+ user_id +"");
            while(rs.next())
            {
                bills.add(getBill(Integer.parseInt(rs.getString("Bills_id"))));
            }
            return bills;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    // deleteRequest : int int -> int
    // Input: bill id and the user id
    // Output: 1 on success, -1 on failure.
    // Example: deleteRequest(1, 2) -> 1
    public int deleteRequest(int bill_id, int user_id)
    {
        try
        {
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            String query = "delete from Bill_Requests where To_id = ? and \n"+
                           " Bills_id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, user_id);
            preparedStmt.setInt(2, bill_id);
            preparedStmt.execute();
            return 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    // closeConnection
    // effect: closes the connection to the database
    // example: closeConnection();
    public void closeConnection()
    {
        try
        {
            dbc.getConnection().close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
