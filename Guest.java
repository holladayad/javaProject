
package javaProject;
import java.util.*;

public class Guest {
public static ArrayList<Guest> guestAccounts = new ArrayList();
   // Non-Static Data Fields
   private int guestID;
   private String username;
   private String password;
   private String guestName;
   private int error;
   // Static Data Fields
   public static int nextID = 0;
    
   //Guest class constructor
   public Guest(String username, String password, String guestName)
   {
       this.username = username;
       // this.password = password;
       this.guestName = guestName;
       this.guestID = nextID++;
       guestAccounts.add(this);
       this.password = null;
       this.error = setPassword(password);
   }
   
   // checkCredentials class
   public boolean checkCredentials(String username, String password)
   { 
       // change the order of the passwords in the if statement to make 
       // sure it doesn't crash if the password is null
       boolean correct = false;
       if (this.username.equals(username)) 
              if(password.equals(this.password))
                  correct = true;
              else 
                  correct = false;
       return correct;       
    }
       
   // Getter for GuestName
   public String getGuestName()
   {
       return this.guestName;
   }
   
   // Getter for UserName
   public String getUserName()
   {
       return this.username;
   }
   
   public String getPassword()
   {
       return this.password;
   }
   
   public int getError()
   {
       return this.error;
   }
   // Setter for GuestName
   public void setGuestName(String guestName)
   {
       this.guestName = guestName;
   }
   
   // Setter for setPassword
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


