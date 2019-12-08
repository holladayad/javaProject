
package javaProject;

// Created By: Amber Holladay
public class ValueGuest extends Guest
{
    private String valueClubID;
    private int numberOfBookings;
    private double amountSpentWithHotel;
    
    // Constructor
    public ValueGuest(String username, String password, String guestName)
    {
        super(username,password,guestName);
        
        this.valueClubID= "";
        this.numberOfBookings=0;
        this.amountSpentWithHotel=0.0;
    }
   //getAmountSpentWithHotel 
   public double getAmountSpentWithHotel(){
       return this.amountSpentWithHotel;
   }
   
    //getNumberOfBookings
   public int getNumberOfBookings(){
       return this.numberOfBookings;
   }
    
   // getSavingsNumber
    public String getSavingsNumber(){
        return this.valueClubID;
    }
}
