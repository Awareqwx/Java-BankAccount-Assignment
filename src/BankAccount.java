import java.util.Random;

public class BankAccount
{
    
    private String accountNumber;
    private double checking, savings;
    
    private static int created;
    private static double sumOfAll;
    
    private Random r;

    public BankAccount()
    {
        // TODO Auto-generated constructor stub
        r = new Random();
        accountNumber = getRandomAcctNum();
        checking = savings = 0;
        created ++;
    }
    
    private String getRandomAcctNum()
    {
        String num = "";
        for(int i = 0; i < 10; i++)
        {
            num += r.nextInt(10);
        }
        return num;
    }
    
    public double getChecking()
    {
        return checking;
    }
    
    public double getSavings()
    {
        return savings;
    }
    
    /**Deposits money into either checking or savings
     * @param amt The amount to deposit to the balance
     * @param isChecking Set to true to deposit into checking, set to false to deposit into savings
     */
    public void deposit(double amt, boolean isChecking)
    {
        if(isChecking)
        {
            checking += amt;
        }
        else
        {
            savings += amt;
        }
        sumOfAll += amt;
    }
    
    /**
     * Withdraws money from either the checking or savings balance
     * @param amt The amount to withdraw from the balance
     * @param isChecking Set to true to withdraw from checking, set to false to withdraw from savings
     * @return True if withdrawal completed successfully, false if not
     */
    public boolean withdraw(double amt, boolean isChecking)
    {
        if(isChecking)
        {
            if(checking < amt)
            {
                return false;
            }
            checking -= amt;
        }
        else
        {
            if(savings < amt)
            {
                return false;
            }
            savings -= amt;
        }
        sumOfAll -= amt;
        return true;
    }
    
    /**
     * Returns the combined checking and savings balances
     * @return The combination of checking and savings
     */
    public double total()
    {
        return checking + savings;
    }

}
