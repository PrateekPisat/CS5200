package splitwise;

public class SharedItems {
    
    int users_id, bills_id, item_id;
    //constuctor
    SharedItems(int users_id, int bills_id, int item_id)
    {
        this.users_id = users_id;
        this.bills_id = bills_id;
        this.item_id = item_id;
    }
    
    int getUsersId()
    {
        return users_id;
    }
    int getBillsId()
    {
        return bills_id;
    }
    int getItemId()
    {
        return item_id;
    }
}
