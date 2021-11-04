package banksimulation;


import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public  class Customer
{
    private final String name;
    private final String lastName;
    private final long personalNumber;
   
    
    ArrayList<SavingsAccount> savingAccountList = new ArrayList<SavingsAccount>();
    ArrayList<CreditAccount> creditAccountList = new ArrayList<CreditAccount>();
    ArrayList<Transaction> transactionList = new ArrayList<Transaction>();

    Customer(String name, String lastName, long personalNumber) throws FileNotFoundException
    {
        this.name = name;
        this.lastName = lastName;
        this.personalNumber = personalNumber;
        createAccountsList(personalNumber);
    }
    
     void createAccountsList(long personalNumber) throws FileNotFoundException
    {
        PrintStream p = new PrintStream(new BufferedOutputStream(new FileOutputStream(personalNumber + "Savings.txt")));
        p = new PrintStream(new BufferedOutputStream(new FileOutputStream(personalNumber + "Credit.txt")));
        p = new PrintStream(new BufferedOutputStream(new FileOutputStream(personalNumber + "Transaction.txt")));
        p.close();
    }

    public void addSavingAccountList() throws FileNotFoundException
    {
        savingAccountList.add(new SavingsAccount(0, personalNumber, lastName));
    }

    public void addCreditAccountList() throws FileNotFoundException
    {
        creditAccountList.add(new CreditAccount(0, personalNumber, lastName));
    }
    
    public void addTransactionList( int accountNumber, String accountType, double oldSum, double transactionSum, double newSum, String transactionType) throws IOException
    {
        Transaction t = new Transaction(accountNumber, accountType, oldSum, transactionSum, newSum, transactionType);
        transactionList.add(t);
        printToTransactionFile(personalNumber, t);
    }
    
     private void printToTransactionFile(long personalNumber ,Transaction t) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(personalNumber + "Transaction.txt", true));
        writer.write(t.getTransactionInfo() + "\n");
        writer.close();
    }

    public ArrayList<SavingsAccount> getSavingAccountList()
    {
        return savingAccountList;
    }

    public ArrayList<CreditAccount> getCreditAccountList()
    {
        return creditAccountList;
    }

    public ArrayList<Transaction> getTransactionList()
    {
        return transactionList;
    }
    
    void print()
    {
        System.out.println(this.lastName + "");
    }
    
    public String getName()
    {
        return name;
    }

    public String getLastName()
    {
        return lastName;
    }
    
    public long getPersonalNumber()
    {
        return personalNumber;
    }
    
}