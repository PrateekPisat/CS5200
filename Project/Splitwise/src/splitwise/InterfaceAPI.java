package splitwise;

import java.sql.Timestamp;
import java.util.List;
import java.util.Vector;

public interface InterfaceAPI
{
    // login: String String -> Int
    // Input: the email and the password
    // Output: The user's id on success, -1 of failure.
    // Example: login("Alice", "Password") -> 1
    public int login(String email, String pass);
    
    // register: String, String, String, String,Int -> Int
    // Input: The new user's name, email, password, phone, access previlleges.
    // Output: 1 on success, -1 on failure.
    // Example: register("Bob", "bob@example.com", "Password", "1234567890", 0) -> 1
    public int register(String name, String email, String pass, String phone);
// updateUser: int ,String, String, String, String,Int -> Int
    // Input: The new user's name, email, password, phone, access previlleges.
    // Output: 1 on success, -1 on failure.
    // Example: updateUser(2, "Bob", "bob@example.com", "Password", "1234567890", 0) -> 1
    public int updateUser(int user_id, String name, String email, String pass, String phone);
    
    // getAllUsers: void -> List<User>
    // output: returns a list of all the registered users except the given user
    // example: getAllUsers(2) -> [new Users("1", "Alice", "alice@example.com", "Password", "791231233", 100)]
    public List<User> getAllUsers(int user_id);
    
    // getUser: int -> User
    // input: user if of the user.
    // output: The user with the provided user id on success, null on failure.
    // example: getUser(1) -> new Users(1, "Alice", "alice@exmaple.com", "Password", "1234567890", 0)
    public User getUser(int user_id);
    
    // deleteUser: int -> int
    // input: the user's id
    // output: 1 on successful deletion, -1 on failure
    // example: deletUser(1) -> 1
    public int deleteUser(int user_id);
    
    // getUserName: int -> String
    // input: user id for a  user
    // output: The name of the said user on success, null on failure.
    // example: getUserName(1) -> "Alice"
    String getUserName(int user_id);
    
    // getCredit: int -> float
    // input: the user id of a user
    // output: the amount of money all other users owe the given user on success,
    //          -1 on fialure.
    // example: getCredit(1) -> 11.12
    float getCredit(int user_id);
    
    // getDebit: int -> float
    // input: the user id of a user
    // output: the sum of amount of money the given user owes all other
    //         user on success, -1 on fialure.
    // example: getCredit(1) -> 0
    float getDebit(int user_id);
    
    // createBill: String, String, int, Timestamp -> int
    // input: name, description, the id of the user who paid the bill, and 
    //        date when the bill was generated.
    // output: 1 if the bill was successfully created, -1 on failure.
    // example: createBill("Test", "This is a test bill", 1, 2018-08-06 06:25:44:123) -> 1
    public int createBill(String name, String Desc, int paid_by, Timestamp date);
    
    // updateBill: String, String, int, Timestamp -> int
    // input: name, description, the id of the user who paid the bill, and 
    //        date when the bill was generated.
    // output: 1 if the bill was successfully created, -1 on failure.
    // example: updateBill(1, "Test", "This is a test bill", 1, 2018-08-06 06:25:44:123) -> 1
     public int updateBill(int bill_id, String name, String Desc, int paid_by, Timestamp date);
    
    // getBill : int -> Bill
    // Input: Bill ID
    // Output: Bill associated with that bill id, if no bill is found, 
    //         returns NULL 
    //example: getBill(1) -> new Bill(1, "Stop-n-Shop Groceries", "2018-07-01 
    //                                03:36:00", 
    //                                "Groceries I brought at Stop n Shop", 1)
    Bill getBill(int id);
    
    // addItem() : Int, Int, String, Float -> Int
    // Input: the bill number, item number, item name, item cost
    // Effect: inserts an item.
    // Output: 1 on succesfull insertion of item, -1 on failure
    // Example: addItem(1, 1, "Bread", 2.03) -> 1
    public int addItem(int item_id, int bill_id, String name, float cost);
    
    // updateItem() : Int, Int, String, Float -> Int
    // Input: the bill number, item number, item name, item cost
    // Effect: updates an item.
    // Output: 1 on succesfull updation of item, -1 on failure
    // Example: updateItem(1, 1, "Bread", 2.03) -> 1
    public int updateItem(int item_id, int bill_id, String name, float cost);
    
    // deleteBill : int -> int 
    // Input: the bill id of the bill to be deleted.
    // Output: 1 on success, -1 on failure.
    // Effect: the said bill is deleted
    // Example: deleteBill(1) -> 1
    public int deleteBill(int bill_id);
    
    // getUserList : void -> Vector<Items>
    // Output: returns the a vector of items representing the user_id and their
    //         name.
    // Example: getUserList() -> [new Item(1, 'Alice'), new Item(2, 'Bob')]
    public Vector<Item> getUsersList();
    
    // sendRequest : int int -> int
    // Input: the bill id of the bill and user id of the user to who the 
    //        bill is to be sent.
    // Output: 1 on success, -1 on failure.
    // Example: sendRequest(1, 5) -> 1
    public int sendRequest(int bill_id, int user_id);
    
    // getPendingRequests : int -> int
    // Input: the user id of the user
    // Output: the number of pending bill requests on success, -1 on fialure.
    // Example: getPendingRequests(1) - > 1
    public int getPendingRequests(int user_id);
    
