package ru.practicalwork.task4.operations;

import org.springframework.stereotype.Component;
import ru.practicalwork.task4.model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Component
public class OperationsMake {
    private Supplier<Model> datareader;
    private Consumer<Model> writer;
    private List<Operation> operations = new ArrayList<>();


    public OperationsMake(Supplier<Model> datareader, Consumer<Model> writer, List<Operation> operations) {
        this.datareader = datareader;
        this.writer = writer;
        this.operations = operations;
    }

    public void make() {
        Model model = datareader.get();
        for (Operation o : operations) {
            o.apply(model);
        }
        writer.accept(model);
    }
}
