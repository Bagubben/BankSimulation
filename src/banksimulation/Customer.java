package banksimulation;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public final class Customer
{
    private final String name;
    private final String accountList;
    private final long personalNumber;
   
    
    ArrayList<SavingsAccount> storeSavingAccountList = new ArrayList<SavingsAccount>();
    ArrayList<CreditAccount> storeCreditAccountList = new ArrayList<CreditAccount>();
    ArrayList<Transaction> storeTransactionList = new ArrayList<Transaction>();

    Customer(String name, String accountList, long personalNumber) throws FileNotFoundException
    {
        this.name = name;
        this.accountList = accountList;
        this.personalNumber = personalNumber;
        createAccountsList(personalNumber);
    }

    
    
     void createAccountsList(long ssn) throws FileNotFoundException
    {
        PrintStream p = new PrintStream(new BufferedOutputStream(new FileOutputStream(ssn + "Savings.txt")));
        p = new PrintStream(new BufferedOutputStream(new FileOutputStream(ssn + "Credit.txt")));
        p = new PrintStream(new BufferedOutputStream(new FileOutputStream(ssn + "Transaction.txt")));
        p.close();
    }

    public void addStoreSavingAccountList()
    {
        storeSavingAccountList.add(new SavingsAccount());
    }

    public void addStoreCreditAccountList()
    {
        storeCreditAccountList.add(new CreditAccount());
    }
    
    public void addStoreTransactionList()
    {
        storeTransactionList.add(new Transaction());
    }

    public ArrayList<SavingsAccount> getStoreSavingAccountList()
    {
        return storeSavingAccountList;
    }

    public ArrayList<CreditAccount> getStoreCreditAccountList()
    {
        return storeCreditAccountList;
    }

    public ArrayList<Transaction> getStoreTransactionList()
    {
        return storeTransactionList;
    }
    
    void print()
    {
        System.out.println(this.accountList + "");
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