package com.bank;

import java.util.Scanner;

public class BankMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService service = new BankService();

        while (true) {

            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Delete Account");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account No: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Balance: ");
                    double balance = sc.nextDouble();

                    Account acc = new Account(accNo, name, balance);
                    service.createAccount(acc);
                    break;

                case 2:
                    System.out.print("Enter Account No and Amount: ");
                    service.deposit(sc.nextInt(), sc.nextDouble());
                    break;

                case 3:
                    System.out.print("Enter Account No and Amount: ");
                    service.withdraw(sc.nextInt(), sc.nextDouble());
                    break;

                case 4:
                    System.out.print("Enter Account No: ");
                    service.checkBalance(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Account No: ");
                    service.deleteAccount(sc.nextInt());
                    break;

                case 6:
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}