package banksimulation;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Bank {

    
    public static void main(String[] args) throws FileNotFoundException 
    {
        String message = "a";
        PrintStream p = new PrintStream(new BufferedOutputStream(new FileOutputStream("199706211111.txt")));
        p.println(message);
        p.close();
        
        
    }

}