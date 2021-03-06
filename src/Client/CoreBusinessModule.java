/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import ADT.*;
import static Client.MusicSociety.eventList;
import static Client.MusicSociety.memberList;
import static Client.EventMaintenance.menu;
import Client.EventMaintenance;
import static Client.LoginAndUserMaintenance.adminHomepage;
import static Client.LoginAndUserMaintenance.registerNewMember;
import static Client.MusicSociety.memberEvent;
import Entity.*;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Fung Ann
 */
public class CoreBusinessModule {

    public static void registerEventMenu() {
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
            System.out.println("|         [5] Clear all Registration List  |");
            System.out.println("|         [6] Event Maintainence           |");
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
                        searchMenu();
                        break;
                    case 5:
                        clearRegisList();
                        break;
                    case 6:
                        EventMaintenance.menu();
                        break;
                    case 0:
                        adminHomepage();
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

    public static void registerEvent() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int select = -1;
        String ID = "";
        boolean check = false;
        boolean taken = false;
        char cont;
        int memArray = -1;
//        EventSetInterface<Event> memEvent = new EventArraySet<>();
        do {
            do {

                System.out.println("Enter Student ID number: ");
                ID = scanner.next();

                for (int i = 0; i < memberList.getLength(); i++) {
                    if (ID.equals(memberList.get(i).getStudentID())) {
                        check = true;
                        memArray = i;
                        break;
                    } else {
                        check = false;
                    }
                }

                if (check == false) {
                    System.out.println("Sorry, haven register yet...");
                    registerNewMember();
                }

            } while (check != true);

            if (check == true) {
                do {

                    System.out.println(" =========================================================");
                    System.out.println(" ++                       Events                      ++");
                    System.out.println(" =========================================================\n");
                    for (int i = 1; i < eventList.EventTotal(); i++) {
                        // System.out.println("No" + (i + 1) + " " + current.data.toString() + " ");
                        //            System.out.println("No" + " " + eventList.getEntry(i).getEventNo() + "         " + eventList.getEntry(i).getTitle() + "        RM " + eventList.getEntry(i).getFees());
                        System.out.printf("No. %-5d\t %-30s RM%6.2f\n", eventList.getEntry(i).getEventNo(), eventList.getEntry(i).getTitle(), eventList.getEntry(i).getFees());

                    }
                    cont = 'n';
                    int eventNo;
                    int arrayNo = -1;
                    boolean chkDup = false;

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
                            chkDup = true;
                        }
                    } while (check != true);

                    if (chkDup == true) {
                        for (int x = 0; x < memberEvent.getSize(); x++) {
                            if (memberEvent.getEntry(x).getEventNo() == eventNo && memberEvent.getEntry(x).getStudId().equals(ID)) {
                                taken = true;
                                break;
                            }
                        }
                        if (taken == true) {
                            System.out.println("The member has been registered for this event! Cannot register multiple times.");
                        } else if (taken == false) {
                            System.out.println("Register successful!");
                            memberEvent.add(new Event("Confirmed", eventList.getEntry(arrayNo), memberList.get(memArray)));
                        }

                        do {
                            System.out.print("\n Register again? [Y=yes, N=no]: ");
                            cont = Character.toUpperCase(scanner2.next().charAt(0));
                            if (cont != 'Y' && cont != 'N') {
                                System.out.println("\n Invalid Input, please enter 'Y' or 'N'");
                            }
                            if (cont == 'N') {
                                registerEventMenu();
                            }
                        } while (cont != 'Y' && cont != 'N');

                        EventLinkedStackInterface<EventDetails> neweventDList = new EventLinkedStack<>();
                        neweventDList.push(eventList.getEntry(arrayNo));
                        LinkListInterface<Member> newmemList = new LinkList();
                        newmemList.add(memberList.get(memArray));

                    }

                } while (cont == 'Y');
            }

        } while (taken == true);
    }

    public static void displayregisterList() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("|                                            |");
        System.out.println("|          Member Registration List          |");
        System.out.println("|                                            |");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.printf("%-16s %-14s %-14s %-10s %10s\n", "Registration No", "Student ID", "Event No", "Fees", "Status");
        System.out.println("=============== ===========    =========      =========      =========");

        System.out.println(memberEvent.toString());

        if (memberEvent.isEmpty()) {
            System.out.println("No record found...");
        }
    }

    public static void cancelRegister() {
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
                    System.out.println("Registration No :" + registerNo + " will be cancelled. \nRefund will be get within 3 days.");
                    break;
                }
            }
            if (check == false) {
                System.out.println("Invalid register No ! Please re-enter again.");
            }
            System.out.println("\n[1] Continue ?");
            System.out.println("[Any key] Exit to the Event Menu");
            System.out.print("Your option => ");
            String option = scanner.nextLine();
            if (!option.equals("1")) {
                registerEventMenu();
            }
        } while (check != true);

    }

    public static void searchMenu() {
        Scanner key = new Scanner(System.in);
        System.out.println("Please choose who you want to search?");
        System.out.println("[1]. Register No");
        System.out.println("[2]. Event No");
        System.out.print("Enter the choice (1/2): ");
        int k = key.nextInt();

        switch (k) {
            case 1:
                searchRegisterMember();
                break;
            case 2:
                searchEventNo();
                break;
            default:
                System.out.println("Error: only number input is acceptable.");
                break;
        }
    }

    public static void searchRegisterMember() {

        Scanner scanner = new Scanner(System.in);
        boolean check = false;

        do {

            Scanner regisN = new Scanner(System.in);
            System.out.println("Please enter the register No :");
            String regis = regisN.nextLine();

            for (int i = 0; i < memberEvent.getSize(); i++) {
                if (regis.equals(memberEvent.getEntry(i).getRegisNo())) {
                    check = true;
                    System.out.printf("%-16s %-14s %-14s %-10s %10s\n", "Registration No", "Student ID", "Event No", "Fees", "Status");
                    System.out.println("=============== ===========    =========      =========      =========");
                    System.out.println(memberEvent.getEntry(i).toString());
                    break;
                } else {
                    check = false;
                }
            }
            if (check == false) {
                System.out.println("");
                System.out.println("The register No may invalid or removed ! Please re-enter again...");
            }

            System.out.println("\n[1] Search again");
            System.out.println("[Any key] Exit to the Event Menu");
            System.out.print("Your option => ");
            String option = scanner.nextLine();
            if (!option.equals("1")) {
                registerEventMenu();
            }
        } while (check != true);

    }

    public static void searchEventNo() {

        Scanner scanner = new Scanner(System.in);
        boolean check = false;

        do {

            Scanner regisN = new Scanner(System.in);
            System.out.println("Please enter the Event No :");
            int eventNo = regisN.nextInt();
            System.out.printf("%-16s %-14s %-14s %-10s %10s\n", "Registration No", "Student ID", "Event No", "Fees", "Status");
            System.out.println("=============== ===========    =========      =========      =========");

            for (int i = 0; i < memberEvent.getSize(); i++) {
                if (memberEvent.getEntry(i).getEventNo() == eventNo) {
                    check = true;
                    System.out.println(memberEvent.getEntry(i).toString());
                }
            }
            if (check == false) {
                System.out.println("");
                System.out.println("The Event No may invalid or removed ! Please re-enter again...");
            }

            System.out.println("\n[1] Search again");
            System.out.println("[Any key] Exit to the Event Menu");
            System.out.print("Your option => ");
            String option = scanner.nextLine();
            if (!option.equals("1")) {
                registerEventMenu();
            }
        } while (check != true);

    }

    public static void clearRegisList() {
        char ans;
        Scanner scanner = new Scanner(System.in);
        ans = 'n';
        System.out.println("Are you sure want to clear all the record ?");
        System.out.println("Answer [Y=yes, N=no]:");
        ans = Character.toUpperCase(scanner.next().charAt(0));
        if (ans != 'Y' && ans != 'N') {
            System.out.println("\n Invalid Input, please enter 'Y' or 'N'");
        }
        if (ans == 'N') {
            registerEventMenu();
        } else {
            memberEvent.clear();
            System.out.println("The record had been cleared.");
            registerEventMenu();
        }

    }
}
