/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;
import ADT.EventLinkedStack;
import java.util.Scanner;
import ADT.EventLinkedStackInterface;
import Entity.Event;
import static java.lang.System.exit;

/**
 *
 * @author Ren
 */
public class NewEvent {



    
  public static void main(String []args){
            
     
//    private linkedStackInterface<Category> cat2 = new linkedStackSort();
           
       
//        int select;
        int menu = -1;
        Scanner sNo = new Scanner(System.in);
        
       do{
        System.out.println("====================================");
        System.out.println("=======Event List Details============");
        System.out.println("1. .  Add new Event details  .");
        System.out.println("2. .  Remove Event List      .");
        System.out.println("3. .  Display All Event List .");
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
                case 4:
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
        }while (menu !=4 || menu !=0);
        
        
        
        
      
    }
    public static void addNew(){
        EventLinkedStackInterface <Event> eventList = new EventLinkedStack<Event>();
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
           Event event = new Event(no,title,date,time,loc,desc,fee);
         eventList.push(event);
         
         System.out.println(eventList);
       
            System.out.println("Do you want add new details again?[Y|N]");
             select = Character.toUpperCase(slc.next().charAt(0));
        
            
         }while(select =='Y');
        }
   
      
//          System.out.println("Do you want add new details again?[Y|N]");
//             select = Character.toUpperCase(slc.next().charAt(0));
//             if (select !='Y' || select !='N'){
//                System.out.println("Invalid Input, Please enter [Y|N]");
//             }
     
        
         
              
         
         
         
//         System.out.println(event);
//         eventList.display();
         
        
//         
//          EventLinkedStackInterface <Event> eventList = new EventLinkedStack();
         
     
    
    
    public static void Remove(){
        addNew();
    }

  public static void display(){
        addNew();
    }

    
}
