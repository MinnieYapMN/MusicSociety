/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import ADT.*;
import Entity.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Khau Wen Xuen 20WMR08920
 */
public class PaymentModule {

    public static ListInterface<Payment> paymentList = new ArrayList<>();

//    public static SetInterface<Event> memberEvent = new ArraySet<>();
    //  public static EventLinkedStackInterface<EventDetails> eventList = new EventLinkedStack<EventDetails>();
    //MemberListInterface<Member> memberList = new MemberLinkedList();
    // EventLinkedStackInterface<EventDetails> eventDList = new EventLinkedStack<EventDetails>();
    //MemberListInterface<Member> memList = new MemberLinkedList();
    //   public static EventLinkedStackInterface<EventDetails> eventDList = new EventLinkedStack<>();
//    public static LinkListInterface<Member> memberList;
//    public static LinkListInterface<Member> memList = new LinkList();
    public static Event event = null;

//    HashQuadDictionary<String, Developer> hashDev = new HashingImplement<>();
    public void initialize() throws ParseException {
        Date getDate = new Date();
        SimpleDateFormat Date = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat Time = new SimpleDateFormat("HH:mm:ssa");
        String date = Date.format(getDate);
        String time = Time.format(getDate);

//        event = new Event("0001", "Confirmed", eventDList, memList);
//        EventDetails e = new EventDetails(2212, "Music festival", "22/12/2021", "20:00-22:00", "Live Stream", "Please enter room early 10 mminutes", 20.00);
//        eventList.push(e);
//        e = new EventDetails(2312, "Music stadium", "23/12/2021", "8:00-17:00", "Main Hall", "Please show ur id card to entry the hall", 25.00);
//        eventList.push(e);
        //memList.add(memberList.getEntry(1));
        //  eventDList.push(eventList.getEntry(1));
//        memberEvent.add(new Event("0001", "Confirmed", eventDList, memList));
//        paymentList.add(new Payment(date, time, new Event("0001", "Confirmed", eventDList, memList)));
//        paymentList.add(new Payment(date, time, new Event("0001", "Confirmed", eventDList, memList)));
    }

