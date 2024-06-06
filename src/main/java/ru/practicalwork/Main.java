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
        acc.addSumCurrency(Currency.EUR, 4);
        acc.addSumCurrency(Currency.RUB, 5);
        acc.addSumCurrency(Currency.USD, 6);

        Account acc2 = new Account("qwe");
        acc2.load("test");
        acc2.setNameOwner("Masha");

        acc2.addSumCurrency(Currency.EUR, 7);
        acc2.addSumCurrency(Currency.RUB, 8);
        acc2.addSumCurrency(Currency.USD, 9);

        acc.load("test");
        acc.setNameOwner("Misha");

        System.out.println(acc + " " + acc2);

        HashMap <Integer, Integer> test1 = new HashMap<>();
        HashMap <Integer, Integer> test2 = new HashMap<>();
        test1.put(1,1);
        test1.put(2,2);
        test1.put(3,3);


        test2 = (HashMap<Integer, Integer>) test1.clone();
        test2.put(1,4);
        test2.put(2,5);
        test2.put(3,6);
        test2.put(4,7);
        test1.put(5,8);

        System.out.println(test1 + " " + test2);
    }
}
