package splitwise;

public class Balance {
    int user_id;
    float balance;
    // constructor
    Balance(int user_id, float balance)
    {
        this.user_id = user_id;
        this.balance = balance;
    }
    // Returns the user id
    int getUserId()
    {
        return this.user_id;
    }
    // Returns balance
    float getBalance()
    {
        return this.balance;
    }
}
