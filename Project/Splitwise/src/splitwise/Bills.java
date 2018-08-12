// A Bills instance implements interface bill represents a bill
package splitwise;

import java.util.Date;

public class Bills implements Bill
{
    String name, description;
    int bill_id, paid_by;
    Date date;
    
    //constructor
    Bills(int bill_id, String name, Date date, String description, int paid_by)
    {
        this.bill_id = bill_id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.paid_by = paid_by;
    }
    @Override
    // getBillId: void -> int
    // Returns: this bill's id
    // example: new Bills(1, "Test", "2018-08-11", "Test Bill", 1).getBillId() - > 1
    public int getBillId() {
        return bill_id;
    }

    @Override
    // getBillName: void -> String
    //returns: the name of this bill.
    // example: new Bills(1, "Test", "2018-08-11", "Test Bill", 1).getBillName() - > Test
    public String getBillName() {
        return name;
    }

    @Override
    // getDate: void -> Date
    // returns: the date this bill was created.
    // example: new Bills(1, "Test", "2018-08-11", "Test Bill", 1).getDate() - > 2018-08-11
    public Date getDate() {
        return date;
    }

    @Override
    // getPaidBy: void -> int
    // returns: this id of the user who paid for this bill.
    // example: new Bills(1, "Test", "2018-08-11", "Test Bill", 1).getPaidBy() - > 1
    public int getPaidBy() {
        return paid_by;
    }

    @Override
    // getDescrpition: void -> String
    // returns: the description of this bill
    // example: new Bills(1, "Test", "2018-08-11", "Test Bill", 1).getDescription() - > "Test Bill"
    public String getDescription() {
        return description;
    }
    
}