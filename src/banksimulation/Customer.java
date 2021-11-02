package banksimulation;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Customer
{
    private final String name;
    private final String accountList;
    private final long personalNumber;
    ArrayList<SavingsAccount> storeSavingAccountList = new ArrayList<SavingsAccount>();
    ArrayList<CreditAccount> storeCreditAccountList = new ArrayList<CreditAccount>();

    Customer(String name, String accountList, long personalNumber)
    {
        this.name = name;
        this.accountList = accountList;
        this.personalNumber = personalNumber;
    }

    private void storeSavingAccountList()
    {
        storeSavingAccountList.add(new SavingsAccount());
    }

    private void storeCreditAccountList()
    {
        storeCreditAccountList.add(new CreditAccount());
    }

    private void fileOutPut() throws FileNotFoundException
    {
        String message = "a";
        PrintStream p = new PrintStream(new BufferedOutputStream(new FileOutputStream("Accounts.txt")));
        p.println(message);
        p.close();
    }

    public String getName()
    {
        return name;
    }

    public String getAccountList()
    {
        return accountList;
    }
    
    public long getPersonalNUmber()
    {
        return personalNumber;
    }
            
            
            

}



//
////2.3 Customer
//Klassen Customer ska hantera följande information:
//• kundens namn
//• personnummer
//• en lista med kundens alla konton.
