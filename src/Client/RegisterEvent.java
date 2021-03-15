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
    EventLinkedStackInterface<EventDetails> eventList = new EventLinkedStack<EventDetails>();
    MemberListInterface<Member> memberList = new MemberLinkedList();

    public void initialize() throws ParseException {
//        eventDList. //    memberEvent = new EventArraySet<>();
        EventDetails e = new EventDetails(2212, "Music festival", "22/12/2021", "20:00-22:00", "Live Stream", "Please enter room early 10 mminutes", 20.00);
        eventList.push(e);
        e = new EventDetails(2312, "Music stadium", "23/12/2021", "8:00-17:00", "Main Hall", "Please show ur id card to entry the hall", 25.00);
        eventList.push(e);

        EventLinkedStackInterface<EventDetails> eventDList = new EventLinkedStack<EventDetails>();
        MemberListInterface<Member> memList = new MemberLinkedList();
        memList.add(memberList.get(1));
        eventDList.push(eventList.getEntry(1));
        memberEvent.add(new Event("0001", "Confirmed", eventDList, memList));
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
//                        removeParticularDuplicates();
                        break;
                    case 3:
//                        findDuplicates();
                        break;
                    case 4:
//                        findDup();
                        break;
                    case 5:
//                        removeDuplicates();
                        break;
                    case 6:
//                        removeDuplicates2();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid choice!! Please reenter again!");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Error: Only number input is acceptable!!\n");
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
        int j = 0;
        do {

            System.out.println("Enter your IC number: ");
            ID = scanner.next();

            for (int i = 0; i < memberList.getLength(); i++) {
                if (ID.equals(memberList.get(i).getStudentID())) {
                    check = true;
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

            System.out.println(" ============================================");
            System.out.println(" ++             Events                      ++");
            System.out.println(" ===========================================\n");
            eventList.display();

            do {
                cont = 'n';
                String eventNo = "";
                do {
                    System.out.print(" Select Event No: ");
                    eventNo = scanner1.next();

                    for (j = 0; j < eventList.getEntry(j).getEventNo(); j++) {
                        if (eventNo.equals(eventList.getEntry(j).getEventNo())) {
                            check = true;
                            break;
                        } else {
                            check = false;
                        }
                    }
                    if (check == false) {
                        System.out.println("Please enter the Event No correctly !");
                    }
                } while (check == false);

                do {
                    System.out.print("\n Register again? [Y=yes, N=no]: ");
                    cont = Character.toUpperCase(scanner2.next().charAt(0));
                    if (cont != 'Y' && cont != 'N') {
                        System.out.println("\n Invalid Input, please enter 'Y' or 'N'");
                    }
                } while (cont != 'Y' && cont != 'N');
                
//                memberEvent.add(new Event("0002", "Confirmed", eventList.getEntry(j).getEventNo(), memberList));
            } while (cont == 'Y');

        }

    }
}

