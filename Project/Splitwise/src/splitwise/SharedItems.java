// A ShartedItems instance represents am item in a bill shared by a user.
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
    
    // getUsersId: void -> int
    // returns: the user's id.
    // example: new SharedItem(1, 2, 12).getUserId -> 1;
    int getUsersId() {return users_id;}
    
    // getBillsId: void -> int
    // returns: the bill's id.
    // example: new SharedItem(1, 2, 12).getBillsId -> 2;
    int getBillsId() {return bills_id;}
    
    // getItemId: void -> int
    // returns: the item's id.
    // example: new SharedItem(1, 2, 12).getItemId -> 12;
    int getItemId(){return item_id;}
}
