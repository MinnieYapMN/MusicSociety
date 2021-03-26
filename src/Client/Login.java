/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import ADT.*;
import ADT.MemberListInterface;
import Entity.*;
import java.util.Scanner;
import static Client.MusicSociety.*;


/**
 *
 * @author Ming Nee
 */
public class Login {


    public static void firstPage() {
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
            scanner.next();
        }

    }

    private static void login() {
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

    public static void Forgotpassword() {
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

    public static void adminHomepage() {
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
            System.out.println("|         [0] Exit                     |");
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
            System.out.print("Please enter a number => ");

            try {
                select = sc.nextInt();

                switch (select) {
                    case 1:
                        memberMaintainencePage();
                        break;
                    case 2:
//                        RegisterEvent();
                        break;
                    case 0:
                        System.out.println("\n=====================================");
                        System.out.println("    HAVE A NICE DAY! BYE-BYE >.<");
                        System.out.println("=====================================");
                        System.exit(0);
                    default:
                        System.out.println("**Please enter available options!**\n");
                }
            } catch (Exception e) {
                System.out.println("**Invalid Input! Please Re-enter Again!**\n");
                sc.next();
            }
        } while (select != 0);
    }

    private static void memberMaintainencePage() {
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

    private static void displayMembers() {
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

    private static void searchMember() {
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

    public static void registerNewMember() {
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

    private static void editMember() {
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

    private static void deleteMember() {
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

}
