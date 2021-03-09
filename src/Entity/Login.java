/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import ADT.MemberLinkedList;
import ADT.MemberListInterface;
import java.util.Scanner;

/**
 *
 * @author Jason
 */
public class Login {

    public static MemberListInterface<Member> memberList = new MemberLinkedList();
    static Scanner sc = new Scanner(System.in);

    private static void login() {
        System.out.print("Enter your username => ");
        String username = sc.nextLine();
        System.out.print("Enter your password => ");
        String password = sc.nextLine();
        if (memberList.login(username, password)) {
            System.out.print("Login Successful!\n");
            MemberHomepage();
        } else{
            forgotpassword();
        }
    }

    private static void forgotpassword() {
        System.out.print("Reset password by email => ");
        String email = sc.nextLine();
        Member m = memberList.forgotPassword(email);
        if (m != null) {
            System.out.print("Reset password => ");
            String newps = sc.nextLine();
            m.setPassword(newps);
            System.out.println("Your Password Reset Successfully!\n");

        } else {
            System.out.print("You are non-member please register first!\n");
        }
        //login();
    }

    public static void main(String[] args) {
        login();
    }

    private static void adminHomepage() {
        Scanner scanner = new Scanner(System.in);
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
            System.out.println("|         [1] Add Event                |");
            System.out.println("|         [2] Edit Event               |");
            System.out.println("|         [3] Delete Event             |");
            System.out.println("|         [4] Edit Member Profile      |");
            System.out.println("|         [0] Exit                     |");
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
            System.out.print(" Please enter a number => ");

            try {
                select = sc.nextInt();

                switch (select) {
                    case 1:
                        // Add();
                        break;
                    case 2:
                        //  Edit();
                        break;
                    case 3:
                        //  Delete();
                        break;
                    case 4:
                        //  EditmemberProfile();
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
                scanner.nextLine();
            }
        } while (select
                != 0);
    }

    private static void MemberHomepage() {
        Scanner scanner = new Scanner(System.in);
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
            System.out.println("|      Music Society HomePage     |");
            System.out.println("+---------------------------------+");
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            System.out.println("|     Please choose your selection ><  |");
            System.out.println("|         [1] Register an Event        |");
            System.out.println("|         [2] View Profile             |");
            System.out.println("|         [0] Exit                     |");
            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
            System.out.print(" Please enter a number => ");

            try {
                select = sc.nextInt();

                switch (select) {
                    case 1:
                        // EventPage();
                        break;
                    case 2:
                        //  memberProfile();
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
                scanner.nextLine();
            }
        } while (select
                != 0);
    }
}
