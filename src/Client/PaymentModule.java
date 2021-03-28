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
                System.out.println("5. Clear All Payment Records");
                System.out.println("6. Exit");
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
                        clearAllPayment();
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
                System.out.println(e);

            }
        }

    }

    public static void displayPayment() {

        if (paymentList.isEmpty()) {
            System.out.println("No payment record in payment list! Please make payment first.");
        } else {
            System.out.println(paymentList.toString());
        }

    }

    public static void addPayment() {
        Scanner input = new Scanner(System.in);

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
                    found = true;
                    boolean paymentDone = false;
                    for (int k = 0; k < paymentList.getSize(); k++) {
                        String pymRegNo = paymentList.getEntry(k+1).getEvent().getRegisNo();
                        if (pymRegNo.equals(regisNo)) {
                            System.out.println("Payment made for this register number!");
                            paymentDone = true;
                            break;
                        }
                    }

                    if (paymentDone) {
                        break;
                    }

                    //EventDetails tempE = memberEvent.getEntry(i).getEventD();
                    System.out.println("==========================================================================");
                    System.out.println("Event No\t Student ID\t Event No\t Price(RM)\t Status");
                    System.out.println("==========================================================================");
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

        boolean found = false;
        Scanner input = new Scanner(System.in);

        try {
            displayPayment();
            System.out.print("Enter Payment No > ");
            int pNo = input.nextInt();
            for (int i = 1; i <= paymentList.getSize(); i++) {
                if (pNo == (paymentList.getEntry(i).getPaymentNo())) {
                    System.out.print(paymentList.getEntry(i));
                    found = true;
                    System.out.print("\nConfirm refund ths payment? (1 = Yes, 2 = No) > ");
                    int crfPayment = input.nextInt();
                    if (crfPayment == 1) {
                        paymentList.remove(i);
                        System.out.println("\nPayment refunded.");
                        displayPayment();
                    }

                }
            }
            if (!found) {
                System.out.println("No such paymentNo. Please try again!");
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please try again!");
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
                if (paymentList.isEmpty()){
                    System.out.println("No record found in payment list");
                    break;
                }
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

                System.out.print("\nSearch again? (Y = Yes, Any key = Back to menu) > ");
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
                String regisNo = input.next();
                input.nextLine();

                for (int i = 1; i <= paymentList.getSize(); i++) {
                    if (regisNo.equals(paymentList.getEntry(i).getEvent().getRegisNo())) {
                        System.out.println(paymentList.getEntry(i));
                        result = true;
                    }
                }

                if (!result) {
                    System.out.println("No such Register No. Please try again!");
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
        System.out.println("================================================================");
        System.out.println("\t\t\t MUSIC SOCIETY ");
        System.out.println("================================================================");
        System.out.print("\n");
        System.out.println("Payment No: " + pym.getPaymentNo());
        System.out.println("Date: " + date + "\n" + "Time: " + time);
        System.out.println("Register No: " + pym.getEvent().getRegisNo());
        System.out.print("\n");
        System.out.println("================================================================");
        System.out.println("Event No\t Name\t\t\t\t Price(RM)");
        System.out.println("================================================================");

        System.out.printf("%-5s\t\t %-30s    %6.2f\n", pym.getEvent().getEventNo(), pym.getEvent().getEventD().getTitle(), pym.getEvent().getEventD().getFees());
        //System.out.println("DFF");
        System.out.print("\n");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Total Amount: \t\t\t\t\t   " + String.format("%6.2f", pym.getEvent().getEventD().getFees()));
        System.out.println("Paid Amount" + ":\t\t\t\t\t   " + String.format("%6.2f", paymentAmount));
        System.out.println("Change: \t\t\t\t\t   " + String.format("%6.2f", paymentAmount - pym.getEvent().getEventD().getFees()));
        System.out.println("================================================================");
        System.out.println("\t\t\t    THANK YOU");
    }

    public static void clearAllPayment() {
        Scanner input = new Scanner(System.in);

        if (paymentList.isEmpty()) {
            System.out.println("No records in payment list!");
        } else {
            displayPayment();
            System.out.print("Are you sure to clear all the payment records? (Y = Yes, N = No) > ");
            String clearRecord = input.next();
            if (clearRecord.equalsIgnoreCase("y")) {
                paymentList.clear();
                System.out.println("All payment records cleared!");

            } else if (clearRecord.equalsIgnoreCase("n")) {

            }

            if (!clearRecord.equalsIgnoreCase("n") && !clearRecord.equalsIgnoreCase("y")) {
                System.out.println("Invalid input, please enter again!");
            }

        }

    }

//    public static void main(String[] args) throws ParseException {
//        // TODO code application logic here
//        PaymentModule app = new PaymentModule();
//        //  app.initialize();
//        app.paymentMenu();
//    }

}
