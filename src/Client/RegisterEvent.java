/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import ADT.*;
import Entity.*;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Fung Ann
 */
public class RegisterEvent {

    EventSetInterface<Event> memberEvent = new EventArraySet<>();
    EventLinkedStackInterface<EventDetails> eventList = new EventLinkedStack<>();
//    MemberListInterface<Member> memberList = new MemberLinkedList();
    LinkListInterface<Member> memberList;
    LinkListInterface<Admin> adminList;

    public void initialize() throws ParseException {
        memberList = new LinkList();
        Member n = new Member("20WMR08981", "Ming Nee", "0123456789", "minnie@gmail.com", "30/7/1999");
        memberList.add(n);
        n = new Member("20WMR08928", "Tzu Wey", "0124455667", "ren@gmail.com", "12/12/2000");
        memberList.add(n);
        n = new Member("20WMR08932", "Fung Ann", "0102233445", "falim@gmail.com", "11/11/2000");
        memberList.add(n);
        n = new Member("20WMR08920", "Wen Xuen", "0137788999", "wxkhau@gmail.com", "10/5/2000");
        memberList.add(n);
        n = new Member("20WMR08905", "Jen Nam", "01155556677", "super@gmail.com", "17/03/1999");
        memberList.add(n);
        n = new Member("20WMR08952", "Devon", "01110990922", "devon@gmail.com", "30/5/2000");
        memberList.add(n);
        n = new Member("20WMR08983", "Jia Wei", "0168822337", "jwyeok@gmail.com", "24/10/2000");
        memberList.add(n);
        n = new Member("20WMR08927", "Jia Yi", "01122331216", "daniel@gmail.com", "26/12/1999");
        memberList.add(n);
        n = new Member("20WMR08973", "Chia Qi", "0172323565", "cqwong@gmail.com", "09/07/2000");
        memberList.add(n);
        n = new Member("20WMR08929", "Jing Zhao", "0187755889", "handsome@gmail.com", "26/06/1999");
        memberList.add(n);
        n = new Member("20WMR08999", "Sook Jing", "0134567899", "sjhere@gmail.com", "07/06/2000");
        memberList.add(n);
        n = new Member("20WMR08998", "Sammy Yong", "0156341235", "sammy@gmail.com", "24/08/1999");
        memberList.add(n);
        n = new Member("20WMR08989", "Chee Weng", "0189674125", "wengbob@gmail.com", "07/07/1999");
        memberList.add(n);
        n = new Member("20WMR08959", "Qing Qing", "0131973899", "doubleqing@gmail.com", "03/10/2000");
        memberList.add(n);
        n = new Member("20WMR08921", "Sue Faye", "0145678201", "justina@gmail.com", "01/01/2001");
        memberList.add(n);
        n = new Member("20WMR08931", "Qian Ying", "0182245698", "qiany@gmail.com", "05/04/2000");
        memberList.add(n);

        EventDetails e = new EventDetails(2212, "Music festival", "22/12/2021", "20:00-22:00", "Live Stream", "Please enter room early 10 mminutes", 20.00);
        eventList.push(e);
        e = new EventDetails(2312, "Music stadium", "23/12/2021", "8:00-17:00", "Main Hall", "Please show ur id card to entry the hall", 25.00);
        eventList.push(e);
        e = new EventDetails(2777, "OO Night", "20/05/2021", "20:00-22:00", "Main Hall", "Please show ur id card to entry the hall", 15.00);
        eventList.push(e);
        e = new EventDetails(2787, "OO Night", "20/05/2021", "20:00-22:00", "Main Hall", "Please show ur id card to entry the hall", 15.00);
        eventList.push(e);

        EventLinkedStackInterface<EventDetails> eventDList = new EventLinkedStack<>();
        EventLinkedStackInterface<EventDetails> eventDList1 = new EventLinkedStack<>();
        EventLinkedStackInterface<EventDetails> eventDList2 = new EventLinkedStack<>();
        LinkListInterface<Member> memList = new LinkList();
        LinkListInterface<Member> memList1 = new LinkList();
        LinkListInterface<Member> memList2 = new LinkList();
        memList.add(memberList.getEntry(1));
        memList1.add(memberList.getEntry(2));
        memList2.add(memberList.getEntry(3));

        eventDList.push(new EventDetails(2212, "Music festival", "22/12/2021", "20:00-22:00", "Live Stream", "Please enter room early 10 mminutes", 20.00));
        eventDList1.push(new EventDetails(2777, "OO Night", "20/05/2021", "20:00-22:00", "Main Hall", "Please show ur id card to entry the hall", 15.00));
        eventDList2.push(new EventDetails(2312, "Music stadium", "23/12/2021", "8:00-17:00", "Main Hall", "Please show ur id card to entry the hall", 25.00));
        memberEvent.add(new Event("0001", "Confirmed", eventDList, memList));
        memberEvent.add(new Event("0002", "Confirmed", eventDList2, memList1));
        memberEvent.add(new Event("0003", "Confirmed", eventDList, memList));
        memberEvent.add(new Event("0004", "Confirmed", eventDList1, memList2));
        memberEvent.add(new Event("0005", "Confirmed", eventDList2, memList));
        memberEvent.add(new Event("0006", "Confirmed", eventDList1, memList1));
        

    }

