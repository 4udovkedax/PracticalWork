package ru.practicalwork.task1;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class Account {
    @Getter
    private String nameOwner;
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

    public Map<Currency, Integer> getSumCurrencyArr() {
        return (HashMap<Currency, Integer>) this.sumCurrencyArr.clone();
    }

    public void addSumCurrency(Currency currency, int sum) {
        if (sum < 0)
            throw new IllegalArgumentException("Количество валют не может быть меньше нуля");
        this.sumCurrencyArr.put(currency, sum);
    }

    @Override
    public String toString() {
        return "Владелец счета: " + nameOwner + "; Колличество валюты: " + sumCurrencyArr + ";";
    }
}
