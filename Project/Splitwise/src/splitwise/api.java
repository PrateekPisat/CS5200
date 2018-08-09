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
    
    // getAllUsers: void -> List<User>
    // output: returns a list of all the registered users except the given user
    // example: getAllUsers(2) -> [new Users("1", "Alice", "alice@example.com", "Password", "791231233", 100)]
    public List<User> getAllUsers(int user_id)
    {
        List<User> users = new ArrayList<User>();
        try
        {
         Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "select * from Users \n" +
                    "where Users_id <> "+user_id
            );
            while(rs.next())
            {
                users.add(new Users
                    (
                            Integer.parseInt(rs.getString("Users_id")),
                            rs.getString("Name"),
                            rs.getString("Email"),
                            rs.getString("Password"),
                            rs.getString("Phone"),
                            Float.parseFloat(rs.getString("Budget"))
                    )
                );
            }
            st.close();
            rs.close();
            return  users;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return users;
    }
    
    // getUserName
    String getUserName(int user_id)
    {
        try{
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "select Name from Users \n" +
                    "where Users_id = '"+ user_id +"'"
            );
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
            ResultSet rs = st.executeQuery(
                    "select COALESCE(round(sum(Amount),2),0) as 'Credit'\n" +
                    "from Ledger right join Share using(Bills_id, Item_id) join Bills using(Bills_id)\n" +
                    "where Paid_by = "+ user_id +" and Users_id <> "+ user_id +" and Is_Paid = 0"
            );
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
            ResultSet rs = st.executeQuery(
                    "select COALESCE(round(sum(Amount),2),0) as 'Debit'\n" +
                    "from Ledger right join Share using(Bills_id, Item_id) join Bills using(Bills_id)\n" +
                    "where Users_id = "+ user_id +" and Paid_by <> "+ user_id +" and Is_Paid = 0"
            );
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
    
    // createBill: String, String, int, Timestamp -> int
    // input: name, description, the id of the user who paid the bill, and 
    //        date when the bill was generated.
    // output: 1 if the bill was successfully created, -1 on failure.
    // example: createBill("Test", "This is a test bill", 1, 2018-08-06 06:25:44:123) -> 1
    public int createBill(String name, String Desc, int paid_by, Timestamp date)
    {
        //System.out.println(date.toString());
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
    
    // updateBill: String, String, int, Timestamp -> int
    // input: name, description, the id of the user who paid the bill, and 
    //        date when the bill was generated.
    // output: 1 if the bill was successfully created, -1 on failure.
    // example: updateBill(1, "Test", "This is a test bill", 1, 2018-08-06 06:25:44:123) -> 1
     public int updateBill(int bill_id, String name, String Desc, int paid_by, Timestamp date)
    {
        try{
            if(name.equals(""))
            {
                System.out.println("Name Can't be Blank");
                return -2;
            }
            Connection con = dbc.getConnection();
            String query = 
                    "UPDATE `Splitwise`.`Bills` SET \n" +
                    "`Name` = ?,`Description` = ? , `Date` = ?, `Paid_By`= ?\n"+
                    "WHERE Bills_id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setString(2, Desc);
            preparedStmt.setTimestamp(3, date);
            preparedStmt.setInt(4, paid_by);
            preparedStmt.setInt(5, bill_id);
            preparedStmt.execute();
            return 1;
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
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
            return -1;
        }
        return -1;
    }
    
    // yetToAnswerRequests: int -> int
    // input: the user_id
    // output: the number of bill requests send by this user that have not yet
    //         been filled.
    // example: yetToAnswerRequests(1) -> 1
    public int yetToAnswerRequests(int user_id)
    {
        try
        {
             Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "select count(Bills_Id) as 'Pending Requests'\n" +
                    "from Bills join bill_requests using(Bills_id)\n" +
                    "where Paid_By = "+user_id
            );
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
            rs.close();
            st.close();
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
            st.close();
            return 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    // getBillItems: int -> List<BillItem>
    // Input: the id of the bill
    // Output: A list of items belonging to that bill.
    // Example: getBillItems(1) -> [new Item(1, "Bread", 2.41)];
    public List<BillItem> getBillItems(int bill_id)
    {
        List<BillItem> items = new ArrayList<BillItem>();
        try
        {
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * \n" +
                                           "from Bill_Items \n" +
                                           "where Bills_id = "+ bill_id +"");
            while(rs.next())
            {
                items.add(new BillItem(
                        Integer.parseInt(rs.getString("Item_id")),  
                        rs.getString("Name"),
                        Float.parseFloat(rs.getString("Cost"))
                    ));
            }
            rs.close();
            st.close();
            return items;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return items;
    }
    
    // getShare: int int int -> boolean
    // input : the user_id, the bill_id and the item_id
    // output: true if user is already included to share that item, else false.
    // example: getShare(1, 1, 1) -> true
    public boolean getShare(int user_id, int bill_id, int item_id)
    {
        try
        {
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * \n" +
                                           "from Share \n" +
                                           "where Bills_id = "+ bill_id +" \n" +
                                           " and Users_id = "+ user_id +"\n"+
                                           " and Item_id = "+ item_id);
            if(rs.next())
            {
                rs.close();
                st.close();
                return true;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    
    // addShare: int int int -> int
    // input: the user_id, the bill_id and the 
    // output: 1 on succesfull add a new share record, else -1
    // example: addShare(1, 1, 1, 0) -> 1
    public int addShare(int user_id, int bill_id, int item_id)
    {
        try
        {
            Connection con = dbc.getConnection();
            String query = "INSERT INTO `Splitwise`.`Share` \n" +
                           "(`Bills_id`, `Item_id`, `Users_id`, `Is_Paid`) \n" +
                           "VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, bill_id);
            preparedStmt.setInt(2, item_id);
            preparedStmt.setInt(3, user_id);
            preparedStmt.setInt(4, 0);
            preparedStmt.execute();
            preparedStmt.close();
            System.out.println("BillId = "+bill_id+" Item_id = "+item_id);
            return updateLedger(bill_id, item_id);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return -1;
        }
    }
    
    // deleteShare: int int int -> int
    // input: the user_id, the bill_id and the 
    // output: 1 on succesfully deleting said share record, else -1
    // example: addShare(1, 1, 1) -> 1
    public int deleteShare(int user_id, int bill_id, int item_id)
    {
        try
        {
            Connection con = dbc.getConnection();
            String query = "delete from Share where Users_id = ? and \n"+
                           " Bills_id = ? and Item_id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, user_id);
            preparedStmt.setInt(2, bill_id);
            preparedStmt.setInt(3, item_id);
            preparedStmt.execute();
            return updateLedger(bill_id, item_id);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return -1;
        }
    }
    
    // updateLegder: int int -> int
    // input: the bill_id and item_id
    // output: 1 on successfully updating the cost of the item, -1 on failure.
    // example: updateLedger(1, 1) -> 1;
    public int updateLedger(int bill_id, int item_id)
    {
        try{
            Connection con = dbc.getConnection();
            int totalSharees = getSharees(bill_id, item_id);
            float cost = getCost(bill_id, item_id);
            if(totalSharees == -1 || cost == -1)
                return -1;
            cost = totalSharees>0?cost / totalSharees:cost;
            
            String query = "INSERT INTO Ledger(Amount, Bills_id, Item_id) VALUES (?, ?, ?)\n" +
                           "  ON DUPLICATE KEY UPDATE Amount = ? ;";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setFloat(1, cost);
            preparedStmt.setInt(2, bill_id);
            preparedStmt.setInt(3, item_id);
            preparedStmt.setFloat(4, cost);
            preparedStmt.execute();
            return 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return -1;
        }
    }
    
    // getSharees: int int -> int
    // input: the bill_id and the the item_id
    // output: the number of users sharing the said item on suceess, -1 on 
    //         failure.
    // example: getSharees(1,1) -> 3
    int getSharees(int bill_id, int item_id)
    {
        try
        {
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "select count(Users_id) as 'count' \n" +
                    "from Share \n" +
                    "where Bills_id = "+ bill_id +" \n" +
                    " and Item_id = "+ item_id
            );
            if(rs.next())
            {
                return Integer.parseInt(rs.getString("count"));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return -1;
        }
        return -1;
    }
    
    // getCost: int int -> float
    // input: the bill_id and the item_id
    // output: the cost of the said item on success, else -1 on failure.
    // example: getCost(1, 1) -> 5.83
    float getCost(int bill_id, int item_id)
    {
        try
        {
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select cost \n" +
                                           "from Bill_Items \n" +
                                           "where Bills_id = "+ bill_id +" \n" +
                                           " and Item_id = "+ item_id);
            if(rs.next())
            {
                return Float.parseFloat(rs.getString("cost"));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return -1;
        }
        return -1;
    }
    
    // getParticipatedBills: int -> List<Bill>
    // input: the user id
    // output: A list of Bills the user particpated in on success, null on 
    //         failure.
    // example: getParticipatedBills(1) -> [new Bill(1, 'Test', '', 06/28/2018)]
    
    public List<Bill> getParticipatedBills(int user_id)
    {
        List<Bill> bills = new ArrayList<Bill>();
        try{
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                   "select *\n" +
                   "from Share\n" +
                   "where Users_id = "+user_id+"\n"+
                   "group by Bills_id"
            );
            while(rs.next())
            {
                bills.add(getBill(Integer.parseInt(rs.getString("Bills_id"))));
            }
            rs.close();
            return bills;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return bills;
    }
    
    // getCreatedBills: int -> List<Bill>
    // input: the user id
    // output: A list of Bills the user particpated in on success, null on 
    //         failure.
    // example: getCreatedBills(1) -> [new Bill(1, 'Test', '', 06/28/2018)]
    public List<Bill> getCreatedBills(int user_id)
    {
        List<Bill> bills = new ArrayList<Bill>();
        try{
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                   "select *\n" +
                   "from Bills\n" +
                   "where Paid_By = "+user_id+"\n"+
                   "group by Bills_id"
            );
            while(rs.next())
            {
                bills.add(getBill(Integer.parseInt(rs.getString("Bills_id"))));
            }
            rs.close();
            return bills;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return bills;
    }
    
    // getUserBudget: int -> int
    // input: the user id
    // output: the user's current budget on success, -1 on failure or if budget
    //         is not set.
    //example: getUserBudget(1) -> 100.00
    float getUserBudget(int user_id)
    {
        try
        {
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "select Budget\n" +
                    "from Users\n" +
                    "where Users_id = "+ user_id +";"
            );
            if(rs.next())
            {
                return Float.parseFloat(rs.getString("Budget"));
            }
            rs.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    // setBudget: Float int -> int
    // input: the new budget adn the user id
    // output: 1 on successfully updating the budget for the said user, -1 on 
    //         failure.
    // example: setBudget(100.0) -> 1
    public int setBudget(float budget, int user_id)
    {
        try{
            Connection con = dbc.getConnection();
            String query = "UPDATE USERS SET Budget = ? \n "+
                           "WHERE Users_id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setFloat(1, budget);
            preparedStmt.setInt(2, user_id);
            preparedStmt.execute();
            return 1;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
    
    // getBalances: int -> List<Balances>
    // input: the user's id
    // output: a list of balance instances, representing the amount the given
    //         users owes and to who do they owe that amount.
    // example: getBalances(1) -> [new Balances(3, 11.1)]
    public List<Balance> getBalances(int user_id)
    {
        List<Balance> b = new ArrayList<Balance>();
        try{
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "select Paid_By as 'User_id', Round(Sum(Amount),2) as 'Balance'\n" +
                    "from ledger right join share using(Bills_id, Item_id) join Bills using(Bills_id)\n" +
                    "where Users_id = "+ user_id +" and Paid_By <> "+ user_id +" and Is_Paid <> 1\n" +
                    "group by Paid_By;"
            );
            while(rs.next())
            {
                b.add(new Balance(
                        Integer.parseInt(rs.getString("User_id")),
                        Float.parseFloat(rs.getString("Balance")))
                );
            }
            return b;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return b;
    }
    
    // andTheyOweMe: int int -> int
    // input: the user ids of the creditor and the debtor
    // output: the amount the debtor owes to the credtior.
    //  example: andTheyOweMe(1, 3) -> 55.55
    public float andTheyOweMe(int creditor_id, int debtor_id)
    {
        try
        {
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "select COALESCE(Round(Sum(Amount),2),0) as 'Balance'\n" +
                    "from ledger right join share using(Bills_id, Item_id) join Bills using(Bills_id)\n" +
                    "where Users_id = "+ debtor_id +" and Paid_By = "+ creditor_id +" and Is_Paid <> 1"
            );
            if(rs.next())
            {
                return Float.parseFloat(rs.getString("Balance"));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }
    
    // clearDebt: int int -> int
    // input: the user id and the user id of the creditor.
    // output: 1 on succesfully clearing all debts the said user has against 
    //         the given creditor, -1 of failure.
    // example: clearDebt(1, 3) -> 1
    public int clearDebt(int user_id, int creditor_id)
    {
        List<SharedItems> items = fetchItems(user_id, creditor_id);
        items.addAll(fetchItems(creditor_id, user_id));
        if(items.size() <= 0 )
            return -1;
        l1: for(int i=0;i<items.size();i++)
        {
            System.out.println("ItemsID = "+items.get(i).getItemId()+" UserId= " +items.get(i).getUsersId()+ " Bills_id =" +items.get(i).getBillsId());
            if(payForItem(
                            items.get(i).getItemId(),
                            items.get(i).getUsersId(),
                            items.get(i).getBillsId()
                        ) == -1)
                return -1;
        }
        return 1;
    }
    
    public int payForItem(int item_id, int user_id, int bill_id)
    {
        try{
            Connection con = dbc.getConnection();
            String query = "UPDATE SHARE SET Is_Paid = 1 \n "+
                           "WHERE Users_id = ? and Item_id = ? and bills_id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, user_id);
            preparedStmt.setInt(2, item_id);
            preparedStmt.setInt(3, bill_id);
            preparedStmt.execute();
            return 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    
    // fetchItems: int int -> List<SharedItems>
    // input; the user id of the debtor and the user id of the creditor
    // output: 1 on successluffly returning all the items that the debtor needs
    //         to pay for.
    // example: fetchItems(1, 3) -> [new SharedItems(1, 1, 1)];
    public List<SharedItems> fetchItems(int debtor_id, int creditor_id)
    {
        List<SharedItems> i = new ArrayList<SharedItems>();
        try{
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "select Bills_id, Item_id, Users_id\n" +
                    "from Share join Bills using(Bills_id)\n" +
                    "where Users_id = "+ debtor_id +" and Paid_By = "+ creditor_id +""
            );
            while(rs.next())
            {
                i.add(new SharedItems(
                        Integer.parseInt(rs.getString("Users_id")),
                        Integer.parseInt(rs.getString("Bills_id")),
                        Integer.parseInt(rs.getString("Item_id"))
                    ));
            }
            return i;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return i;
    }
    
    // getDataSetFor: int -> List<DataSetItem>
    // input: user id of a user
    // output: list of DataSetItem that the user paid for/is included in.
    // example : getDataSetFor(1) -> [("Item 1", 5.55), ("Item 2", 11.55)]
    public List<DataSetItem> getDataSetFor(int user_id)
    {
        List<DataSetItem> items = new ArrayList<DataSetItem>();
        try{
            Connection con = dbc.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "select Name, Amount\n" +
                    "from Share join Ledger using(Bills_id, Item_id) join Bill_Items using(Bills_id, Item_id)\n" +
                    "where Users_id = " + user_id
            );
            while(rs.next())
            {
                items.add(new DataSetItem(
                        rs.getString("Name"),
                        Float.parseFloat(rs.getString("Amount")))
                    );
            }
            return items;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return items;
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
