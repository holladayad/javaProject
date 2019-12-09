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
public class RoomService {
    
    public int roomServiceID;
    public String description;
    public double price;
    
    public static int nextID = 0;
    public static ArrayList<RoomService> service = new ArrayList();
    
    
    public RoomService (String description, double price)
    {
        this.description = description;
        this.price = price;
        service.add(this);
        this.roomServiceID = nextID++;
        
    }
    
    public int getRoomServiceID()
   {
       return this.roomServiceID;
   }
    
    public double getPrice()
   {
       return this.price;
   }
    public String getDescription()
   {
       return this.description;
   }
    
    public double calculateRoomServiceTotal()
    {
        
       double subTotal =0;
       for (int i = 0; i < RoomService.service.size(); i++)
            {
                
                subTotal += RoomService.service.get(i).price;
                               
            }
       return subTotal;
    }
    
}
