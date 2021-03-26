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
import Client.NewEvent;
import static Client.PaymentModule.paymentMenu;

/**
 *
 * @author Music Society
 */
public class MusicSociety {

    public static NewEvent eDetails;
    public static MemberListInterface<Member> memberList = new MemberLinkedList();
    public static Admin admin = new Admin("admin", "admin", "1001", "6011-11932585", "admin@tarc.edu.my", "17/03/1999");
    public static EventLinkedStackInterface<EventDetails> eventList = new EventLinkedStack<EventDetails>();

    public static SetInterface<Event> memberEvent = new ArraySet<>();

    LinkListInterface<Admin> adminList;

    public void initialize() throws ParseException {

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

        EventDetails e = new EventDetails("Music festival", "22/12/2021", "20:00-22:00", "Live Stream", "Please enter room early 10 mminutes", 20.00);
        eventList.push(e);

        e = new EventDetails("Singing Lession", "19/11/2020", "20:00-21:00", "Google Meet Link", "Lesson will conduct at monday and thursday end at 23/12/2020.(8 Lesson) ", 100.00);
        eventList.push(e);

        e = new EventDetails("Advance Guitar Lesson", "24/11/2020", "18:00-19:00", "Google Meet Link", "Advance guitar lession teach by teacher Thiam every friday. Lesson end at 27/12/2020 (8 Lesson)", 100.00);
        eventList.push(e);

        e = new EventDetails("Guitar Lesson", "24/11/2020", "19:30-20:30", "Google Meet Link", "Beginner guitar lession teach by teacher Thiam every friday. Lesson end at 27/11/2020 (8 Lesson)", 100.00);
        eventList.push(e);

        e = new EventDetails("Music Night", "22/01/2021", "17:00-22:00", "Google Meet Link", "Visual welcome party for the new member. Performance by Senior member, Free for all member ", 0.00);
        eventList.push(e);

        e = new EventDetails("Visual Music Fiesta", "23/04/2021", "19:00-21:00", "Google Meet Link", "Visual music concert for for all member. Guest performer： xxx ", 65.00);
        eventList.push(e);

        e = new EventDetails("Music Sharing", "26/03/2021", "20:00", "Google Meet Link", "Music sharing between member. Member require to prepare song and share the story about the song in the event ", 0.00);
        eventList.push(e);

        e = new EventDetails("OO Night", "25/05/2021", "20:00-22:00", "Google Meet Link", "Welcome party for new intake student. Only allow new intake student to join the party", 25.00);
        eventList.push(e);

        LinkListInterface<Member> memList = new LinkList();
        LinkListInterface<Member> memList1 = new LinkList();
        LinkListInterface<Member> memList2 = new LinkList();

        memList.add(memberList.get(1));
        memList1.add(memberList.get(2));
        memList2.add(memberList.get(3));

        memberEvent.add(new Event("0001", "Confirmed", eventList.getEntry(0), memberList.get(0)));
        memberEvent.add(new Event("0002", "Confirmed", eventList.getEntry(1), memberList.get(1)));
        memberEvent.add(new Event("0003", "Confirmed", eventList.getEntry(2), memberList.get(2)));
        memberEvent.add(new Event("0004", "Confirmed", eventList.getEntry(3), memberList.get(3)));
        memberEvent.add(new Event("0005", "Confirmed", eventList.getEntry(4), memberList.get(4)));
        memberEvent.add(new Event("0006", "Confirmed", eventList.getEntry(5), memberList.get(5)));

    }

    public static void main(String[] args) throws ParseException {
        MusicSociety app = new MusicSociety();

        app.initialize();
        app.firstPage();
    }

    public void firstPage() {
        Scanner scanner = new Scanner(System.in);
        int select = -1;
        System.out.println("\n+---------------------------------+");
        System.out.println("|           Welcome To            |");
        System.out.println("|           Music Society         |");
        System.out.println("+---------------------------------+");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println("|     Please choose your selection ><  |");
        System.out.println("|         [1] Login                    |");
        System.out.println("|         [2] Forgot Password          |");
        System.out.println("|         [0] Exit                     |");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
        System.out.print(" Please enter a number => ");
        try {
            select = scanner.nextInt();
            switch (select) {
                case 1:
                    login();
                    break;
                case 2:
                    Forgotpassword();
                    break;
                case 0:
                    System.out.println("\n=====================================");
                    System.out.println("    HAVE A NICE DAY! BYE-BYE >.<");
                    System.out.println("=====================================");
                    System.exit(0);
                default:
                    System.out.println("**Please enter available options!**\n");
                    firstPage();
            }
        } catch (Exception e) {
            System.out.println("**Invalid Input! Please Re-enter Again!**\n");
            firstPage();
        }

    }