    // yetToAnswerRequests: int int -> int
    // input: the user_id of the creditor and debtor
    // output: the number of remaining bill requests for the bills shared amongst the
    //         the creditor and the debtor
    // example: yetToAnswerRequests(1) -> 1
    public int yetToAnswerRequests(int creditor_id, int debtor_id);
    
    // getBillRequestsFor : int -> List<Bill>
    // Input: user is for the user
    // Output: A list of bills on success
    // Example: getBillRequestsFor(1) -> [Bill1, Bill2]
    public List<Bill> getBillRequestsFor(int user_id);
    
    // deleteRequest : int int -> int
    // Input: bill id and the user id
    // Output: 1 on success, -1 on failure.
    // Example: deleteRequest(1, 2) -> 1
    public int deleteRequest(int bill_id, int user_id);
    
    // getBillItems: int -> List<BillItem>
    // Input: the id of the bill
    // Output: A list of items belonging to that bill.
    // Example: getBillItems(1) -> [new Item(1, "Bread", 2.41)];
    public List<BillItem> getBillItems(int bill_id);
    
    // getShare: int int int -> boolean
    // input : the user_id, the bill_id and the item_id
    // output: true if user is already included to share that item, else false.
    // example: getShare(1, 1, 1) -> true
    public boolean getShare(int user_id, int bill_id, int item_id);
    
    // addShare: int int int -> int
    // input: the user_id, the bill_id and the 
    // output: 1 on succesfull add a new share record, else -1
    // example: addShare(1, 1, 1, 0) -> 1
    public int addShare(int user_id, int bill_id, int item_id);
    
    // deleteShare: int int int -> int
    // input: the user_id, the bill_id and the 
    // output: 1 on succesfully deleting said share record, else -1
    // example: addShare(1, 1, 1) -> 1
    public int deleteShare(int user_id, int bill_id, int item_id);
    
    // updateLegder: int int -> int
    // input: the bill_id and item_id
    // output: 1 on successfully updating the cost of the item, -1 on failure.
    // example: updateLedger(1, 1) -> 1;
    public int updateLedger(int bill_id, int item_id);
    
    // getSharees: int int -> int
    // input: the bill_id and the the item_id
    // output: the number of users sharing the said item on suceess, -1 on 
    //         failure.
    // example: getSharees(1,1) -> 3
    int getSharees(int bill_id, int item_id);
    
    // getCost: int int -> float
    // input: the bill_id and the item_id
    // output: the cost of the said item on success, else -1 on failure.
    // example: getCost(1, 1) -> 5.83
    float getCost(int bill_id, int item_id);
    
    // getParticipatedBills: int -> List<Bill>
    // input: the user id
    // output: A list of Bills the user particpated in on success, null on 
    //         failure.
    // example: getParticipatedBills(1) -> [new Bill(1, 'Test', '', 06/28/2018)]
    public List<Bill> getParticipatedBills(int user_id);
    
    // getCreatedBills: int -> List<Bill>
    // input: the user id
    // output: A list of Bills the user particpated in on success, null on 
    //         failure.
    // example: getCreatedBills(1) -> [new Bill(1, 'Test', '', 06/28/2018)]
    public List<Bill> getCreatedBills(int user_id);
    
    // getUserBudget: int -> int
    // input: the user id
    // output: the user's current budget on success, -1 on failure or if budget
    //         is not set.
    //example: getUserBudget(1) -> 100.00
    float getUserBudget(int user_id);
    
    // setBudget: Float int -> int
    // input: the new budget adn the user id
    // output: 1 on successfully updating the budget for the said user, -1 on 
    //         failure.
    // example: setBudget(100.0) -> 1
    public int setBudget(float budget, int user_id);
    
    // getBalances: int -> List<Balances>
    // input: the user's id
    // output: a list of balance instances, representing the amount the given
    //         users owes and to who do they owe that amount.
    // example: getBalances(1) -> [new Balances(3, 11.1)]
    public List<Balance> getBalances(int user_id);
    
    // andTheyOweMe: int int -> int
    // input: the user ids of the creditor and the debtor
    // output: the amount the debtor owes to the credtior.
    // example: andTheyOweMe(1, 3) -> 55.55
    public float andTheyOweMe(int creditor_id, int debtor_id);
    
    // clearDebt: int int -> int
    // input: the user id and the user id of the creditor.
    // output: 1 on succesfully clearing all debts the said user has against 
    //         the given creditor, -1 of failure.
    // example: clearDebt(1, 3) -> 1
    public int clearDebt(int user_id, int creditor_id);
    
    public int payForItem(int item_id, int user_id, int bill_id);
    
    // fetchItems: int int -> List<SharedItems>
    // input; the user id of the debtor and the user id of the creditor
    // output: 1 on successluffly returning all the items that the debtor needs
    //         to pay for.
    // example: fetchItems(1, 3) -> [new SharedItems(1, 1, 1)];
    public List<SharedItems> fetchItems(int debtor_id, int creditor_id);
    
    // getDataSetFor: int -> List<DataSetItem>
    // input: user id of a user
    // output: list of DataSetItem that the user paid for/is included in.
    // example : getDataSetFor(1) -> [("Item 1", 5.55), ("Item 2", 11.55)]
    public List<DataSetItem> getDataSetFor(int user_id);
    
    // closeConnection
    // effect: closes the connection to the database
    // example: closeConnection();
    public void closeConnection();
}

