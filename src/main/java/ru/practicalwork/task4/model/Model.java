package ru.practicalwork.task4.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

public class Model {
    private List<UserInfo> listModel = new ArrayList<>();

    public List<UserInfo> getListModel() {
        return listModel;
    }

    public void addModel(List<String> list) {
        if (!list.isEmpty()) {
            for (String str : list) {
                this.listModel.add(addUserInfo(str));
            }
        }
    }

    private UserInfo addUserInfo(String str) {
        String[] userInfoArr = new String[6];
        int i = 0;
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        for (String s : str.split(" ")) {
            if (i != 4)
                userInfoArr[i++] = s;
            else {
                i++;
                try {
                    date = format.parse(s);
                } catch (ParseException e) {
                    continue;
                }
            }
        }
        return new UserInfo(userInfoArr[0], userInfoArr[1], userInfoArr[2], userInfoArr[3], date, userInfoArr[5]);
    }
}
