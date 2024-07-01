package ru.practicalwork.spring.solid;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class Begin {
    private final Date date = new Date();

    public Begin() {
    }

    public Date getDate() {
        return date;
    }
}
