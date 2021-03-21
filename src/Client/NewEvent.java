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
             
        EventDetails e = new EventDetails(2008,"Music festival","22/12/2021","20:00-22:00","Live Stream","Please enter room early 10 mminutes",20.00);
        eventList.push(e);
        
//       
        e = new EventDetails(2009,"Singing Lession","19/11/2020","20:00-21:00","Google Meet Link","Lesson will conduct at monday and thursday end at 23/12/2020.(8 Lesson) ",100.00);
        eventList.push(e);
        
        e = new EventDetails(2010,"Advance Guitar Lesson","24/11/2020","18:00-19:00","Google Meet Link","Advance guitar lession teach by teacher Thiam every friday. Lesson end at 27/12/2020 (8 Lesson)",100.00);
        eventList.push(e);
        
        e = new EventDetails(2011,"Guitar Lesson","24/11/2020","19:30-20:30","Google Meet Link","Beginner guitar lession teach by teacher Thiam every friday. Lesson end at 27/11/2020 (8 Lesson)",100.00);
        eventList.push(e);
        
        e = new EventDetails(2012,"Music Night","22/01/2021","17:00-22:00","Google Meet Link","Visual welcome party for the new member. Performance by Senior member, Free for all member ",0.00);
        eventList.push(e);
      
        e = new EventDetails(2013,"Visual Music Fiesta","23/04/2021","19:00-21:00","Google Meet Link","Visual music concert for for all member. Guest performer： xxx ",65.00);
        eventList.push(e);
        
        e = new EventDetails(2014,"Music Sharing","26/03/2021","20:00","Google Meet Link","Music sharing between member. Member require to prepare song and share the story about the song in the event ",0.00);
        eventList.push(e);
    
        e = new EventDetails(2015,"OO Night","25/05/2021","20:00-22:00","Google Meet Link","Welcome party for new intake student. Only allow new intake student to join the party",25.00);
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
        System.out.println("2. .  Search Event List      .");
        System.out.println("3. .  Display All Event List .");
        System.out.println("4. .  Update Event List      .");
        System.out.println("5. .  Clear all Event List      .");
        System.out.println("6. .  Remove latest List      .");
        System.out.println("0. .  Exit program .");
        System.out.println(".....................................");
        
        menu = sNo.nextInt();
         switch(menu){
                case 1:
                    addNew();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    update();      
                    break;
                case 5:
                    clear();      
                    break;
                case 6:
                    Remove();      
                    break;
                case 0:
                    exit(0);
                default:
                    System.out.println("Invalid selection");
            }

        }while (menu !=7 || menu !=0);
        
        
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
        
      System.out.println("The latest event is " +eventList.peek());
    
        do{
            
        System.out.println("===== Add New Event =====");
//        System.out.println("1. Event NO " );
        System.out.println("1. Event NO "  + EventDetails.getNextEventNo());
        System.out.println("...............");
        no = EventDetails.getNextEventNo();
 
        System.out.println("2. Event Title ");
        System.out.println("...............");
        title = getTitle.nextLine();
//     
        System.out.println("3. Event Date ");
        System.out.println("...............");
        date = getDate.nextLine();
        
        System.out.println("4. Event Time ");
        System.out.println("...............");
        time = getTime.next();
        
        System.out.println("5. Location ");
        System.out.println("...............");
         loc = getLoc.nextLine();
         
        System.out.println("6. Event Description ");
        System.out.println(".....................");
        desc = getDesc.nextLine();
         
        System.out.println("7. Fees ");
        System.out.println(".........");
        fee= getFee.nextDouble();
        
         // push stack
         EventDetails event = new EventDetails(no,title,date,time,loc,desc,fee);
        eventList.push(event);

       
            System.out.println("Do you want add new details again? [Y|N]");
            select = Character.toUpperCase(slc.next().charAt(0));
       
            
         }while(select =='Y');
        }

    
    public static void clear(){
        char ans;
        Scanner anss = new Scanner(System.in);
        
        System.out.println("Are you sure want to clear all the list?");
        ans = Character.toUpperCase(anss.next().charAt(0));
        
       
        do{
            eventList.clear();
           
            menu();
        }while(ans == 'Y');
        
    }
    
    public static void update(){
        
        
         int no,insert,choose;
        String title,time,loc,desc,date,news;
        double fee;
//        char choose;
//        
        Scanner slc= new Scanner(System.in);
          Scanner eNo= new Scanner(System.in);
        Scanner getTitle = new Scanner(System.in);
        Scanner getTime = new Scanner(System.in);
        Scanner getLoc = new Scanner(System.in);
        Scanner getDesc = new Scanner(System.in);
        Scanner getDate = new Scanner(System.in);
        Scanner getFee = new Scanner(System.in);
         Scanner input = new Scanner(System.in);
      Scanner select = new Scanner(System.in);
  
//         for(int i=0; i < eventList.EventTotal(); i++){
////            if(news.equals(eventList.get(i).getTitle())){
//             if(insert  == eventList.get(i).getEventNo()){
         
        
        System.out.println("============= Update current Event =============");
        System.out.println("Please insert the Event title to update details ");
        insert = input.nextInt();
        System.out.println(".........");
      boolean check = false;
//        do{
        //get list
          for (int i = 0; i <eventList.EventTotal() ; i++) {
//              System.out.println(eventList.getEntry(i).getEventNo());
              //catch user input
            if(eventList.getEntry(i).getEventNo() == insert){
              
                System.out.println("1.Event No : " + eventList.getEntry(i).getEventNo());
                System.out.println("...........");
                
                System.out.println("Please select information to update");
                System.out.println("1. Event Title");
                System.out.println("2. Event Date");
                System.out.println("3. Event Time");
                System.out.println("4. Location");
                System.out.println("5. Event Description");
                System.out.println("6. Fees");
                System.out.println("7. Update Event List");
                System.out.println("------------------");
                choose = select.nextInt();
           
                
                
                
                if(choose == 1){
                     System.out.println("2. Event Title : " + eventList.getEntry(i).getTitle());
                System.out.println("..............");
                title = getTitle.nextLine();
                eventList.getEntry(i).setTitle(title);
                
                 
                System.out.println("Update successfully");
                System.out.println("=================================");
                }else if(choose == 2){
                     System.out.println("3. Event Date : " + eventList.getEntry(i).getDate());
                System.out.println("..............");
                date = getDate.nextLine();
                eventList.getEntry(i).setDate(date);
                
                 
                System.out.println("Update successfully");
                System.out.println("=================================");
                }else if(choose == 3){
                    System.out.println("4. Event Time : "+ eventList.getEntry(i).getTime());
                System.out.println("..............");
                time = getTime.next();
                eventList.getEntry(i).setTime(time);
                
                 
                System.out.println("Update successfully");
                System.out.println("=================================");
                }else if(choose == 4){
                      System.out.println("5. Location : "+ eventList.getEntry(i).getLocation());
                System.out.println("............");
                loc = getLoc.nextLine();
                eventList.getEntry(i).setLocation(loc);
                
                 
                System.out.println("Update successfully");
                System.out.println("=================================");
                }
                
                else if(choose == 5){
                                   System.out.println("6. Event Description : " + eventList.getEntry(i).getDescription());
                System.out.println(".....................");
                desc = getDesc.nextLine();
                eventList.getEntry(i).setDescription(desc);

                 
                System.out.println("Update successfully");
                System.out.println("=================================");
                }
                else if(choose == 6){
                System.out.println("7. Fees " + eventList.getEntry(i).getFees());
                fee= getFee.nextDouble();
                eventList.getEntry(i).setFees(fee);
                 
                System.out.println("Update successfully");
                System.out.println("=================================");
                }
                else if(choose == 7){
                       System.out.println("2. Event Title : " + eventList.getEntry(i).getTitle());
                System.out.println("..............");
                title = getTitle.nextLine();
                eventList.getEntry(i).setTitle(title);
                
               
                System.out.println("3. Event Date : " + eventList.getEntry(i).getDate());
                System.out.println("..............");
                date = getDate.nextLine();
                eventList.getEntry(i).setDate(date);
                
     
                System.out.println("4. Event Time : "+ eventList.getEntry(i).getTime());
                System.out.println("..............");
                time = getTime.next();
                eventList.getEntry(i).setTime(time);
                
                
                System.out.println("5. Location : "+ eventList.getEntry(i).getLocation());
                System.out.println("............");
                loc = getLoc.nextLine();
                eventList.getEntry(i).setLocation(loc);
                
               
                System.out.println("6. Event Description : " + eventList.getEntry(i).getDescription());
                System.out.println(".....................");
                desc = getDesc.nextLine();
                eventList.getEntry(i).setDescription(desc);

                System.out.println("7. Fees " + eventList.getEntry(i).getFees());
                fee= getFee.nextDouble();
                eventList.getEntry(i).setFees(fee);
                 
                System.out.println("Update successfully");
                System.out.println("=================================");
                }
                
                else {
                    display();
                }
               
                check = true;
                break;
            }
//               
           }if(!check){
                System.out.println("No record");
           }
            
//            System.out.println(eventList.getEntry(insert));
             
    
            display();
        }
            
       
         //new list 
