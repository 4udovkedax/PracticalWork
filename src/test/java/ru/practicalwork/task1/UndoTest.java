package ru.practicalwork.task1;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UndoTest {

    @RepeatedTest(value = 5, name = "Проверка отката имени")
    @DisplayName("Проверка отката имени")
    public void testCheckName(RepetitionInfo repInfo) {
        String name = "Macha";
        String checkName = name;
        Account account = new Account(name);
        MethodAccount methodAccount = new MethodAccount(account);

        for (int i = 1; repInfo.getTotalRepetitions() >= i; i++ ) {
            String finalName = name + i;
            if (i == repInfo.getTotalRepetitions() - repInfo.getCurrentRepetition() + 1)
                checkName = account.getNameOwner();
            methodAccount.run(a->a.setNameOwner(finalName));
        }

        for (int i = repInfo.getCurrentRepetition(); i > 0 && i <= repInfo.getTotalRepetitions(); i--) {
            account = methodAccount.undo();
        }
        Assertions.assertEquals(account.getNameOwner(), checkName);
    }

    @Test
    @DisplayName("Проверка отката валюты")
    public void testCheckCurrency() {
        Account account = new Account("Macha");
        MethodAccount methodAccount = new MethodAccount(account);
        Stack<HashMap<Currency, Integer>> checkCurrencyArr = new Stack<>();
        int count = 1;

        for (Currency cur : Currency.values()) {
            int sumVal = count;
            checkCurrencyArr.push(account.getSumCurrencyArr());
            methodAccount.run(a->a.addSumCurrency(cur, sumVal));

            count++;
        }

        for (int i = count; i > 1; i--) {
            account = methodAccount.undo();
            Assertions.assertEquals(account.getSumCurrencyArr(), checkCurrencyArr.pop());
        }
    }

    @Test
    @DisplayName("Проверка, когда данных для отката больше нет")
    public void testCheckNameException() {
        MethodAccount methodAccount = new MethodAccount(new Account("Macha"));
        Assertions.assertThrows(IllegalArgumentException.class, methodAccount::undo);
    }
}
