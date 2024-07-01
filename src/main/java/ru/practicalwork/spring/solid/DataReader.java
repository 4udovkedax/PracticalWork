package ru.practicalwork.spring.solid;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Scanner;
import java.util.function.Supplier;

@Component
public class DataReader implements Supplier<Model> {

    public DataReader(File file) {
    }

    @Override
    public Model get() {
        Model model = new Model();
        Scanner sc = new Scanner(System.in);

        model.op = sc.next();
        model.x = sc.nextInt();
        model.y = sc.nextInt();

        return model;
    }
}
