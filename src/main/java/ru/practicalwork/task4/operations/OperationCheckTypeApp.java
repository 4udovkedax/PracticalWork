package ru.practicalwork.task4.operations;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.practicalwork.task4.log.LogTransformation;
import ru.practicalwork.task4.model.Model;
import ru.practicalwork.task4.model.UserInfo;

@Component
@Order(200)
@LogTransformation
public class OperationCheckTypeApp implements Operation{

    @Override
    public Model apply(Model model) {
        String typeApp = null;
        for (UserInfo user : model.getListModel()) {
            typeApp = user.getApp();
            if (!typeApp.equals("web") && !typeApp.equals("mobile"))
                user.setApp("other: " + typeApp);
        }
        return model;
    }
}
