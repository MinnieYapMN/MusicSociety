/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;
import ADT.*;
import java.util.Scanner;
import ADT.EventLinkedStackInterface;
import Entity.*;
import static java.lang.System.exit;

/**
 *
 * @author Ren
 */
public class NewEvent {

public static EventLinkedStackInterface <EventDetails> eventList = new EventLinkedStack<EventDetails>();
public EventDetails details;
    
  public static void main(String []args){
             
        EventDetails e = new EventDetails(2212,"Music festival","22/12/2021","20:00-22:00","Live Stream","Please enter room early 10 mminutes",20.00);
        eventList.push(e);
        e = new EventDetails(2312,"Music stadium","23/12/2021","8:00-17:00","Main Hall","Please show ur id card to entry the hall",25.00);
        eventList.push(e);
        
     menu();
        
        
      
    }
  
  public static void menu(){
         int menu = -1;
        Scanner sNo = new Scanner(System.in);
        
       do{
        System.out.println("====================================");
        System.out.println("=======Event List Details============");
        System.out.println("1. .  Add new Event details  .");
        System.out.println("2. .  Remove Event List      .");
        System.out.println("3. .  Display All Event List .");
        System.out.println("4. .  Update Event List      .");
        System.out.println("0. .  Exit program .");
        System.out.println(".....................................");
        
        menu = sNo.nextInt();
         switch(menu){
                case 1:
                    addNew();
                    break;
                case 2:
                    Remove();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    update();      
                    break;
                case 0:
                    exit(0);
                default:
                    System.out.println("Invalid selection");
            }
//        try{
//            switch(menu){
//                case 1:
//                    addNew();
//                    break;
//                case 2:
//                    Remove();
//                    break;
//                case 3:
//                    display();
//                default:
//                    System.out.println("Invalid selection");
//            }
//        }catch (Exception e){
////                 System.out.print("Press any button...");
////                sNo.nextInt();
//                }
        }while (menu !=5 || menu !=0);
        
        
  }
  
    public static void addNew(){
        
         int no;
        String title,time,loc,desc,date;
        double fee;
        char select;
        
        Scanner slc= new Scanner(System.in);
          Scanner eNo= new Scanner(System.in);
        Scanner getTitle = new Scanner(System.in);
        Scanner getTime = new Scanner(System.in);
        Scanner getLoc = new Scanner(System.in);
        Scanner getDesc = new Scanner(System.in);
        Scanner getDate = new Scanner(System.in);
        Scanner getFee = new Scanner(System.in);
        
      
    
        do{
            
        
        System.out.println("===== Add New Event =====");
        System.out.println("1. Event NO ");
        no = eNo.nextInt();
        System.out.println("2. Event Title ");
        title = getTitle.nextLine();
//     
        System.out.println("3. Event Date ");
        date = getDate.nextLine();
        
        System.out.println("4. Event Time ");
        time = getTime.next();
        System.out.println("5. Location ");
         loc = getLoc.nextLine();
        System.out.println("6. Event Description ");
         desc = getDesc.nextLine();
        System.out.println("7. Fees ");
         fee= getFee.nextDouble();
           EventDetails event = new EventDetails(no,title,date,time,loc,desc,fee);
         eventList.push(event);
         //new list 
//         System.out.println(eventList);
//          display();
       
            System.out.println("Do you want add new details again?[Y|N]");
             select = Character.toUpperCase(slc.next().charAt(0));
       
            
         }while(select =='Y');
        }
//   
//     public static void search(){
//        int insert;
//         Scanner input = new Scanner(System.in);
//           System.out.println("============= Update current Event =============");
//        System.out.println("Please inset the Event no to update details ");
//        insert = input.nextInt();
//        eventList.search(insert);
//         
//         
//     }
    
    
    
    public static void update(){
        
        
         int no,insert;
        String title,time,loc,desc,date,news;
        double fee;
        char choose;
        
        Scanner slc= new Scanner(System.in);
          Scanner eNo= new Scanner(System.in);
        Scanner getTitle = new Scanner(System.in);
        Scanner getTime = new Scanner(System.in);
        Scanner getLoc = new Scanner(System.in);
        Scanner getDesc = new Scanner(System.in);
        Scanner getDate = new Scanner(System.in);
        Scanner getFee = new Scanner(System.in);
         Scanner input = new Scanner(System.in);
      
  
        
        System.out.println("============= Update current Event =============");
        System.out.println("Please inset the Event no to update details ");
        news = input.nextLine();
//        insert = input.nextInt();
        boolean cat =false;
        for(int i=0; i < eventList.getDetails(); i++){
            if(news.equals(eventList.get(i).getTitle())){
//            if(eventList.search(insert)){
                System.out.println("Event No" + eventList.get(i).getEventNo());
                System.out.println("2. Event Title " + eventList.get(i).getTitle());
//        title = getTitle.nextLine();
//        eventList.get(i).setTitle(title);

    System.out.println("3. Event Date " + eventList.get(i).getDate());
//        date = getDate.nextLine();
//        eventList.get(i).setDate(date);

    System.out.println("4. Event Time "+ eventList.get(i).getTime());
//        time = getTime.next();
//        eventList.get(i).setTime(time);

    System.out.println("5. Location "+ eventList.get(i).getLocation());
//         loc = getLoc.nextLine();
//         eventList.get(i).setLocation(loc);

    System.out.println("6. Event Description " + eventList.get(i).getLocation());
//         desc = getDesc.nextLine();
//         eventList.get(i).setDescription(desc);
    System.out.println("7. Fees " + eventList.get(i).getFees());
//         fee= getFee.nextDouble();
//         eventList.get(i).setFees(fee);
    System.out.println("Update successfully");
//         EventDetails event = new EventDetails(no,title,date,time,loc,desc,fee);
//         eventList.push(event);
          cat= true;  
            break;} 
            
           
        }if(!cat)
            System.out.println("No record");
            else
       display();
        
         //new list 
//         System.out.println(eventList);
//          display();
       
//            System.out.println("Do you want to continue update ? ");
//             choose = Character.toUpperCase(slc.next().charAt(0));
       
            
       
        
        
    }
    
       
    
    public static void Remove(){
       eventList.pop();
    }

  public static void display(){
     int back;
      Scanner menu = new Scanner(System.in);
      do{
      eventList.display();
    
      System.out.println("Please press 0 to go back menu");
      back = menu.nextInt();
      menu();
      }while(back == 0);
      
   
 }
  }

    