    private void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n+---------------------------------+");
        System.out.println("|           Admin Login           |");
        System.out.println("+---------------------------------+");

        System.out.print("\nEnter your username => ");
        String username = scanner.nextLine();
        System.out.print("Enter your password => ");
        String password = scanner.nextLine();
        if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
            System.out.print("Login Successful!\n");
            adminHomepage();
        } else {
            System.out.print("You are non-admin please contact our admin!\n");
            firstPage();
        }
    }

    public void Forgotpassword() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Reset password by email => ");
        String email = sc.nextLine();
        if (email.equals(admin.getEmail())) {
            System.out.print("Reset password => ");
            String newps = sc.nextLine();
            admin.setPassword(newps);
            System.out.println("Your Password Reset Successfully!\n");
            login();
        } else {
            System.out.print("You are non-admin please contact our admin!\n");
            firstPage();
        }

    }

    public void adminHomepage() {
        Scanner sc = new Scanner(System.in);
        int select = -1;

        do {
            System.out.printf("Loading\n");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.printf(".");
                    try {
                        Thread.sleep(350);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.printf("\b\b\b   \b\b\b");
            }
            System.out.println("\n+---------------------------------+");
            System.out.println("|           Welcome To            |");
            System.out.println("|           Admin Page            |");
            System.out.println("+---------------------------------+");
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.println("|     Please choose your selection ><  |");
            System.out.println("|         [1] Member                   |");
            System.out.println("|         [2] Event                    |");
            System.out.println("|         [3] Payment                    |");
            System.out.println("|         [4] Back To Login Page       |");
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
            System.out.print("Please enter a number => ");

            try {
                select = sc.nextInt();

                switch (select) {
                    case 1:
                        memberMaintainencePage();
                        break;
                    case 2:
                        registerEventMenu();
                        break;
                    case 3:
                        paymentMenu();
                        break;
                    case 4:
                        firstPage();
                        break;
                    default:
                        System.out.println("**Please enter available options!**\n");
                }
            } catch (Exception e) {
                System.out.println("**Invalid Input! Please Re-enter Again!**\n");
                sc.next();
            }
        } while (select != 0);
    }

    private void memberMaintainencePage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println("|     Please choose your selection ><  |");
        System.out.println("|         [1] Display Member List      |");
        System.out.println("|         [2] Search Member            |");
        System.out.println("|         [3] Register new member      |");
        System.out.println("|         [4] Edit Member              |");
        System.out.println("|         [5] Delete Member            |");
        System.out.println("|         [0] Exit to Homepage         |");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
        System.out.print("Enter your option => ");
        int option = scanner.nextInt();
        switch (option) {
            case 1 ->
                displayMembers();
            case 2 ->
                searchMember();
            case 3 ->
                registerNewMember();
            case 4 ->
                editMember();
            case 5 ->
                deleteMember();
            default ->
                adminHomepage();
        }
    }

    private void displayMembers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n+---------------------------------+");
        System.out.println("|           Member List           |");
        System.out.println("+---------------------------------+");
        for (int i = 0; i < memberList.getLength(); i++) {
            System.out.println("\n");
            System.out.println("---------------Member " + (i + 1) + "------------");
            System.out.println(memberList.get(i).toString());

        }
        System.out.println("\n---------------End of List---------------");
        scanner.nextLine();
        memberMaintainencePage();
    }

    private void searchMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n+---------------------------------+");
        System.out.println("|          Search member          |");
        System.out.println("+---------------------------------+");
        boolean exit = false;
        while (exit == false) {
            System.out.print("Enter studentID => ");
            String memberID = scanner.nextLine();
            boolean found = false;
            for (int i = 0; i < memberList.getLength(); i++) {
                if (memberID.equals(memberList.get(i).getStudentID())) {
                    System.out.println("StudentID => " + memberList.get(i).getStudentID());
                    System.out.println("Name      => " + memberList.get(i).getName());
                    System.out.println("Contact No => " + memberList.get(i).getContactNo());
                    System.out.println("Email     => " + memberList.get(i).getEmail());
                    System.out.println("Birthdate => " + memberList.get(i).getBirthdate());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("\nNo such member !");
            }
            System.out.println("\n[1] Search again");
            System.out.println("[Any key] Exit to the Member Maintainence page");
            System.out.print("Your option => ");
            String option = scanner.nextLine();
            if (!option.equals("1")) {
                memberMaintainencePage();
            }
        }

    }

    public void registerNewMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n+---------------------------------+");
        System.out.println("|       Register New Member       |");
        System.out.println("+---------------------------------+");

        boolean exit = false;
        while (exit == false) {
            System.out.print("Enter your studentID => ");
            String studentID = scanner.nextLine();
            System.out.print("Enter your name => ");
            String name = scanner.nextLine();
            System.out.print("Enter your contactNo => ");
            String contactNo = scanner.nextLine();
            System.out.print("Enter your email => ");
            String email = scanner.nextLine();
            System.out.print("Enter your birthdate => ");
            String birthdate = scanner.nextLine();
            Member m = new Member(studentID, name, contactNo, email, birthdate);
            memberList.add(m);
            System.out.print("\nSuccessfully Register!");

            System.out.println("\n[1] Register new member again");
            System.out.println("[Any key] Exit to the Member Maintainence page");
            System.out.print("Your option => ");
            String option = scanner.nextLine();
            if (!option.equals("1")) {
                memberMaintainencePage();
            }
        }
    }

    private void editMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n+---------------------------------+");
        System.out.println("|           Edit Member           |");
        System.out.println("+---------------------------------+");
        System.out.print("Please Enter Student ID => ");
        String memberID = scanner.nextLine();
        for (int i = 0; i < memberList.getLength(); i++) {
            if (memberID.equals(memberList.get(i).getStudentID())) {
                Scanner sc = new Scanner(System.in);
                System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
                System.out.println("|     Please choose your selection ><  |");
                System.out.println("|         [1] Email                    |");
                System.out.println("|         [2] Contact No               |");
                System.out.println("|         [0] Exit to Maintainence Page|");
                System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
                System.out.print("Enter your option => ");
                int option = scanner.nextInt();
                if (option == 1) {
                    System.out.println("Email => " + memberList.get(i).getEmail());
                    System.out.print("New Email => ");
                    String email = sc.nextLine();
                    memberList.get(i).setEmail(email);
                    System.out.println("Successfully Update!");
                    scanner.nextLine();
                    memberMaintainencePage();
                } else if (option == 2) {
                    System.out.println("Contact No => " + memberList.get(i).getContactNo());
                    System.out.print("New Contact No => ");
                    String pno = sc.nextLine();
                    memberList.get(i).setContactNo(pno);
                    System.out.println("Successfully Update!");
                    scanner.nextLine();
                    memberMaintainencePage();
                } else {
                    memberMaintainencePage();
                }

            }
        }
        System.out.println("No such Student ID!");
        memberMaintainencePage();
    }

    private void deleteMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n+---------------------------------+");
        System.out.println("|           Delete Member         |");
        System.out.println("+---------------------------------+");
        System.out.print("Please Enter Student ID => ");
        String memberID = scanner.nextLine();
        for (int i = 0; i < memberList.getLength(); i++) {
            if (memberID.equals(memberList.get(i).getStudentID())) {
                Scanner sc = new Scanner(System.in);
                System.out.println("StudentID => " + memberList.get(i).getStudentID());
                System.out.println("Name      => " + memberList.get(i).getName());
                System.out.println("Contact No => " + memberList.get(i).getContactNo());
                System.out.println("Email     => " + memberList.get(i).getEmail());
                System.out.println("Birthdate => " + memberList.get(i).getBirthdate());
                System.out.print("Confirm delete press 0 else back to Member Maintainence Page => ");
                String dm = sc.next();
                if ("0".equals(dm)) {
                    memberList.remove(memberList.get(i));
                    System.out.println("\nSuccessfully Delete Member!");
                    scanner.nextLine();
                    memberMaintainencePage();
                } else {
                    System.out.println("Back to Member Maintainence Page!");
                    scanner.nextLine();
                    memberMaintainencePage();
                }
            }
        }
        System.out.println("No such Student ID!");
        memberMaintainencePage();
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
                        menu();
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

