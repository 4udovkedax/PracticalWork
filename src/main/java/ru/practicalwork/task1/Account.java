package ru.practicalwork.task1;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Account implements Cloneable{
    @Getter
    private String nameOwner;
    @Getter
    private HashMap<Currency, Integer> sumCurrencyArr = new HashMap<>();

    public Account(String nameOwner) {
        this.nameOwner = checkName(nameOwner);
    }

    public void setNameOwner(String nameOwner) {
        this.nameOwner = checkName(nameOwner);
    }

    private String checkName(String nameOwner) {
        if (nameOwner == null || nameOwner == "") {
            throw new IllegalArgumentException("Имя владельца счета не может быть пустым");
        }
        return nameOwner;
    }

    public void addSumCurrency(Currency currency, int sum) {
        if (sum < 0)
            throw new IllegalArgumentException("Сумма валюты не может быть меньше нуля");
        this.sumCurrencyArr.put(currency, sum);
    }

    @Override
    public String toString() {
        return "Владелец счета: " + nameOwner + "; Колличество валюты: " + sumCurrencyArr + ";";
    }
}