    public static void paymentMenu() {
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        while (true) {
            try {
                System.out.println("\n====================");
                System.out.println("   PAYMENT MENU ");
                System.out.println("====================");

                System.out.println("1. View Payment History");
                System.out.println("2. Add Payment");
                System.out.println("3. Search payment");
                System.out.println("4. Refund Payment");
                System.out.println("5. Exit");
                System.out.print("\nPlease make your selection > ");
                int paymentSelection = input.nextInt();

                switch (paymentSelection) {
                    case 1:
                        displayPayment();
                        break;
                    case 2:
                        addPayment();
                        break;
                    case 3:
                        searchPayment();
                        break;
                    case 4:
                        refundPayment();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid input");

                        break;
                }
                if (exit) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e);

            }
        }

    }

    public static void displayPayment() {
        Scanner input = new Scanner(System.in);

        System.out.println(paymentList);

//        input.nextLine();
//        System.out.println("Refund payment? (1 = Yes, Any key to exit) > ");
//        int rpChoice = input.nextInt();
//        if(rpChoice == 1){
//            refundPayment();
//        }else{
//            paymentMenu();
//        }  
    }

    public static void addPayment() {
        Scanner input = new Scanner(System.in);
        //Category aPayment = new Category();
        // how to get last paymentNo, eventID, studID, totalamount details from event table

        //int pay = aPayment.getPaymentNo();
        //Category[] cat = new Category[];
        //int lastPaymentNo = Category[Category.length -1].getPaymentNo;
        Date getDate = new Date();
        SimpleDateFormat Date = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat Time = new SimpleDateFormat("HH:mm:ssa");
        String date = Date.format(getDate);
        String time = Time.format(getDate);
        boolean found = false;

        SetInterface<Event> memberEvent = Client.MusicSociety.memberEvent;
        //  EventLinkedStackInterface<EventDetails> eventList = Client.MusicSociety.eventList;
        System.out.print("Enter Register No > ");

        try {
            String regisNo = input.next();
            //double total = 100.99;

            for (int i = 0; i < memberEvent.getSize(); i++) {
                if (regisNo.equals((memberEvent.getEntry(i).getRegisNo()))) {
                    //if else
                    
                      //  if (!regisNo.equals(paymentList.getEntry(i).getEvent().getRegisNo())) {
                            //EventDetails tempE = memberEvent.getEntry(i).getEventD();
                            System.out.print(memberEvent.getEntry(i));
                            found = true;
                            System.out.print("\nEnter payment amount > ");
                            double paymentAmount = input.nextDouble();

                            boolean paid = false;
                            while (!paid) {
                                //  System.out.println(memberEvent.getEntry(i).getEventD().getFees());
                                if (paymentAmount >= memberEvent.getEntry(i).getEventD().getFees()) {
                                    double change = paymentAmount - memberEvent.getEntry(i).getEventD().getFees();
                                    System.out.printf("Change > %.2f\n", change);
                                    Payment pym = new Payment(date, time, memberEvent.getEntry(i));
                                    paymentList.add(pym);
                                    System.out.println("Payment Added");
                                    generateReceipt(pym, paymentAmount);
                                    paid = true;
                                } else {
                                    System.out.println("The payment amount should greater than total amount");
                                    System.out.print("Enter payment amount > ");
                                    paymentAmount = input.nextDouble();
                                }
                            }
//                        } else {
//                            System.out.println("Payment made for this regis no!");
//                        }
                    

                }
            }
            if (!found) {
                System.out.println("No such Register No. Please try again!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //remove the particular item from list
    public static void refundPayment() {
        //ListInterface<Payment> refPayment = new ArrayList<>();
        //refPayment = cat;
        //Payment aPayment = new Payment();
        //refPayment = new ArrayList<>();
        boolean found = false;
        Scanner input = new Scanner(System.in);

        try {
            displayPayment();
            System.out.println("Enter Payment No > ");
            int pNo = input.nextInt();
            for (int i = 1; i <= paymentList.getSize(); i++) {
                if (pNo == (paymentList.getEntry(i).getPaymentNo())) {
                    System.out.print(paymentList.getEntry(i));
                    found = true;
                    System.out.println("\nConfirm refund ths payment? (1 = Yes, 2 = No) > ");
                    int crfPayment = input.nextInt();
                    if (crfPayment == 1) {
                        paymentList.remove(i);
                        System.out.println("\nPayment refunded.");
                        displayPayment();

                    }
                    //paymentList.remove(paymentList.getEntry(pNo));
                    //System.out.println(paymentList);
                }
            }
            if (!found) {
                System.out.println("No such paymentNo. Please try again!");
            }
        } catch (Exception e) {
            System.out.println(e);
            //refundPayment();

        }

    }

    public static void searchPayment() {
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        while (true) {
            try {
                System.out.println("\n====================");
                System.out.println("   SEARCH PAYMENT ");
                System.out.println("====================");

                System.out.println("1. Search by Payment No");
                System.out.println("2. Search by Event No");
                System.out.println("3. Search by Payment Date");
                System.out.println("4. Search by Student ID");
                System.out.println("5. Search by Register No");
                System.out.println("6. Exit");
                System.out.print("\nPlease make your selection > ");
                int searchSelection = input.nextInt();

                switch (searchSelection) {
                    case 1:
                        searchByPaymentNo();
                        break;
                    case 2:
                        searchByEventNo();
                        break;
                    case 3:
                        searchByPaymentDate();
                        break;
                    case 4:
                        searchByStudentID();
                        break;
                    case 5:
                        searchByRegisNo();
                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid input");

                        break;
                }
                if (exit) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Only numeric input is allowed.");

            }
        }

    }

    public static void searchByPaymentNo() {
        Scanner input = new Scanner(System.in);
        boolean result = false;
        boolean exit = false;

        while (true) {
            try {
                displayPayment();
                System.out.print("Enter Payment No > ");
                String sPaymentNo = input.next();
                input.nextLine();
                int paymentNo = Integer.parseInt(sPaymentNo);

                for (int i = 1; i <= paymentList.getSize(); i++) {
                    if (paymentNo == paymentList.getEntry(i).getPaymentNo()) {
                        System.out.println(paymentList.getEntry(i));
                        result = true;
                    }
                }
                if (!result) {
                    System.out.println("No such paymentNo. Please try again!");
                    continue;
                }

                System.out.println("\nSearch again? (Y = Yes, Any key = Back to menu) > ");
                String selection = input.next();
                input.nextLine();
                if (!selection.equalsIgnoreCase("y")) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Data not found");
            }

        }
    }

    public static void searchByEventNo() {
        Scanner input = new Scanner(System.in);
        boolean result = false;
        boolean exit = false;

        while (true) {
            try {
                displayPayment();
                System.out.print("Enter Event No > ");
                String sEventNo = input.next();
                input.nextLine();
                int paymentNo = Integer.parseInt(sEventNo);

                for (int i = 1; i <= paymentList.getSize(); i++) {
                    if (paymentNo == paymentList.getEntry(i).getEvent().getEventNo()) {
                        System.out.println(paymentList.getEntry(i));
                        result = true;
                    }
                }
                if (!result) {
                    System.out.println("No such Event No. Please try again!");
                    continue;
                }

                System.out.println("\nSearch again? (Y = Yes, Any key = Back to menu) > ");
                String selection = input.next();
                input.nextLine();
                if (!selection.equalsIgnoreCase("y")) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Data not found");
            }

        }
    }

    public static void searchByPaymentDate() {
        Scanner input = new Scanner(System.in);
        boolean result = false;
        boolean exit = false;

        while (true) {
            try {
                displayPayment();
                System.out.print("Enter Payment Date > ");
                String paymentDate = input.next();
                input.nextLine();

                for (int i = 1; i <= paymentList.getSize(); i++) {
                    if (paymentDate.equals(paymentList.getEntry(i).getPaymentDate())) {
                        System.out.println(paymentList.getEntry(i));
                        result = true;
                    }
                }
                if (!result) {
                    System.out.println("No such Payment Date. Please try again!");
                    continue;
                }

                System.out.println("\nSearch again? (Y = Yes, Any key = Back to menu) > ");
                String selection = input.next();
                input.nextLine();
                if (!selection.equalsIgnoreCase("y")) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Data not found");
            }

        }
    }

    public static void searchByStudentID() {
        Scanner input = new Scanner(System.in);
        boolean result = false;
        boolean exit = false;

        while (true) {
            try {
                displayPayment();
                System.out.print("Enter Student ID > ");
                String sStudID = input.next();
                input.nextLine();

                for (int i = 1; i <= paymentList.getSize(); i++) {
                    if (sStudID.equals(paymentList.getEntry(i).getEvent().getMember().getStudentID())) {
                        System.out.println(paymentList.getEntry(i));
                        result = true;
                    }
                }

                if (!result) {
                    System.out.println("No such studentID. Please try again!");
                    continue;
                }

                System.out.println("\nSearch again? (Y = Yes, Any key = Back to menu) > ");
                String selection = input.next();
                input.nextLine();
                if (!selection.equalsIgnoreCase("y")) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Data not found");
            }

        }
    }

    public static void searchByRegisNo() {
        Scanner input = new Scanner(System.in);
        boolean result = false;
        boolean exit = false;

        while (true) {
            try {
                displayPayment();
                System.out.print("Enter Register No > ");
                String sStudID = input.next();
                input.nextLine();

                for (int i = 1; i <= paymentList.getSize(); i++) {
                    if (sStudID.equals(paymentList.getEntry(i).getEvent().getRegisNo())) {
                        System.out.println(paymentList.getEntry(i));
                        result = true;
                    }
                }
                if (!result) {
                    System.out.println("No such Regis No. Please try again!");
                    continue;
                }

                System.out.println("\nSearch again? (Y = Yes, Any key = Back to menu) > ");
                String selection = input.next();
                input.nextLine();
                if (!selection.equalsIgnoreCase("y")) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Data not found");
            }

        }
    }

    public static void generateReceipt(Payment pym, double paymentAmount) {
        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");  
        String date = pym.getPaymentDate();
        String time = pym.getPaymentTime();

        //SimpleDateFormat day = new SimpleDateFormat("dd");
        // SimpleDateFormat month = new SimpleDateFormat("MM");
        // SimpleDateFormat year = new SimpleDateFormat("yyyy");
        System.out.println("\n");
        System.out.println("==================================================");
        System.out.println("\t\t MUSIC SOCIETY ");
        System.out.println("==================================================");
        System.out.print("\n");
        System.out.println("Payment No: " + pym.getPaymentNo());
        System.out.println("Date: " + date + "\n" + "Time: " + time);
        System.out.println("Register No: " + pym.getEvent().getRegisNo());
        System.out.print("\n");
        System.out.println("===========================================================================================================================================");
        System.out.println("Event No\t Description\t\t\t\t\t\t\t\t\t\t\t\t\t Price(RM)");
        System.out.println("===========================================================================================================================================");

        System.out.printf("%-5s\t\t %-50s \t %6.2f\n", pym.getEvent().getEventNo(), pym.getEvent().getEventD().getDescription(), pym.getEvent().getEventD().getFees());
        //System.out.println("DFF");
        System.out.print("\n");
        System.out.println("--------------------------------------------------");
        System.out.println("Total Amount: \t\t\t\t " + String.format("%6.2f", pym.getEvent().getEventD().getFees()));
        System.out.println("Paid Amount" + ":\t\t\t\t\t " + String.format("%6.2f", paymentAmount));
        System.out.println("Change: \t\t\t\t " + String.format("%6.2f", paymentAmount - pym.getEvent().getEventD().getFees()));
        System.out.println("==================================================");
        System.out.println("\t\t    THANK YOU");
    }

    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        PaymentModule app = new PaymentModule();
        app.initialize();
        app.paymentMenu();
    }

}
