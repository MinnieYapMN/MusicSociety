/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamaintenance;
import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author Ren
 */
public class NewEvent {
  
    public static void main(String []args){
            
        
        int no;
        String title,time,loc,desc,date;
        double fee;
        
        
        Scanner eNo= new Scanner(System.in);
        Scanner getTitle = new Scanner(System.in);
        Scanner getTime = new Scanner(System.in);
        Scanner getLoc = new Scanner(System.in);
        Scanner getDesc = new Scanner(System.in);
        Scanner getDate = new Scanner(System.in);
        Scanner getFee = new Scanner(System.in);
        
        
        System.out.println("===== Add New Event =====");
        System.out.println("1. Event NO ");
        no = eNo.nextInt();
        System.out.println("2. Event Title ");
        title = getTitle.nextLine();
     
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
          
    }
    
    
}
