package ru.practicalwork;

import ru.practicalwork.task1.*;

import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        Account acc = new Account("Vika");
        MethodAccount methodAccount = new MethodAccount(acc);
        methodAccount.run(a->a.setNameOwner("Macha"));
        methodAccount.run(a->a.setNameOwner("adadsasdads"));

        methodAccount.run(a->a.addSumCurrency(Currency.RUB,12));
        methodAccount.run(a->a.addSumCurrency(Currency.USD, 444));
        methodAccount.run(a->a.addSumCurrency(Currency.RUB, 333));

//        acc.save("test1");
//        System.out.println("test1: " + acc);
//
//        acc = methodAccount.undo();
//        acc = methodAccount.undo();
//        acc = methodAccount.undo();
//
//        acc.save("test2");
//        System.out.println("test2: " + acc);
//
//        acc = methodAccount.undo();
//        acc = methodAccount.undo();
//
//        System.out.println(acc);
//        acc.load("test1");
//        System.out.println(acc);
//        acc.load("test2");
//        System.out.println(acc);

        HashMap <Currency, Integer> sumCurrencyArrCopy = acc.getSumCurrencyArr();
        sumCurrencyArrCopy.put(Currency.EUR, 1);
        sumCurrencyArrCopy.put(Currency.RUB, 2);
        sumCurrencyArrCopy.put(Currency.USD, 3);

        System.out.println("sumCurrencyArrCopy=" + sumCurrencyArrCopy);
        System.out.println("acc.getSumCurrencyArr()=" + acc.getSumCurrencyArr());

        acc.save("test");
        acc.addSumCurrency(Currency.EUR, 1);
        acc.addSumCurrency(Currency.RUB, 2);
        acc.addSumCurrency(Currency.USD, 3);

        Account acc2 = new Account("qwe");
        acc2.load("test");
        acc2.addSumCurrency(Currency.EUR, 4);
        acc2.addSumCurrency(Currency.RUB, 5);
        acc2.addSumCurrency(Currency.USD, 6);

        acc.load("test");

        System.out.println(acc + " " + acc2);
    }
}
