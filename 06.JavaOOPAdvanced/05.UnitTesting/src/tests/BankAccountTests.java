package tests;

import models.BankAccount;
import models.BankAccountImpl;
import org.junit.Test;
import org.testng.Assert;


public class BankAccountTests {

    @Test
    public void depositShoutAddMoney() {
        BankAccount account = new BankAccountImpl(50);
        account.deposit(50);
        Assert.assertEquals(100, account.getBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawBankAccountWithNegativeAmount() {
        BankAccount account = new BankAccountImpl(5);
        account.withdraw(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawBankAccountWithBiggerAmountThanBalance() {
        BankAccount account = new BankAccountImpl(20);
        account.withdraw(40);
    }

    @Test
    public void testWithdrawBankAccount() {
        BankAccount account = new BankAccountImpl(2);
        account.withdraw(1);
        Assert.assertEquals(account.getBalance(), 1);
    }
}