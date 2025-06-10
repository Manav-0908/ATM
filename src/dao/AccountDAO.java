package dao;

import io.FileHandler;
import model.Account;
import java.util.*;

public class AccountDAO {
    private Map<String, Account> accounts;

    public AccountDAO() {
        this.accounts = FileHandler.loadAccounts();
    }

    public Account getAccount(String accNo) {
        return accounts.get(accNo);
    }

    public void updateAccount(Account acc) {
        accounts.put(acc.getAccountNumber(), acc);
        FileHandler.saveAccounts(accounts);
    }

    public void addAccount(Account acc) {
        accounts.put(acc.getAccountNumber(), acc);
        FileHandler.saveAccounts(accounts);
    }

    public boolean accountExists(String accNo) {
        return accounts.containsKey(accNo);
    }
}
