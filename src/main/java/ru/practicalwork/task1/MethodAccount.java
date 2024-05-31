package ru.practicalwork.task1;

import java.util.ArrayList;
import java.util.List;

public class MethodAccount {
    private List<RunMethodAccount> arrMethodAccount = new ArrayList<>();
    private String nameOwnerOld;
    private Account account;

    public MethodAccount(Account account) {
        this.account = account;
        this.nameOwnerOld = account.getNameOwner();
    }

    public void run(RunMethodAccount method) {
        method.run(this.account);
        this.arrMethodAccount.add(method);
    }

    public Account undo() {
        Account acc  = new Account(this.nameOwnerOld);
        if (arrMethodAccount.size() == 0)
            throw new IllegalArgumentException("Данных к откату больше нет");

        for (int i = 0; i < arrMethodAccount.size() - 1; i++) {
            arrMethodAccount.get(i).run(acc);
        }
        arrMethodAccount.removeLast();

        return acc;
    }

}
