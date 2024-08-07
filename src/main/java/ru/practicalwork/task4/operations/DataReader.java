package ru.practicalwork.task4.operations;

import org.springframework.stereotype.Component;
import ru.practicalwork.task4.log.LogTransformation;
import ru.practicalwork.task4.model.Model;
import ru.practicalwork.task4.model.ReadFiles;

import java.io.File;
import java.util.Scanner;
import java.util.function.Supplier;

@Component
public class DataReader implements Supplier<Model> {

    @Override
    public Model get() {
        Model model = new Model();
        Scanner sc = new Scanner(System.in);

        String strURL = sc.next();
//        String strURL = "E:\\java\\PracticalWork\\tasks\\src\\main\\resources\\task4\\files";
        File filePath = new File(strURL);
        model.addModel(new ReadFiles().readingFromDir(filePath));

        return model;
    }
}
