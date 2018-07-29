package splitwise;

import java.util.Date;

public class Bills implements Bill
{
    String name, description;
    int bill_id, paid_by;
    Date date;
    
    Bills(int bill_id, String name, Date date, String description, int paid_by)
    {
        this.bill_id = bill_id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.paid_by = paid_by;
    }
    
    @Override
    public int getBillId() {
        return bill_id;
    }

    @Override
    public String getBillName() {
        return name;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public int getPaidBy() {
        return paid_by;
    }

    @Override
    public String getDescription() {
        return description;
    }
    
}