    public static void main(String[] args) throws ParseException {
        RegisterEvent app = new RegisterEvent();

        app.initialize();
        app.registerEventMenu();
    }

    public void registerEventMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("\n+---------------------------------+");
            System.out.println("|              Event              |");
            System.out.println("+---------------------------------+");
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.println("|     Please choose your selection ><      |");
            System.out.println("|         [1] Registration Event           |");
            System.out.println("|         [2] Cancel Register              |");
            System.out.println("|         [3] Member Registration List     |");
            System.out.println("|         [4] Search Event List            |");
            System.out.println("|         [5] View Announcement with Event |");
            System.out.println("|         [0] Exit to Homepage             |");
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
            System.out.print(" Please enter a number => ");
            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        registerEvent();
                        break;
                    case 2:
                        cancelRegister();
                        break;
                    case 3:
                        displayregisterList();
                        break;
                    case 4:
                        searchRegisterMember();
                        break;
                    case 5:
                        announcement();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid choice!! Please reenter again!");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Error: Only number input is acceptable!\n");
                scanner.next();
            }
        } while (choice != 0);

    }

    public void registerEvent() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int select = -1;
        String ID = "";
        boolean check = false;
        char cont;
        int memArray = -1;
//        EventSetInterface<Event> memEvent = new EventArraySet<>();
        do {

            System.out.println("Enter Student ID number: ");
            ID = scanner.next();

            for (int i = 0; i < memberList.getNumberOfEntries(); i++) {
                if (ID.equals(memberList.getEntry(i).getStudentID())) {
//                    System.out.println(memberList.getEntry(i).getStudentID());
                    check = true;
                    memArray = i;
                    break;
                } else {
                    check = false;
                }
            }

            if (check == false) {
                System.out.println("Sorry, haven register yet...");
                //registerNewMember;
            }

        } while (check != true);

        if (check == true) {
            do {

                System.out.println(" ============================================");
                System.out.println(" ++             Events                      ++");
                System.out.println(" ===========================================\n");
                eventList.display();

                cont = 'n';
                int eventNo;
                int arrayNo = -1;

                do {
                    System.out.print(" Select Event No: ");
                    eventNo = scanner1.nextInt();

                    for (int j = 0; j <= eventList.EventTotal(); j++) {
                        if (eventList.getEntry(j).getEventNo() == eventNo) {
                            check = true;
                            arrayNo = j;
                            break;
                        } else {
                            check = false;
                        }
                    }

                    if (check == false) {
                        System.out.println("Please enter the Event No correctly !");
                    } else {
                        System.out.println("Register successful!");
                    }
                } while (check != true);

                do {
                    System.out.print("\n Register again? [Y=yes, N=no]: ");
                    cont = Character.toUpperCase(scanner2.next().charAt(0));
                    if (cont != 'Y' && cont != 'N') {
                        System.out.println("\n Invalid Input, please enter 'Y' or 'N'");
                    }
                } while (cont != 'Y' && cont != 'N');

//                EventDetails eventD = eventList.getEntry(j);
//                Member member = memberList.get(j);
//                memberEvent.add(new Event("0009", "Confirmed", eventList.getEntry(arrayNo), memberList.getEntry(memArray)));
                EventLinkedStackInterface<EventDetails> neweventDList = new EventLinkedStack<>();
                neweventDList.push(eventList.getEntry(arrayNo));
                LinkListInterface<Member> newmemList = new LinkList();
                newmemList.add(memberList.getEntry(memArray));

//                System.out.println(neweventDList.toString());
//                System.out.println(newmemList.toString());
                memberEvent.add(new Event("Confirmed", neweventDList, newmemList));
            } while (cont == 'Y');
        }

    }

    public void displayregisterList() {

        System.out.println(memberEvent.toString());
    }

