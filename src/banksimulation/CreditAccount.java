package banksimulation;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CreditAccount {
    
    private int personalNumber;
    private int accountNumber;
    private String accountType = "c";
    private double accountSum = 0;
    
     CreditAccount (int personalNumber, double accountSum, String accountType) throws FileNotFoundException
    {
        this.personalNumber = personalNumber;
        this.accountSum = accountSum;
        this.accountType = accountType;
        getAccountNumberFromFile();
    }

    CreditAccount()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    private void getAccountNumberFromFile() throws FileNotFoundException
    {
        Scanner in = new Scanner(new File("AccountNumber.txt"));
        String s = in.nextLine();
        int konto = Integer.parseInt(s);
        this.accountNumber = konto;
        PrintStream p = new PrintStream(new BufferedOutputStream(new FileOutputStream("AccountNumber.txt")));
        konto++;
        p.println(konto);
        p.close();

    }

    public double getAccountSum()
    {
        return accountSum;
    }

    public void setAccountSum(double accountSum)
    {
        this.accountSum = accountSum;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public String getAccountType()
    {
        return accountType;
    }
}