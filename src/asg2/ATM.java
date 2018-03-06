/*
 * To change this license header, choose License Headers in Project Properties.  
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asg2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author zack and kiara
 */

public class ATM 
{

    private Account[] myAcct = new Account[3];
   

    public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException
    {
        
        Scanner sc = new Scanner(System.in);
        String input;
        
        ATM a1 = new ATM();
        System.out.println("Do You Wish To Load Account?(Yes or No)");
        input=sc.next();
        if(input.equalsIgnoreCase("yes"))
        {
            a1.loadAcct();
        }
        else
        {
            a1.populateAccts();
        }
    }

    public void populateAccts() throws ParseException, FileNotFoundException, IOException 
    {  
        for (int i = 0; i< 3;i++)
        {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Enter account" + " " + (i + 1) + " " + "name");
                    String input = sc.nextLine();
                    
            myAcct[i] = new Account();
            myAcct[i].accountName = input;
            
        }
        pickAcct();

    }

    public void loadAcct() throws IOException, ParseException
    {
        
                Scanner sc = new Scanner(System.in);
            
            
		try
		{
                    FileInputStream fis = new FileInputStream("file.txt");
                    
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    
                    myAcct = (Account[])ois.readObject();
                    
                    fis.close();
		}
		catch (Throwable e)
		{
			System.err.println(e);
		}   
                
             String input1;
    do {

            
            String input;
            
            System.out.println("Please Choose One of the Following Accounts");
            
            for (int i = 0; i < 3; i++) 
            {
                System.out.println(myAcct[i].accountName);
            }
                        input = sc.next();
                
            for (int i = 0; i < 3; i++) 
            {
                if (myAcct[i].accountName.equalsIgnoreCase(input)) 
                {
                    myAcct[i].transMenu();
                    break;
                }
            }
            
            System.out.println("Enter 'Y' to choose a differnt account or 'N' to Exit");
                input1 = sc.next();
                
        } while (input1.equalsIgnoreCase("y"));
		
        
     
        System.out.println("Do you want to Save account (Y/N)? ");
        
        String input2 = sc.next();
        
        if(input2.equalsIgnoreCase("Y"))
        {
            saveAcct();
        }
        else
        {
            
        }
        
     }
    
    public void pickAcct() throws ParseException
    {

        String input1;
        do {

            Scanner sc = new Scanner(System.in);
            
            String input;
            
            System.out.println("Please Choose Your Account");
            
            for (int i = 0; i < 3; i++) 
            {
                System.out.println(myAcct[i].accountName);
            }
            
                input = sc.next();
                
            for (int i = 0; i < 3; i++) 
            {
                if (myAcct[i].accountName.equalsIgnoreCase(input)) 
                {
                    myAcct[i].transMenu();
                    break;
                }
            }
            
            System.out.println("To Choose a Different Account Press 'Y' or Press 'N' to Exit");
                input1 = sc.next();
                
        } while (input1.equalsIgnoreCase("Y"));
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Do you want to Save account (Y/N)? ");
        String input2 = sc.next();
        
        if(input2.equalsIgnoreCase("Y"))
        {
            saveAcct();
        }
        
        else
        {
            
        }
     }
    
    
    public void saveAcct()
    {
        try
		{
        		FileOutputStream fos = new FileOutputStream("file.txt");
                        
        		ObjectOutputStream oos = new ObjectOutputStream(fos);
        		
			oos.writeObject(myAcct);
                        
        		oos.flush();
                        
        		fos.close();
        	}
        	catch (Throwable e)
		{
        		System.err.println(e);
        	}
        System.out.println("Acconts have been saved");
      
    }
}
