package ru.practicalwork.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.HashMap;

public class AccountTest {
    @Test
    @DisplayName("Проверка корректного имени владельца счета")
    public void testAccountOwnerName() {
        Account account = new Account("Petr");
        Assertions.assertEquals(account.getNameOwner(), "Petr");
        String newName = "Ivan";
        account.setNameOwner(newName);
        Assertions.assertEquals(account.getNameOwner(), newName);
    }

    @Test
    @DisplayName("Проверка некорректного имени владельца счета")
    public void testAccountIncorrectOwnerName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Account(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Account(null));
        Account account = new Account("Petr");
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.setNameOwner(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Account(null));
    }

    @Test
    @DisplayName("Проверка добавления валюты")
    public void testAddCurrency() {
        Account account = new Account("Petr");
        HashMap<Currency, Integer> newCurrencyArr = new HashMap<>();
        int count = 1;
        for (Currency cur : Currency.values()) {
            account.addSumCurrency(cur, count);
            newCurrencyArr.put(cur, count++);
        }
        Assertions.assertEquals(account.getSumCurrencyArr(), newCurrencyArr);
    }

    @Test
    @DisplayName("Проверка изменения количества валюты")
    public void testChangeCurrency() {
        Account account = new Account("Petr");
        HashMap<Currency, Integer> comparCurrencyArr = new HashMap<>();
        HashMap<Currency, Integer> changeCurrencyArr = new HashMap<>();
        int count = 1;
        System.out.println();
        for (Currency cur : Currency.values()) {
            account.addSumCurrency(cur, count++);
            comparCurrencyArr.put(cur, 100 + count);
        }
        for (Currency cur : Currency.values()) {
            account.addSumCurrency(cur, comparCurrencyArr.get(cur));
        }
        Assertions.assertEquals(account.getSumCurrencyArr(), comparCurrencyArr);

        changeCurrencyArr = account.getSumCurrencyArr();
        for (Currency cur : Currency.values()) {
            changeCurrencyArr.put(cur, 0);
        }
        Assertions.assertEquals(account.getSumCurrencyArr(), comparCurrencyArr);
    }

    @Test
    @DisplayName("Проверка отрицательного значения для валюты")
    public void testNegativeCurrency() {
        Account account = new Account("Petr");
        for (Currency cur : Currency.values()) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> account.addSumCurrency(cur, -1));
        }
    }
}
