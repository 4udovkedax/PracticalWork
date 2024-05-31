package ru.practicalwork;

import ru.practicalwork.task1.*;

public class Main {
    public static void main(String[] args){
        Account acc = new Account("Vika");
        MethodAccount methodAccount = new MethodAccount(acc);
        methodAccount.run(a->a.setNameOwner("Macha"));
        methodAccount.run(a->a.setNameOwner("adadsasdads"));

        methodAccount.run(a->a.addSumCurrency(Currency.RUB,12));
        methodAccount.run(a->a.addSumCurrency(Currency.USD, 444));
        methodAccount.run(a->a.addSumCurrency(Currency.RUB, 333));

        acc.save("test1");
        System.out.println("test1: " + acc);

        acc = methodAccount.undo();
        acc = methodAccount.undo();
        acc = methodAccount.undo();

        acc.save("test2");
        System.out.println("test2: " + acc);

        acc = methodAccount.undo();
        acc = methodAccount.undo();

        System.out.println(acc);
        acc.load("test1");
        System.out.println(acc);
    }
}
