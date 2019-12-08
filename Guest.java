
package javaProject;
import java.util.*;

public class Guest {
public static ArrayList<Guest> guestAccounts = new ArrayList();
   // Non-Static Data Fields
   private int guestID;
   private String username;
   private String password;
   private String guestName;
   
   // Static Data Fields
   public static int nextID = 0;
    
   //Guest class constructor
   public Guest(String username, String password, String guestName)
   {
       this.username = username;
       this.password = password;
       this.guestName = guestName;
       this.guestID = nextID++;
       guestAccounts.add(this);
   }
   
   // checkCredentials class
   public boolean checkCredentials(String username, String password)
   {
       boolean correct = false;
       if (this.username.equals(username)) 
              if(this.password.equals(password))
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
   
   // Setter for GuestName
   public void setGuestName(String guestName)
   {
       this.guestName = guestName;
   }
   
   // Setter for setPassword
   public int setPassword(String oldP, String newP) 
   {
      int set;
      if ((oldP != newP) && newP.length() > 0)
      {
       this.password = newP;
       set = 1;
      }
      else 
         set = 0;
      return set;
    
    }
}


