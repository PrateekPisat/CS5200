package splitwise;

import java.util.Date;

public interface Bill 
{
    // getBillId: void -> int
    // Returns: this bill's id
    // example: new Bills(1, "Test", "2018-08-11", "Test Bill", 1).getBillId() - > 1
    int getBillId();
    
    // getBillName: void -> String
    //returns: the name of this bill.
    // example: new Bills(1, "Test", "2018-08-11", "Test Bill", 1).getBillName() - > Test
    String getBillName();
    
    // getDate: void -> Date
    // returns: the date this bill was created.
    // example: new Bills(1, "Test", "2018-08-11", "Test Bill", 1).getDate() - > 2018-08-11
    Date getDate();
    
    // getPaidBy: void -> int
    // returns: this id of the user who paid for this bill.
    // example: new Bills(1, "Test", "2018-08-11", "Test Bill", 1).getPaidBy() - > 1
    int getPaidBy();
    
    // getDescrpition: void -> String
    // returns: the description of this bill
    // example: new Bills(1, "Test", "2018-08-11", "Test Bill", 1).getDescription() - > "Test Bill"
    String getDescription();
}
