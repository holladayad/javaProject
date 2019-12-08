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
    
    
    public RoomService (int roomServiceID, String description, double price)
    {
        this.description = description;
        this.price = price;
        service.add(this);
        this.roomServiceID = nextID++;
        
    }
    
}
