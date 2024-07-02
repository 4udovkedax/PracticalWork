package ru.practicalwork.task4.operations;

import org.springframework.stereotype.Component;
import ru.practicalwork.task4.log.LogTransformation;
import ru.practicalwork.task4.model.Model;
import ru.practicalwork.task4.model.ReadFiles;

import java.io.File;
import java.util.Scanner;
import java.util.function.Supplier;

@Component
@LogTransformation
public class DataReader implements Supplier<Model> {

    @Override
    public Model get() {
        Model model = new Model();
        Scanner sc = new Scanner(System.in);

        String strURL = sc.next();
        File filePath = new File(strURL);
        model.addModel(new ReadFiles().readingFromDir(filePath));

        return model;
    }
}
