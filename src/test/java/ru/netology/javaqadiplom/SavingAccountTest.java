package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );
        account.add(3000);
        Assertions.assertEquals(2000 + 3000, account.getBalance());
    }

    @Test
    public void shouldAddOverThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );
        account.add(13000);
        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void shouldAddBeforeNull() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );
        account.add(-2000);
        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void shouldPayOverThanMinBalance() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );
        account.pay(500);
        Assertions.assertEquals(2000 - 500, account.getBalance());
    }

    @Test
    public void shouldPayLessThanMinBalance() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );
        account.pay(5000);
        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void shouldPayBeforeNull() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );
        account.pay(-2000);
        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void testYearChange() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );
        int actual = account.yearChange();
        Assertions.assertEquals( 2000 / 100 * 5, actual);
    }

    @Test
    public void testRateBeforeNull() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            new SavingAccount(
                    2000,
                    1000,
                    10000,
                    -10
            );
        });
    }

    @Test
    public void testInitialBalanceBeforeNull() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            new SavingAccount(
                    -10,
                    1000,
                    10000,
                    5
            );
        });
    }

    @Test
    public void testMinBalanceBeforeNull() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            new SavingAccount(
                    2000,
                    -10,
                    10000,
                    5
            );
        });
    }

    @Test
    public void testMaxBalanceBeforeNull() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            new SavingAccount(
                    2000,
                    1000,
                    -10,
                    5
            );
        });
    }

    @Test
    public void testMaxBalanceLessMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            new SavingAccount(
                    2000,
                    10000,
                    1000,
                    5
            );
        });
    }

    @Test
    public void testInitialBalanceLessMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            new SavingAccount(
                    500,
                    1000,
                    10000,
                    5
            );
        });
    }

    @Test
    public void testInitialBalanceOverMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            new SavingAccount(
                    50000,
                    1000,
                    10000,
                    5
            );
        });
    }

    @Test
    public void testGetMinBalance() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );
        Assertions.assertEquals(1000, account.getMinBalance());
    }

    @Test
    public void testGetMaxBalance() {
        SavingAccount account = new SavingAccount(
                2000,
                1000,
                10000,
                5
        );
        Assertions.assertEquals(10000, account.getMaxBalance());
    }
}
