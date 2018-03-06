/*
 * To change this license header, choose License Headers in Project Properties.  
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asg2;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author zack and kiara
 */

        public class Account implements Serializable 
        {
   
         private String inputDate2;
        
         double balance = 100;
       
        String accountName;
        
         private float rate = .05f / 365;
        
         private int daysDiff;
         
         private boolean dateFlag = false;
        
         private LocalDate date1, date2;
      

    public Account() 
    {
 
    }

    public void getDate1() 
    {
        if (dateFlag == false)
        { 
    date1 = LocalDate.now();
    dateFlag=true;
        }
    }

    public void getDate2() throws ParseException 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pleas Enter Today Date (yyyy-MM-dd)");
                   inputDate2 = sc.next();
                   
        date2 = LocalDate.parse(inputDate2);
        long temp = ChronoUnit.DAYS.between(date1, date2);
        daysDiff = (int) temp;
        
                //System.out.println(daysDiff);
        
        if(daysDiff<0)
        {
            System.out.println("No back Dataing allowed, Try again.");
            getDate2();
        }
        
    }

    public void calcInterest() 
    {
        double ratetime;
        
        ratetime = Math.pow(1 + rate, daysDiff);
        
        balance *= ratetime;
        
        date1 = date2;
        
        
            ////int datediff = seconddate - firstdate;
            ////
            ////rate = .10/365;
            ////
            ////double ratetime = Math.pow(1+rate,datediff);
            ////
            ////balance *= ratetime;
            ////
            ////firstdate = seconddate;
    }

    public void getBalance() 
    {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        
        System.out.println(currencyFormatter.format(balance));
        
        	// This method prompts the user for the deposit and then adds it to the
                // balance field.
    }

    public void deposit() 
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter deposit amount:");
        
                double deposit = sc.nextDouble();
                
        balance += deposit;
        
        	// This method prompts the user for the withdraw amount and then subtracts
                // it from the balance field.
    }

    public void withdraw() 
    {
        Scanner sc = new Scanner(System.in);
            
        System.out.println("Enter withdraw amount:");
        
        double withdraw = sc.nextDouble();
        
        if (withdraw > balance) 
        {
            System.out.println(" Can not withdraw");
        } 
        
        else 
        {
            balance -= withdraw;
        }

    }

    public void transMenu() throws ParseException
    {
        Scanner sc = new Scanner(System.in);
        
        int input = 0;

        while (input != 4) 
        {
         System.out.print("========================\n"
							 +"ATM Menu: \n \n"
							 + "1. Deposit Money \n"
							 + "2. Withdraw Money \n"
							 + "3. Check Account Balance\n"
							 + "4. End Session\n"
							 + "========================\n"
							 + "\nEnter selection: ");
            input = sc.nextInt();

            switch (input) //Switch Case for MENU
            {
                case 1: //Deposit
                {
                    getDate1();
                    
                    getDate2();
                    
                    calcInterest();
                    
                    deposit();
                    
                    break;
                }
                
                case 2: //Withdrawl
                {
                    getDate1();
                    
                    getDate2();
                    
                    calcInterest();
                    
                    withdraw();
                    
                    break;
                }
                
                case 3: //Check Bal
                {
                    getDate1();
                    
                    getDate2();
                    
                    calcInterest();
                    
                    getBalance();
                    
                    break;
                }
                
                case 4: //Quit 
               {
                    break;

                }
            }

        }
    }

}
