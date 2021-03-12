/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamaintenance;

import java.util.*;


/**
 *
 * @author Ren
 */
public class Event {
    private int eventNo;
    private String title;
    private String date;
    private String time;
    private String location;
    private String description;
    private double fees;

    public Event(int eventNo, String title, String date, String time, String location, String description, double fees) {
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
     return String.format("%-4s %-4s %-4s %-2s %-8s %-8s ",eventNo,title,date,time,location,description,fees);
                
    }
    
    
//  public static void main(String []args){
//            
//     EventLinkedStackInterface <Event> eventList = new EventLinkedStack();
////    private linkedStackInterface<Category> cat2 = new linkedStackSort();
//           
//        int no;
//        String title,time,loc,desc,date;
//        double fee;
//        
//        
//     
//        
//        Scanner eNo= new Scanner(System.in);
//        Scanner getTitle = new Scanner(System.in);
//        Scanner getTime = new Scanner(System.in);
//        Scanner getLoc = new Scanner(System.in);
//        Scanner getDesc = new Scanner(System.in);
//        Scanner getDate = new Scanner(System.in);
//        Scanner getFee = new Scanner(System.in);
//        
//        
//        System.out.println("===== Add New Event =====");
//        System.out.println("1. Event NO ");
//        no = eNo.nextInt();
//        System.out.println("2. Event Title ");
//        title = getTitle.nextLine();
////     
//        System.out.println("3. Event Date ");
//        date = getDate.nextLine();
//        
//        System.out.println("4. Event Time ");
//        time = getTime.next();
//        System.out.println("5. Location ");
//         loc = getLoc.nextLine();
//        System.out.println("6. Event Description ");
//         desc = getDesc.nextLine();
//        System.out.println("7. Fees ");
//         fee= getFee.nextDouble();
//         
//         Event event = new Event(no,title,date,time,loc,desc,fee);
//         eventList.push(event);
//         
////          EventLinkedStackInterface <Event> eventList = new EventLinkedStack();
//         
//     
//    }


    
 
    
    
    
    
    
    
}