//    public void cancelRegister() {
//        Scanner scanner = new Scanner(System.in);
//        String registerNo = "";
//        boolean check = false;
//        do {
//            System.out.println(memberEvent.toString());
//
//            System.out.println("Enter the registration No : ");
//            
//            registerNo = scanner.nextLine();
//            
////            for (int i = 0; i < memberEvent.getSize(); i++) {
////                if (registerNo.equals(memberEvent.getEntry(i).getRegisNo())) {
////                    System.out.println("Hi !");
////                    System.out.println(memberEvent.toString());
////                    break;
////                }
////            }
//
//            for (int i = 0; i < memberEvent.getSize(); i++) {
//                if (registerNo.equals(memberEvent.getEntry(i).getRegisNo())) {
//                    check = true;
//                    memberEvent.remove(memberEvent.getEntry(i));
//                    System.out.println(memberEvent.toString());
//                    System.out.println("Refund will be get within 3 days.");
//                    break;
//                } else {
//                    check = false;
//                    System.out.println("Invalid register No ! Please re-enter again.");
//                    break;
//                }
//            }
////
////            if (check = true) {
////                memberEvent.remove(memberEvent.getEntry(i));
////                System.out.println(memberEvent.toString());
////            }
//        } while (check != true);
//
//    }
    
 public void cancelRegister() {
        Scanner scanner = new Scanner(System.in);
        String registerNo = "";
        boolean check = false;
        do {
            System.out.println(memberEvent.toString());

            System.out.println("Enter the registration No : ");
            
            registerNo = scanner.nextLine();
            
            for (int i = 0; i < memberEvent.getSize(); i++) {
                if (registerNo.equals(memberEvent.getEntry(i).getRegisNo())) {
                    check = true;
                    memberEvent.remove(memberEvent.getEntry(i));
//                    System.out.println(memberEvent.toString());
                    System.out.println("Refund will be get within 3 days.");
                    break;
                }
            }
            if (check == false) {
                System.out.println("Invalid register No ! Please re-enter again.");
            }
//
//            if (check = true) {
//                memberEvent.remove(memberEvent.getEntry(i));
//                System.out.println(memberEvent.toString());
//            }
        } while (check != true);

    }

    public void searchRegisterMember() {
        
        Event serachRegisNo = new Event();
        Scanner regisN = new Scanner(System.in);
        System.out.println("Please enter the register No :");
        String regis = regisN.nextLine();
//        serachRegisNo.setRegisNo(regis);
//        System.out.println(memberEvent.contains(serachRegisNo));
//        break;
        for (int i = 0; i < memberEvent.getSize(); i++) {
            if (regis.equals(memberEvent.getEntry(i).getRegisNo()))
                System.out.println(memberEvent.getEntry(i).toString());
        }
        System.out.println("");

    }

    public void announcement() {
//        EventSetInterface<Event> eventAnno = new EventArraySet<>();
//        eventAnno.add(new Event("Secret customer"));
//        System.out.println(memberEvent.union(eventAnno));

//        EventSetInterface<Event> anno = new EventArraySet<>();
//        EventLinkedStackInterface<EventDetails> eventAnno = new EventLinkedStack<>();
//        anno.add(new Event("Secret customer"));
//        
//        anno.union((EventLinkedStackInterface<Event>) eventAnno.getEntry(0));
//        System.out.println(eventList.EventTotal());
    }

}
