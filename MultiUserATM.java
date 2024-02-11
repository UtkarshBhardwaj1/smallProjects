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
     public void deposit(double amount) //function for deposit
        {
            if (amount > 0)
            {
                balance += amount;
                transactionHistory.add("Deposit: $" + amount);
            }
        }

        public boolean withdraw(double amount) //function for withdrawal
        {
            if (amount > 0 && amount <= balance)
            {
                balance -= amount;
                transactionHistory.add("Withdraw: $" + amount);
                return true;
            }
            return false;
        }

        public void transfer(User recipient, double amount) //function for amount transfer
        {
            if (amount > 0 && amount <= balance)
            {
                balance -= amount;
                recipient.deposit(amount);
                transactionHistory.add("Transfer to " + recipient.getUsername() + ": $" + amount);
            }
        }
    }

    private static List<User> users = new ArrayList<>();

    public static void main(String[] args)
    {
        // Create some user accounts
        User user1 = new User("Nayana", 1904);
        User user2 = new User("Pradhaan", 1369);
        User user3 = new User("John", 5395);
        User user4 = new User("Peter", 1102);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            User currentUser = authenticateUser(username, pin);

            if (currentUser != null)
            {
                performTransactions(scanner, currentUser);
            }
            else
            {
                System.out.println("Authentication failed. Please try again.");
            }
        }
    }

    private static User authenticateUser(String username, int pin) //function checks if the user exists 
    {
        for (User user : users)
        {
            if (user.getUsername().equals(username) && user.getPin() == pin)
            {
                return user;
            }
        }
        return null;
    }

 

