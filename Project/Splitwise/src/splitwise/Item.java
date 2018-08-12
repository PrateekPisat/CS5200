// An Item instace represents a User with their Id and Name. This instance is 
// primarily used as a key-value tuple for the drop-down element in the SendBill
// form.
package splitwise;
class Item
{
    private int id;
    private String Name;
    // constructor.
    public Item(int id, String Name)
    {
        this.id = id;
        this.Name = Name;
    }

    // returns the Id of the Item(User)
    // example: new Item(1, "Alice").getId() -> 1
    public int getId()
    {
        return id;
    }
    
    // returns: the name of the item(User)
    // example: new Item(1, "Alice").getName() -> "Alice"
    public String getName()
    {
        return Name;
    }
    
    // returns: the name of the item(User)
    // example: new Item(1, "Alice").toString() -> "Alice"
    public String toString()
    {
        return Name;
    }
 }
