// A DataSetItem represents a item stored as its name and cost, used primarily,
// for displaying as a Pie-Chart.
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
    // example: new DataSetItem("Item1", 3.2).getName() -> "Item1"
    String getName(){return this.name;}
    
    // Returns the cost of the item
    // example: new DataSetItem("Item1", 3.2).getCost() -> 3.2
    float getCost(){return this.cost;}
}
