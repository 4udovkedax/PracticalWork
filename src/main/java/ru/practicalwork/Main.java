package ru.practicalwork;

import ru.practicalwork.task1.Account;
import ru.practicalwork.task1.Currency;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Account acc = new Account("aasd");
        System.out.println(acc);
        acc.setNameOwner("Vika");
        System.out.println(acc.getNameOwner());
        acc.addSumCurrency(Currency.RUB, 12);
        acc.addSumCurrency(Currency.RUB, 123);
        acc.addSumCurrency(Currency.BYN, 22);
        Map<Currency, Integer> arr = acc.getSumCurrencyArr();
        arr.put(Currency.USD, 16);
        System.out.println(acc.getSumCurrencyArr());
        System.out.println(arr);

        acc.setNameOwner("null");
        System.out.println(acc);

    }
}
