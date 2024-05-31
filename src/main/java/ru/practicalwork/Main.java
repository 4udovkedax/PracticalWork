package ru.practicalwork;

import ru.practicalwork.task1.Account;
import ru.practicalwork.task1.Currency;
import ru.practicalwork.task1.MethodAccount;

public class Main {
    public static void main(String[] args){
        Account acc = new Account("Vika");
        MethodAccount methodAccount = new MethodAccount(acc);
        methodAccount.run(a->a.setNameOwner("Macha"));
        methodAccount.run(a->a.setNameOwner("adadsasdads"));

        methodAccount.run(a->a.addSumCurrency(Currency.RUB,12));
        methodAccount.run(a->a.addSumCurrency(Currency.USD, 444));
        methodAccount.run(a->a.addSumCurrency(Currency.RUB, 333));

        System.out.println(acc.getSumCurrencyArr());

        acc = methodAccount.undo();
        acc = methodAccount.undo();
        acc = methodAccount.undo();
        acc = methodAccount.undo();
        acc = methodAccount.undo();
//        acc = methodAccount.undo();

        System.out.println("test: " + acc);
    }
}
