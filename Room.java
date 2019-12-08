package javaProject;

import java.util.ArrayList;

public class Room {
	public static ArrayList<Room> rooms = new ArrayList();
    public int bedOption;
    public int kitchenOption;
    public int coffeeOption;
    public int accessibleOption; 
    public int roomNumber; 
    private int roomID;
    private int roomBookQuantity; 
    private boolean roomBooked; 
    public double roomCostPerNight;
    public static int nextID = 0;
    public boolean active;
    
    public Room()
    {
    	this.active = true;
        this.bedOption = 0;
        this.kitchenOption = 0; 
        this.coffeeOption = 0;
        this.accessibleOption = 0; 
        this.roomNumber = 0;
        this.roomID = nextID++; 
        this.roomBookQuantity = 0;
        this.roomBooked = false; 
        this.roomCostPerNight = 0.0; 
        
    }
    
    public Room(int bedOption, int kitchenOption, int coffeeOption,
            int accessibleOption, int roomNumber)
    {
    	this.active = true;
        this.bedOption = bedOption;
        this.kitchenOption = kitchenOption;
        this.coffeeOption = coffeeOption;
        this.accessibleOption = accessibleOption; 
        this.roomNumber = roomNumber;
        this.roomID = nextID++; 
        this.roomBookQuantity = 0;
        this.roomBooked = false; 
        this.roomCostPerNight = 0.0; 
        rooms.add(this);
        
    }
    // Added
    public boolean isBooked() {
    	return this.roomBooked;
    }
    public boolean bookRoom()
    {
        
        this.roomBooked = true;
      
        roomBookQuantity++;
        return this.roomBooked;
    }
    
    public void freeThisRoom()
    {
        this.roomBooked = false;
    }
    //Added
    public void makeInactive() {
    	this.active = false;
    }
    //Added
    public void makeActive() {
    	this.active = true;
    }
    //Added
    public boolean isActive() {
    	return this.active;
    }
    
    public int getRoomBookedQuantity()
    {
        return this.roomBookQuantity;
    }
    
    public int getRoomID()
    {
        return this.roomID;
    }
    
    public int getRoomNumber()
    {
        return this.roomNumber;
    }
    
    
    public String roomAnalytics()
    {
        String analytics = ""; 
        analytics += "Room Number: " + this.roomNumber
                + "\n Number of Times Booked: " + this.roomBookQuantity
                + "\n Booked Status: " + this.roomBooked 
                + "\n Room is Active: " + this.active; 
        
        return analytics; 
    }
    
    public String roomDescription()
    {
        String description = "";
        String bedType = "";
        String kitchenType = "";
        String coffeeType = "";
        String accessibility = ""; 
        
        switch (this.bedOption)
        {
            case 1: bedType = "1 Queen Bed";
            break;
            case 2: bedType = "2 Queen Beds";
            break;
            case 3: bedType = "1 King"; 
        }
        
        switch (this.coffeeOption)
        {
            case 1: coffeeType = "1-Cup Std. Coffee Machine";
            break;
            case 2: coffeeType = "Keurig Hot K200 Machine";
            break;
        }
        
        switch (this.kitchenOption)
        {
            case 1: kitchenType = "Microwave";
            break;
            case 2: kitchenType = "Fridge & Microwave";
            break; 
        }
        
        switch (this.accessibleOption)
        {
            case 1: accessibility = "Standard Room";
            break;
            case 2: accessibility = "Enhanced Accessibility Room";
            break; 
        }
                
        description += "Room Number " + this.getRoomNumber()
                + "\n Bed(s): " + bedType
                + "\n Kitchen Equipment: " + kitchenType
                + "\n Coffee Machine: " + coffeeType
                + "\n Accessibility Options: " + accessibility; 
        
        return description; 
    }
    
    //not sure why this is supposed to return a boolean
    public boolean setRoomNumber(int roomNumber)
    {
       this.roomNumber = roomNumber;
       return true;
    }
   
            
    
    
    
    
}