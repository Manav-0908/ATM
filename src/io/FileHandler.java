package io;

import model.Account;

import java.io.*;
import java.util.*;

public class FileHandler {
    private static final String FILE_PATH = "accounts.txt";

    public static Map<String, Account> loadAccounts() {
        Map<String, Account> accounts = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String accNo = data[0];
                String name = data[1];
                double balance = Double.parseDouble(data[2]);
                accounts.put(accNo, new Account(accNo, name, balance));
            }
        } catch (IOException e) {
            System.out.println("No accounts found, starting fresh.");
        }
        return accounts;
    }

    public static void saveAccounts(Map<String, Account> accounts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Account acc : accounts.values()) {
                writer.write(acc.getAccountNumber() + "," + acc.getName() + "," + acc.getBalance());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving accounts.");
        }
    }
}
