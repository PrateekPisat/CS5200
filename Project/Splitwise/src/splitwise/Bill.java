package splitwise;

import java.util.Date;

public interface Bill 
{
    int getBillId();
    
    String getBillName();
    
    Date getDate();
    
    int getPaidBy();
    
    String getDescription();
}
