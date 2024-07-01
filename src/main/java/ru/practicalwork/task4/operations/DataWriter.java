package ru.practicalwork.task4.operations;

import org.springframework.stereotype.Component;
import ru.practicalwork.task4.model.Model;

import java.util.function.Consumer;

@Component
public class DataWriter implements Consumer<Model> {
    @Override
    public void accept(Model model) {
        System.out.println("Запишем в БД");
    }
}
