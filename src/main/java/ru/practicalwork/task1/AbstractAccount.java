package ru.practicalwork.task1;

import java.util.List;

public class AbstractAccount {
    private String nameOwner;
    private List<Currency>[] curArr;
    private List<Integer>[] sumCurArr;

    public AbstractAccount(String nameOwner) {
        this.nameOwner = nameOwner;
    }
}
