
/*
Author: Mostar Park
Date: November 18, 2019
Assignment: Group Project
Purpose: Cross table to reference Room and Guest.
*/

package javaProject;

import java.util.ArrayList;

public class Booking {
	public static ArrayList<Booking> booked = new ArrayList();
    public Room bookedRoom;
    public Guest bookingGuest;
    public int bookingYear;
    public int checkInDay;
    public int checkOutDay;
    public static int nextID = 0;
    
    public Booking(Guest bookingGuest, Room bookedRoom, int year, int checkIn,
        int checkOut)
        {
            this.bookingGuest = bookingGuest;
            this.bookedRoom = bookedRoom;
            this.bookingYear = year;
            this.checkInDay = checkIn;
            this.checkOutDay = checkOut;
            this.nextID++;
            this.bookedRoom.bookRoom();
            booked.add(this);
        }
    
    public int calculateDaysStayed()
        {
            int daysStayed = this.checkOutDay - this.checkInDay;
            if(daysStayed < 0)
            {
                daysStayed += 365;
            }
            return daysStayed;
        }
    
    public void endBooking()
    {
        this.bookedRoom.freeThisRoom();
    }
}