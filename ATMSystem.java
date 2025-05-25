import model.BankAccount;
import dao.AccountDAO;
import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountDAO dao = new AccountDAO();
        BankAccount account = dao.loadAccount();

        if (account == null) {
            System.out.println("Welcome! Set up your new account.");
            System.out.print("Enter account holder name: ");
            String name = scanner.nextLine();
            System.out.print("Enter account number: ");
            String number = scanner.nextLine();
            System.out.print("Enter initial deposit amount: ₹");
            double balance = scanner.nextDouble();
            account = new BankAccount(name, number, balance);
            dao.saveAccount(account);
            System.out.println("Account created successfully!");
        }

        int choice;
        do {
            System.out.println("\n=== ATM MENU ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Show Account Info");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        account.deposit(depositAmount);
                        dao.saveAccount(account);
                        System.out.println("Amount deposited: ₹" + depositAmount);
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        dao.saveAccount(account);
                        System.out.println("Amount withdrawn: ₹" + withdrawAmount);
                    } else {
                        System.out.println("Invalid amount or insufficient balance.");
                    }
                    break;
                case 4:
                    System.out.println("Account Holder: " + account.getAccountHolder());
                    System.out.println("Account Number: " + account.getAccountNumber());
                    System.out.println("Balance: ₹" + account.getBalance());
                    break;
                case 0:
                    System.out.println("Thank you for using our ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}