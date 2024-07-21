package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    public void shouldTransferPositive() {
        Account accountFrom = new Account();
        accountFrom.setBalance(1000);
        Account accountTo = new Account();
        accountTo.setBalance(1000);
        Bank bank = new Bank();
        Assertions.assertEquals(true, bank.transfer(accountFrom, accountTo, 100));
    }

    @Test
    public void shouldTransferNegative() {
        Account accountFrom = new Account();
        accountFrom.setBalance(1000);
        Account accountTo = new Account();
        accountTo.setBalance(1000);
        Bank bank = new Bank();
        Assertions.assertEquals(false, bank.transfer(accountFrom, accountTo, -100));
    }

    @Test
    public void shouldTransferZero() {
        Account accountFrom = new Account();
        accountFrom.setBalance(1000);
        Account accountTo = new Account();
        accountTo.setBalance(1000);
        Bank bank = new Bank();
        Assertions.assertEquals(false, bank.transfer(accountFrom, accountTo, 0));
    }

    @Test
    public void shouldTransferBalanceBeforeZero() {
        Account accountFrom = new Account();
        accountFrom.setBalance(1000);
        Account accountTo = new Account();
        accountTo.setBalance(1000);
        Bank bank = new Bank();
        Assertions.assertEquals(true, bank.transfer(accountFrom, accountTo, 2000));
    }
}
