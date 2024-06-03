package ru.practicalwork.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Stack;

public class SaveTest {
    @Test
    @DisplayName("Проверка сохранения изменений по счету")
    public void testSaveLoad() {
        Account account = new Account("Vika");
        Account checkAccount = new Account("Petya");
        MethodAccount methodAccount = new MethodAccount(account);
        methodAccount.run(a->a.setNameOwner("Macha"));

        methodAccount.run(a->a.addSumCurrency(Currency.RUB,12));
        account.save("test1");
        methodAccount.run(a->a.addSumCurrency(Currency.USD, 444));
        methodAccount.run(a->a.addSumCurrency(Currency.RUB, 333));

        account = methodAccount.undo();
        account = methodAccount.undo();

        checkAccount.load("test1");

        System.out.println(account + " " + checkAccount);
        Assertions.assertEquals(account, checkAccount);
        //Assertions.assertEquals(account.getSumCurrencyArr(), checkAccount.getSumCurrencyArr());
    }
}
