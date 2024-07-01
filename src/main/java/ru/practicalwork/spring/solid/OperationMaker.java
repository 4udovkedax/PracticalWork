package ru.practicalwork.spring.solid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Component
public class OperationMaker {
    @Autowired
    public Supplier<Model> datareader;
    @Autowired
    public Consumer<Model> printer;
    @Autowired
    public Map<String, BinaryOperator<Integer>> operations = new HashMap<>();

    public void make(File file) {
        Model model  = datareader.get();
        model.res = operations.get(model.op).apply(model.x, model.y);
        printer.accept(model);
        //1 - читаем
        //Supplier supplier;
        //2 - выполняем
        //Consumer consumer;
        //3 - выводим
        //BinaryOperator bo;
    }
}
