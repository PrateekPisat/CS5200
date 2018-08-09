package splitwise;

public class DataSetItem 
{
    float cost;
    String name;
    
    // Constructor
    public DataSetItem(String name, float cost)
    {
        this.name = name;
        this.cost = cost;
    }
    
    // Returns name of the item
    String getName(){return this.name;}
    
    // Returns the cost of the item
    float getCost(){return this.cost;}
}
