package ui;

import dao.AccountDAO;
import model.Account;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMInterface {
    private final Scanner sc;
    private final AccountDAO dao;

    public ATMInterface() {
        sc = new Scanner(System.in);
        dao = new AccountDAO();
    }

    public void start() {
        System.out.print("Enter account number: ");
        String accNo = sc.nextLine().trim();

        Account account = dao.getAccount(accNo);

        if (account == null) {
            System.out.print("Account not found. Enter name to create a new account: ");
            String name = sc.nextLine().trim();
            account = new Account(accNo, name, 0.0);
            dao.addAccount(account);
            System.out.println("✅ New account created for " + name + ".");
        }

        int choice = -1;
        while (choice != 4) {
            try {
                System.out.println("\n--- ATM Menu ---");
                System.out.println("Welcome " + account.getName());
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1:
                        System.out.printf("💰 Balance: ₹%.2f\n", account.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double deposit = Double.parseDouble(sc.nextLine().trim());
                        if (deposit <= 0) {
                            System.out.println("⚠️ Invalid deposit amount.");
                        } else {
                            account.deposit(deposit);
                            dao.updateAccount(account);
                            System.out.println("Deposited ₹" + deposit);
                        }
                        break;
                    case 3:
                        System.out.print("Enter withdraw amount: ");
                        double withdraw = Double.parseDouble(sc.nextLine().trim());
                        if (withdraw <= 0) {
                            System.out.println(" Invalid withdrawal amount.");
                        } else if (account.withdraw(withdraw)) {
                            dao.updateAccount(account);
                            System.out.println(" Withdrew ₹" + withdraw);
                        } else {
                            System.out.println(" Insufficient balance.");
                        }
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM.");
                        break;
                    default:
                        System.out.println(" Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Please enter a valid number.");
            }
        }
    }
}
