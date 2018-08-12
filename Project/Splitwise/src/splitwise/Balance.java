// A Balance Instance represents the total money a user owes to all other users.

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
    // getUserId: void -> int
    // returns: the user_id
    // example: new Balance(1, 12).getUserId() -> 1
    int getUserId()
    {
        return this.user_id;
    }
    // getBalance(): void -> float
    // Returns: user's balance
    // example: new Balance(1, 12).getBalance -> 12.0
    float getBalance()
    {
        return this.balance;
    }
}
