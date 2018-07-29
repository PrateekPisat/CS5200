
package splitwise;
class Item
{
    private int id;
    private String Name;
    public Item(int id, String Name)
        {
            this.id = id;
            this.Name = Name;
        }

        public int getId()
        {
            return id;
        }

        public String getName()
        {
            return Name;
        }

        public String toString()
        {
            return Name;
        }
    }
