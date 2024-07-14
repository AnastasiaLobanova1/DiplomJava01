package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void rateIsNegative() {
        int exceptionCounter = 0;
        try {
            CreditAccount account = new CreditAccount(0, 20000, -10);
            exceptionCounter++;
        } catch (IllegalArgumentException e) {
            exceptionCounter--;
        }
        int expected = -1;
        int actual = exceptionCounter;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void rateIsPositive() {
        int exceptionCounter = 0;
        try {
            CreditAccount account = new CreditAccount(0, 20000, 10);
            exceptionCounter++;
        } catch (IllegalArgumentException e) {
            exceptionCounter--;
        }
        int expected = 1;
        int actual = exceptionCounter;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void rateIsLessToZeroByOne() {
        int exceptionCounter = 0;
        try {
            CreditAccount account = new CreditAccount(0, 20000, -1);
            exceptionCounter++;
        } catch (IllegalArgumentException e) {
            exceptionCounter--;
        }
        int expected = -1;
        int actual = exceptionCounter;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void rateIsOverToZeroByOne() {
        int exceptionCounter = 0;
        try {
            CreditAccount account = new CreditAccount(0, 20000, 1);
            exceptionCounter++;
        } catch (IllegalArgumentException e) {
            exceptionCounter--;
        }
        int expected = 1;
        int actual = exceptionCounter;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void creditLimitIsNegative() {
        int exceptionCounter = 0;
        try {
            CreditAccount account = new CreditAccount(0, -20000, 10);
            exceptionCounter++;
        } catch (IllegalArgumentException e) {
            exceptionCounter--;
        }
        int expected = -1;
        int actual = exceptionCounter;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void creditLimitIsPositive() {
        int exceptionCounter = 0;
        try {
            CreditAccount account = new CreditAccount(0, 20000, 10);
            exceptionCounter++;
        } catch (IllegalArgumentException e) {
            exceptionCounter--;
        }
        int expected = 1;
        int actual = exceptionCounter;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void creditLimitIsLessToZeroByOne() {
        int exceptionCounter = 0;
        try {
            CreditAccount account = new CreditAccount(0, -1, 10);
            exceptionCounter++;
        } catch (IllegalArgumentException e) {
            exceptionCounter--;
        }
        int expected = -1;
        int actual = exceptionCounter;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void creditLimitIsOverToZeroByOne() {
        int exceptionCounter = 0;
        try {
            CreditAccount account = new CreditAccount(0, 1, 10);
            exceptionCounter++;
        } catch (IllegalArgumentException e) {
            exceptionCounter--;
        }
        int expected = 1;
        int actual = exceptionCounter;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void initialBalanceIsNegative() {
        int exceptionCounter = 0;
        try {
            CreditAccount account = new CreditAccount(-1000, 20000, 10);
            exceptionCounter++;
        } catch (IllegalArgumentException e) {
            exceptionCounter--;
        }
        int expected = -1;
        int actual = exceptionCounter;
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void initialBalanceIsLessToZeroByOne() {
        int exceptionCounter = 0;
        try {
            CreditAccount account = new CreditAccount(-1, 20000, 10);
            exceptionCounter++;
        } catch (IllegalArgumentException e) {
            exceptionCounter--;
        }
        int expected = -1;
        int actual = exceptionCounter;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void initialBalanceIsOverToZeroByOne() {
        int exceptionCounter = 0;
        try {
            CreditAccount account = new CreditAccount(1, 20000, 10);
            exceptionCounter++;
        } catch (IllegalArgumentException e) {
            exceptionCounter--;
        }
        int expected = 1;
        int actual = exceptionCounter;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void initialBalanceIsPositive() {
        int exceptionCounter = 0;
        try {
            CreditAccount account = new CreditAccount(1000, 20000, 10);
            exceptionCounter++;
        } catch (IllegalArgumentException e) {
            exceptionCounter--;
        }
        int expected = 1;
        int actual = exceptionCounter;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void payAmountIsNegative() {
        CreditAccount account = new CreditAccount(1000, 20000, 10);
        boolean expected = false;
        boolean actual = account.pay(-5000);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void payAmountIsLessToZeroByOne() {
        CreditAccount account = new CreditAccount(1000, 20000, 10);
        boolean expected = false;
        boolean actual = account.pay(-1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void payAmountLessThanCreditLimit() {
        CreditAccount account = new CreditAccount(1000, 20000, 10);
        boolean expected = true;
        boolean actual = account.pay(10000);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void payAmountEqualCreditLimit() {
        CreditAccount account = new CreditAccount(1000, 20000, 10);
        boolean expected = true;
        boolean actual = account.pay(21000);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void payAmountMoreThanCreditLimit() {
        CreditAccount account = new CreditAccount(1000, 20000, 10);
        boolean expected = false;
        boolean actual = account.pay(30000);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addAmountIsNegative() {
        CreditAccount account = new CreditAccount(1000, 20000, 10);
        boolean expected = false;
        boolean actual = account.add(-5000);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void addAmountIsZero() {
        CreditAccount account = new CreditAccount(1000, 20000, 10);
        boolean expected = false;
        boolean actual = account.add(0);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void addAmountIsPositive() {
        CreditAccount account = new CreditAccount(1000, 20000, 10);
        boolean expected = true;
        boolean actual = account.add(5000);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void yearChangeBalanceIsPositive() {
        CreditAccount account = new CreditAccount(1000, 20000, 10);
        int expected = 0;
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void yearChangeBalanceIsZero() {
        CreditAccount account = new CreditAccount(0, 20000, 10);
        int expected = 0;
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void yearChangeBalanceIsNegative() {
        CreditAccount account = new CreditAccount(1000, 20000, 10);
        account.pay(2000);
        int expected = -100;
        int actual = account.yearChange();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldAddToCreditLimit() {
        CreditAccount account = new CreditAccount(
                1000,
                1000,
                15
        );

        int expected = 1000;
        int actual = account.getCreditLimit();
        Assertions.assertEquals(expected, actual);
    }

}


