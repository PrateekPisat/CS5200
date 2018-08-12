// A BillItem instance represents an item in a particular bill.
package splitwise;

public class BillItem 
{
    int id;
    String name;
    float cost;
    
    // constructor
    protected BillItem(int id, String name, float cost)
    {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }
    
    //getters
    // itemId : void -> int
    // returns: the id if the item.
    // example: new BillItem(1, "Item1", 12.2).itemId() -> 1
    int itemId()
    {
        return this.id;
    }
    
    // getItemName: void -> String
    // returns: the name of the item
    // example: new BillItem(1, "Item1", 12.2).getItemName() -> "Item1"
    String getItemName()
    {
        return this.name;
    }
    
    // getItemCost: void -> int
    // returns: the cost of the item.
    // example: new BillItem(1, "Item1", 12.2).getItemCost() -> 12.2
    float getItemCost()
    {
        return this.cost;
    }
}
