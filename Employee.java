/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaProject;

/**
 *
 * @author Administrator
 */
import java.util.*;
public class Employee {
//	public static ArrayList<Employee> employeeAccounts = new ArrayList();
   private int employeeID;
   private String username;
   private String password;
   private String employeeName;
   private int error;
   
   public static int nextID = 0;
   
   public static ArrayList<Employee> employees = new ArrayList<Employee>();
   
   public Employee(String username, String password, String employeeName)
   {
       this.employeeName = employeeName;
       //this.password = password;
       this.username = username;
       this.employeeID = nextID++;
       employees.add(this);
       this.password = null;
       this.error = setPassword(password);
   }
   
   public boolean checkCredentials(String username, String password)
   {
       boolean correct = true;
       // change the order of passwords in the if statement to make 
       // sure it doesn't crash if the password is null
       if (this.username.equalsIgnoreCase(username) && password.equals(this.password))
       {
           return correct;
       }
       else
       {
           //System.out.println("Inccorect username or password!");
            return false;
       }
   }
   
   public String getEmployeeName()
   {
       return (this.employeeName = employeeName);
   }
   
   public int getEmployeeID()
   {
       return this.employeeID;
   }
   
   public String getPassword()
   {
       return this.password;
   }
   
   public String getUsername()
   {
       return (this.username = username);
   }
   
   public void setEmployeeName(String employeeName)
   {
       this.employeeName = employeeName;
   }
   
   
   public int getError()
   {
       return (this.error = error);
   }
   
   public int setPassword(String newPass)
   {
       String oldPass = this.password;
       boolean atLeastOneUpper = false;
       boolean atLeastOneLower = false;
       boolean atLeastOneNumber = false;
       
       // new password must be different than the old password
       int check = 0;
       

       if (newPass.equals(oldPass))
       {
           check = 1;
           
           
       }
       // check for number at start
       else if (Character.isDigit(newPass.charAt(0)))
                {
                    check = 2;   
                }
       else 
       {
           for (int i = 0; i < newPass.length(); i++)
           {
               if ((Character.isUpperCase(newPass.charAt(i))))
               {
                   atLeastOneUpper=true;
                   
                         
               }
               else if (Character.isLowerCase(newPass.charAt(i)))
               {
                   atLeastOneLower = true;
                   
               }
               // at least one number
               else if (Character.isDigit(newPass.charAt(i)))
               {
                   atLeastOneNumber = true;
                                    
               }
               
           
            }
        // checks if you did not find an uppercase. lowercase and a number
        if (!atLeastOneUpper){
            check = 3;
            } 
        else if (!atLeastOneLower){
            check = 4;
            }
        else if (!atLeastOneNumber){
            check = 5;
            }
        
        // will set to 6 if all requirements are met
        else{
            check = 6;
            this.password=newPass;
            }
       }
       
//       }
//       while(check != 6);
       
       //this.error = check;    
       return check;
   
       }
   
          
               
           
    
}