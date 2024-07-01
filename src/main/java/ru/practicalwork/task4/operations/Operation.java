package ru.practicalwork.task4.operations;

import ru.practicalwork.task4.model.Model;
import ru.practicalwork.task4.model.ReadFiles;

public interface Operation {
    public Model apply(Model model);
}
