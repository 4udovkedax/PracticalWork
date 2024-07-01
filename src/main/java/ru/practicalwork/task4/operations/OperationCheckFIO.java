package ru.practicalwork.task4.operations;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.practicalwork.task4.model.Model;

@Component
@Order(100)
public class OperationCheckFIO implements Operation{

    @Override
    public Model apply(Model model) {
        System.out.println("OperationCheckFIO");
        return null;
    }
}
