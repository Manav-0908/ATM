package dao;

import model.BankAccount;
import java.io.*;

public class AccountDAO {
    private static final String FILE_NAME = "account.txt";

    public void saveAccount(BankAccount account) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(account.toString());
        } catch (IOException e) {
            System.out.println("Error saving account: " + e.getMessage());
        }
    }

    public BankAccount loadAccount() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return null;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String data = reader.readLine();
            if (data != null) {
                return BankAccount.fromString(data);
            }
        } catch (IOException e) {
            System.out.println("Error loading account: " + e.getMessage());
        }
        return null;
    }
}