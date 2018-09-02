package models;

import models.BankAccount;

public class BankAccountImpl implements BankAccount {
    private int balance;

    public BankAccountImpl(int amount) {
        this.deposit(amount);
    }

    @Override
    public void deposit(int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        this.balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        if (amount < 1) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        if (amount > this.balance) {
            throw new IllegalArgumentException("insufficient availability");
        }

        this.balance -= amount;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }
}
