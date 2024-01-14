import java.util.*;

public class MultiUserATM
{
  public static class User
  {
      private String username;
      private int pin;
      private double balance;
      private List<String > transactionHistory;
    //initialize user
    public User(String username, int pin)
    {
      this.username= username;
      this.pin= pin;
      //intial balance
      this.balance= 500.00;
      this.transactionHistory= new ArrayList<>();
    }
    public String getUsername()
    {
        return username;
    }
    public int getPin()
    {
        return pin;
    }
    public double getBalance()
    {
        return balance;
    }
    public List<String> getTransactionHistory()
    {
        return transactionHistory;
    }
  }
}
