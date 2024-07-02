package ru.practicalwork.task4.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Setter @Getter
public class UserInfo {
    private String login;
    private String lastName;
    private String name;
    private String surName;
    private Date date;
    private String app;

    public UserInfo(String login, String lastName, String name, String surName, Date date, String app) {
        this.login = login;
        this.lastName = lastName;
        this.name = name;
        this.surName = surName;
        this.date = date;
        this.app = app;
    }

    @Override
    public String toString() {
        return " login:" + login + ", lastName:" + lastName + ", name:" + name + ", surName:" + surName + ", date=" + date + ", app:" + app;
    }
}
