package p01_define_bank_account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        Map<Integer, BankAccount> accounts = new HashMap<>();
        String line;

        while (true) {
            if ("End".equals(line = reader.readLine())) {
                break;
            }
            String[] commandArgs = line.split(" ");
            String command = commandArgs[0];
            int id = Integer.parseInt(commandArgs[1]);
            double amount = 0.0d;
            if (commandArgs.length == 3) {
                amount = Double.parseDouble(commandArgs[2]);
            }
            switch (command) {
                case "Create":
                    executeCreateCommand(accounts, id);
                    break;
                case "Deposit":
                    executeDeposit(accounts, id, amount);
                    break;
                case "Withdraw":
                    executeWithdraw(accounts, id, amount);
                    break;
                case "Print":
                    print(accounts, id);
                    break;
            }
        }
        String debug = "";
    }

    private static void executeCreateCommand(Map<Integer, BankAccount> accounts, int id) {
        if (accounts.containsKey(id)) {
            System.out.println("Account already exists");
        } else {
            BankAccount account = new BankAccount();
            account.setId(id);
            accounts.put(id, account);
        }
    }

    private static void executeDeposit(Map<Integer, BankAccount> accounts, int id, double amount) {
        BankAccount acc = accounts.get(id);
        if (acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void executeWithdraw(Map<Integer, BankAccount> accounts, int id, double amount) {
        BankAccount acc = accounts.get(id);
        if (acc != null) {
            try {
                acc.withdraw(amount);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void print(Map<Integer, BankAccount> account, int id) {
        if (account.get(id) != null) {
            System.out.println(account.get(id));
        } else {
            System.out.println("Account does not exist");
        }
    }
}
