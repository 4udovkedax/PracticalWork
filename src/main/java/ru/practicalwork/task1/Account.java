package ru.practicalwork.task1;

import lombok.Getter;
import java.util.HashMap;
import java.util.Objects;

public class Account{
    @Getter
    private String nameOwner;
    private HashMap<Currency, Integer> sumCurrencyArr = new HashMap<>();
    private static final SaveAccVersion saveAccVersion = new SaveAccVersion();

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
    public HashMap<Currency, Integer> getSumCurrencyArr() {
        return (HashMap<Currency, Integer>) this.sumCurrencyArr.clone();
    }

    public void addSumCurrency(Currency currency, int sum) {
        if (sum < 0)
            throw new IllegalArgumentException("Сумма валюты не может быть меньше нуля");
        this.sumCurrencyArr.put(currency, sum);
    }

    public void save(String nameSave) {
        this.saveAccVersion.setSaveAccountBuild(nameSave, new SaveAccount(this));
    }
    public void load(String nameSave) {
        SaveAccountBuild accountBuild = saveAccVersion.getSaveAccountBuild(nameSave);
        this.nameOwner = accountBuild.getNameOwner();
        this.sumCurrencyArr = accountBuild.getSumCurrencyArr();
    }

    @Override
    public String toString() {
        return "Владелец счета: " + nameOwner + "; Колличество валюты: " + sumCurrencyArr + ";";
    }

    private static class SaveAccount implements SaveAccountBuild{
        private String nameOwner;
        private HashMap<Currency, Integer> sumCurrencyArr = new HashMap<>();

        public SaveAccount(Account account) {
            this.nameOwner = account.getNameOwner();
            this.sumCurrencyArr = account.getSumCurrencyArr();
        }

        public String getNameOwner() {
            return this.nameOwner;
        }

        public HashMap<Currency, Integer> getSumCurrencyArr() {
            return (HashMap<Currency, Integer>) this.sumCurrencyArr.clone(); //new
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(nameOwner, account.nameOwner) && Objects.equals(sumCurrencyArr, account.sumCurrencyArr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOwner, sumCurrencyArr);
    }
}
