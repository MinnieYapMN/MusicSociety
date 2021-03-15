/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.*;


/**
 *
 * @author Ren
 */
public class EventDetails {
    private int eventNo;
    private String title;
    private String date;
    private String time;
    private String location;
    private String description;
    private double fees;

    public EventDetails(int eventNo, String title, String date, String time, String location, String description, double fees) {
        this.eventNo = eventNo;
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.fees = fees;
    }

   

    public int getEventNo() {
        return eventNo;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public double getFees() {
        return fees;
    }

    public void setEventNo(int eventNo) {
        this.eventNo = eventNo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
//        return "Event{" + "eventNo=" + eventNo + ", title=" + title + ", date=" + date + ", time=" + time + ", location=" + location + ", description=" + description + ", fees=" + fees + '}';
     return String.format("%-4s %-4s %-4s %-2s %-8s %-8s %-6s ",eventNo,title,date,time,location,description,fees);
                
    }


    
    
    
    
    
    
    
    
}
