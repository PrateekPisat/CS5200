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
    int itemId()
    {
        return this.id;
    }
    
    String getItemName()
    {
        return this.name;
    }
    
    float getItemCost()
    {
        return this.cost;
    }
}
