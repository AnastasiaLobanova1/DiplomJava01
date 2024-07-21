package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    public void shouldAddPositive() {
        Account account = new Account();
        account.setBalance(0);
        Assertions.assertEquals(true, account.add(3_000));
    }

    @Test
    public void shouldAddNegative() {
        Account account = new Account();
        account.setBalance(0);
        Assertions.assertEquals(false, account.add(-1000));
    }

    @Test
    public void shouldAddZero() {
        Account account = new Account();
        account.setBalance(0);
        Assertions.assertEquals(false, account.add(0));
    }

    @Test
    public void shouldPayPositive() {
        Account account = new Account();
        account.setBalance(10000);
        Assertions.assertEquals(true, account.pay(3_000));
    }

    @Test
    public void shouldPayNegative() {
        Account account = new Account();
        account.setBalance(10000);
        Assertions.assertEquals(false, account.pay(-3_000));
    }

    @Test
    public void shouldPayZero() {
        Account account = new Account();
        account.setBalance(10000);
        Assertions.assertEquals(false, account.pay(0));
    }

    @Test
    public void shouldPayBalanceBeforeZero() {
        Account account = new Account();
        account.setBalance(10000);
        Assertions.assertEquals(false, account.pay(20000));
    }

    @Test
    public void shouldSetRate() {
        Account account = new Account();
        account.setRate(10);
        Assertions.assertEquals(10, account.getRate());
    }

    @Test
    public void testYearChange() {
        Account account = new Account();
        account.setBalance(10000);
        Assertions.assertEquals(0, account.yearChange());
    }
}
