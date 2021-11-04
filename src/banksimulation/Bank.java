package banksimulation;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Bank {
    
    static ArrayList<Customer> customerList = new ArrayList<>();

    
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        addCustomer("Pelle", "Johansson", 198411090343L);
        addCustomer("Kajsa", "Svensson", 197411020243L);
        addCustomer("Göran", "Ormvråk", 195501015167L);
        
    }
    
    public static void addCustomer(String name, String lastName, long personalNumber) throws FileNotFoundException, IOException
    {
       Customer customer = new Customer(name, lastName, personalNumber);
       customerList.add(customer);
       addCustomerToFile(name, lastName, personalNumber);
    }
    
    public static void addCustomerToFile(String name, String lastName, long personalNumber) throws IOException
    {
        BufferedWriter bfWriter = new BufferedWriter(new FileWriter("CustomerList.txt", true));
        bfWriter.write(name + "," + lastName + "," + personalNumber + "\n");
        bfWriter.close();
    }
    
    public static void uppdateCustomerToFile() throws IOException
    {
        BufferedWriter bfWriter = new BufferedWriter(new FileWriter("CustomerList.txt"));
        
        for (Customer customer : customerList)
        {
            bfWriter.write(customer.getName() + "," + customer.getLastName()+ "," + customer.getPersonalNumber() + "\n");
        }
        bfWriter.close();
    }
}