//         System.out.println(eventList);
//          display();
       
//            System.out.println("Do you want to continue update ? ");
//             choose = Character.toUpperCase(slc.next().charAt(0));
//    }while( choose =='Y');
    
            
       
        
        
    
    
       
    
    public static void Remove(){
        
        System.out.println("Remove the latest details");
        eventList.pop();
        menu();
//      
        }
        
    
    public static void search(){
          int find;
        Scanner search = new Scanner(System.in);
//        
        System.out.println("Please enter the Event no ");
        find = search.nextInt();
        
        boolean fin =false;
         for (int i = 0; i <eventList.EventTotal(); i++) {
              if(eventList.getEntry(i).getEventNo() == find){
                System.out.println("1.Event No : " + eventList.getEntry(i).getEventNo());
                System.out.println("...........");
                
                System.out.println("2. Event Title : " + eventList.getEntry(i).getTitle());
                System.out.println("..............");
                

                System.out.println("3. Event Date : " + eventList.getEntry(i).getDate());
                System.out.println("..............");
                

                System.out.println("4. Event Time : "+ eventList.getEntry(i).getTime());
                System.out.println("..............");
             

                System.out.println("5. Location : "+ eventList.getEntry(i).getLocation());
                System.out.println("............");
                

                System.out.println("6. Event Description : " + eventList.getEntry(i).getDescription());
                System.out.println(".....................");
               
                System.out.println("7. Fees " + eventList.getEntry(i).getFees());
                fin = true;
//                break;
              }
             
    }
         if(!fin )
            System.out.println("No record");
//            else
//            System.out.println(eventList.getEntry(find));
              menu();
    }
    
       
//    }

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

    

