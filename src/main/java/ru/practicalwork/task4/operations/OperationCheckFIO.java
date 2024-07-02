package ru.practicalwork.task4.operations;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.practicalwork.task4.model.Model;
import ru.practicalwork.task4.model.UserInfo;

@Component
@Order(100)
public class OperationCheckFIO implements Operation{

    @Override
    public Model apply(Model model) {
        for (UserInfo user : model.getListModel()) {
            user.setName(upperCaseFirst(user.getName()));
            user.setLastName(upperCaseFirst(user.getLastName()));
            user.setSurName(upperCaseFirst(user.getSurName()));
        }
        return model;
    }

    private String upperCaseFirst(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
}