//                System.out.println("No" + " " + eventList.getEntry(i).getTitle());

                }
//    display();
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
                    if (cont == 'N') {
//                        payment();
                    }
                } while (cont != 'Y' && cont != 'N');

                EventLinkedStackInterface<EventDetails> neweventDList = new EventLinkedStack<>();
                neweventDList.push(eventList.getEntry(arrayNo));
                LinkListInterface<Member> newmemList = new LinkList();
                newmemList.add(memberList.get(memArray));

                memberEvent.add(new Event("Confirmed", eventList.getEntry(arrayNo), memberList.get(memArray)));
            } while (cont == 'Y');
        }

    }

    public void displayregisterList() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("|                                            |");
        System.out.println("|          Member Registration List          |");
        System.out.println("|                                            |");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++\n");
        System.out.printf("%-20s %-12s %-10s %-10s\n", "Registration No", "Student ID", "Event No", "Status");
        System.out.println("===============      ===========  =========  =========");

        System.out.println(memberEvent.toString());

        if (memberEvent.isEmpty()) {
            System.out.println("No record found...");
        }
    }

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
                    System.out.println("Registration No :" + registerNo + " will be cancelled. \nRefund will be get within 3 days.");
                    break;
                }
            }
            if (check == false) {
                System.out.println("Invalid register No ! Please re-enter again.");
            }
        } while (check != true);

    }

    public void searchMenu() {
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

    public void searchRegisterMember() {

        Scanner scanner = new Scanner(System.in);
        boolean check = false;

        do {

            Scanner regisN = new Scanner(System.in);
            System.out.println("Please enter the register No :");
            String regis = regisN.nextLine();

            for (int i = 0; i < memberEvent.getSize(); i++) {
                if (regis.equals(memberEvent.getEntry(i).getRegisNo())) {
                    check = true;
                    System.out.printf("%-20s %-12s %-10s %-10s\n", "Registration No", "Student ID", "Event No", "Status");
                    System.out.println("===============      ===========  =========  =========");
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

    public void searchEventNo() {

        Scanner scanner = new Scanner(System.in);
        boolean check = false;

        do {

            Scanner regisN = new Scanner(System.in);
            System.out.println("Please enter the Event No :");
            int eventNo = regisN.nextInt();
            System.out.printf("%-20s %-12s %-10s %-10s\n", "Registration No", "Student ID", "Event No", "Status");
            System.out.println("===============      ===========  =========  =========");

            for (int i = 0; i < memberEvent.getSize(); i++) {
                if (memberEvent.getEntry(i).getEventNo() == eventNo) {
                    check = true;
                    System.out.println(memberEvent.getEntry(i).toString());
                } else {
                    check = false;
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

    public void clearRegisList() {
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

    public void menu() {
        int menu = - 1;
//        Scanner sNo = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        do {
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
            try {
                menu = scanner.nextInt();
                switch (menu) {
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
                        registerEventMenu();
                    default:
                        System.out.println("Invalid selection");
                }
            } catch (Exception ex) {
                System.out.println("Loading ... \n");
//                 menu = sNo.nextInt();
                scanner.next();
            }

        } while (menu != 0);

    }

    public void addNew() {

        int no;
        String title, time, loc, desc, date;
        double fee;
        char select;

        Scanner slc = new Scanner(System.in);
        Scanner eNo = new Scanner(System.in);
        Scanner getTitle = new Scanner(System.in);
        Scanner getTime = new Scanner(System.in);
        Scanner getLoc = new Scanner(System.in);
        Scanner getDesc = new Scanner(System.in);
        Scanner getDate = new Scanner(System.in);
        Scanner getFee = new Scanner(System.in);

//        if(eventList != null){
//        }else{
//          System.out.println("...");
//        }
//     
        do {

            System.out.println("===== Add New Event =====");
//        System.out.println("1. Event NO " );
//        System.out.println("1. Event NO " );
            System.out.println("1. Event NO " + EventDetails.getNewEventNo());
            System.out.println("...............");
            no = EventDetails.getNewEventNo();
//        System.out.println("...............");
//        no = eNo.nextInt();

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
            fee = getFee.nextDouble();

            // push stack
            EventDetails e = new EventDetails(title, date, time, loc, desc, fee);
            eventList.push(e);

            System.out.println("Do you want add new details again? [Y|N]");
            select = Character.toUpperCase(slc.next().charAt(0));

        } while (select == 'Y');
    }

    public void clear() {
        char ans;
        Scanner anss = new Scanner(System.in);
        if (eventList.isEmpty()) {
            System.out.println("No record found");
            menu();
        } else {
            System.out.println("Are you sure want to clear all the list?");
            ans = Character.toUpperCase(anss.next().charAt(0));

            if (ans == 'Y' || ans == 'y') {
                eventList.clear();
                menu();
            } else {
                System.out.println("Remain all information");
                menu();
            }

        }
    }

    public void update() {

        int no, insert, choose;
        String title, time, loc, desc, date, news;
        double fee;
//        char choose;
//        
        Scanner slc = new Scanner(System.in);
        Scanner eNo = new Scanner(System.in);
        Scanner getTitle = new Scanner(System.in);
        Scanner getTime = new Scanner(System.in);
        Scanner getLoc = new Scanner(System.in);
        Scanner getDesc = new Scanner(System.in);
        Scanner getDate = new Scanner(System.in);
        Scanner getFee = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        Scanner select = new Scanner(System.in);

        if (eventList.isEmpty()) {
            System.out.println("No record found");
            menu();
        } else {
            System.out.println("The latest event is " + eventList.peek());
            System.out.println("============= Update current Event =============");
            System.out.println("Please insert the Event No to update details ");
            insert = input.nextInt();
            System.out.println(".........");
            boolean check = false;
//        do{
            //get list
            for (int i = 0; i < eventList.EventTotal(); i++) {
//              System.out.println(eventList.getEntry(i).getEventNo());
                //catch user input
                if (eventList.getEntry(i).getEventNo() == insert) {

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

                    if (choose == 1) {
                        System.out.println("2. Event Title : " + eventList.getEntry(i).getTitle());
                        System.out.println("..............");
                        title = getTitle.nextLine();
                        eventList.getEntry(i).setTitle(title);

                        System.out.println("Update successfully");
                        System.out.println("=================================");
                    } else if (choose == 2) {
                        System.out.println("3. Event Date : " + eventList.getEntry(i).getDate());
                        System.out.println("..............");
                        date = getDate.nextLine();
                        eventList.getEntry(i).setDate(date);

                        System.out.println("Update successfully");
                        System.out.println("=================================");
                    } else if (choose == 3) {
                        System.out.println("4. Event Time : " + eventList.getEntry(i).getTime());
                        System.out.println("..............");
                        time = getTime.next();
                        eventList.getEntry(i).setTime(time);

                        System.out.println("Update successfully");
                        System.out.println("=================================");
                    } else if (choose == 4) {
                        System.out.println("5. Location : " + eventList.getEntry(i).getLocation());
                        System.out.println("............");
                        loc = getLoc.nextLine();
                        eventList.getEntry(i).setLocation(loc);

                        System.out.println("Update successfully");
                        System.out.println("=================================");
                    } else if (choose == 5) {
                        System.out.println("6. Event Description : " + eventList.getEntry(i).getDescription());
                        System.out.println(".....................");
                        desc = getDesc.nextLine();
                        eventList.getEntry(i).setDescription(desc);

                        System.out.println("Update successfully");
                        System.out.println("=================================");
                    } else if (choose == 6) {
                        System.out.println("7. Fees " + eventList.getEntry(i).getFees());
                        fee = getFee.nextDouble();
                        eventList.getEntry(i).setFees(fee);

                        System.out.println("Update successfully");
                        System.out.println("=================================");
                    } else if (choose == 7) {
                        System.out.println("2. Event Title : " + eventList.getEntry(i).getTitle());
                        System.out.println("..............");
                        title = getTitle.nextLine();
                        eventList.getEntry(i).setTitle(title);

                        System.out.println("3. Event Date : " + eventList.getEntry(i).getDate());
                        System.out.println("..............");
                        date = getDate.nextLine();
                        eventList.getEntry(i).setDate(date);

                        System.out.println("4. Event Time : " + eventList.getEntry(i).getTime());
                        System.out.println("..............");
                        time = getTime.next();
                        eventList.getEntry(i).setTime(time);

                        System.out.println("5. Location : " + eventList.getEntry(i).getLocation());
                        System.out.println("............");
                        loc = getLoc.nextLine();
                        eventList.getEntry(i).setLocation(loc);

                        System.out.println("6. Event Description : " + eventList.getEntry(i).getDescription());
                        System.out.println(".....................");
                        desc = getDesc.nextLine();
                        eventList.getEntry(i).setDescription(desc);

                        System.out.println("7. Fees " + eventList.getEntry(i).getFees());
                        fee = getFee.nextDouble();
                        eventList.getEntry(i).setFees(fee);

                        System.out.println("Update successfully");
                        System.out.println("=================================");
                    } else {
                        display();
                    }

                    check = true;
                    break;
                }
//               
            }
            if (!check) {
                System.out.println("No record");
            }

//            System.out.println(eventList.getEntry(insert));
            display();
        }
    }

    //new list 
//         System.out.println(eventList);
//          display();
//            System.out.println("Do you want to continue update ? ");
//             choose = Character.toUpperCase(slc.next().charAt(0));
//    }while( choose =='Y');
    public void Remove() {
        if (eventList.isEmpty()) {
            System.out.println("No record found");
            menu();
        } else {
            System.out.println("Remove the latest details");
            eventList.pop();
            menu();
        }
    }

    public void search() {
        int find;
        Scanner search = new Scanner(System.in);
//        

        if (eventList.isEmpty()) {
            System.out.println("No record found");
            menu();
        } else {

            System.out.println("Please enter the Event no ");
            find = search.nextInt();

            boolean fin = false;
            for (int i = 0; i < eventList.EventTotal(); i++) {
                if (eventList.getEntry(i).getEventNo() == find) {
                    System.out.println("1.Event No : " + eventList.getEntry(i).getEventNo());
                    System.out.println("...........");

                    System.out.println("2. Event Title : " + eventList.getEntry(i).getTitle());
                    System.out.println("..............");

                    System.out.println("3. Event Date : " + eventList.getEntry(i).getDate());
                    System.out.println("..............");

                    System.out.println("4. Event Time : " + eventList.getEntry(i).getTime());
                    System.out.println("..............");

                    System.out.println("5. Location : " + eventList.getEntry(i).getLocation());
                    System.out.println("............");

                    System.out.println("6. Event Description : " + eventList.getEntry(i).getDescription());
                    System.out.println(".....................");

                    System.out.println("7. Fees " + eventList.getEntry(i).getFees());
                    fin = true;
                    break;
                }

            }
            if (!fin) {
                System.out.println("No record");
            }
//            else
//            System.out.println(eventList.getEntry(find));
            menu();
        }
    }
//    }

    public void display() {
        int back;
        Scanner menu = new Scanner(System.in);
        if (eventList.isEmpty()) {
            System.out.println("No record found");
            menu();
        } else {

            do {

                for (int i = 1; i < eventList.EventTotal(); i++) {
                    // System.out.println("No" + (i + 1) + " " + current.data.toString() + " ");
                    System.out.println("No" + " " + eventList.getEntry(i).getEventNo() + " " + eventList.getEntry(i).getTitle()
                            + " " + eventList.getEntry(i).getDate() + " " + eventList.getEntry(i).getTime()
                            + " " + eventList.getEntry(i).getLocation() + " " + eventList.getEntry(i).getDescription()
                            + " " + eventList.getEntry(i).getFees());
                }
                System.out.println("Please press 0 to go back menu");

                back = menu.nextInt();
                menu();

            } while (back != 0);
//        

//if(!diss && eventList.isEmpty()){
//                 System.out.println("No record found");
//            }
        }

    }
}
