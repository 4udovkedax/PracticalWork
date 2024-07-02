package ru.practicalwork.task4.operations;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.practicalwork.task4.log.LogTransformation;
import ru.practicalwork.task4.log.SaveLogTransformation;
import ru.practicalwork.task4.model.Model;
import ru.practicalwork.task4.model.UserInfo;

import java.util.List;

@Component
@Order(300)
@LogTransformation
public class OperationCheckDate implements Operation{

    @Override
    public Model apply(Model model) {
        SaveLogTransformation logTransformation = new SaveLogTransformation();
        List<UserInfo> userInfoList = model.getListModel();

        for (int i = 0; i < userInfoList.size(); i++) {
            if (userInfoList.get(i).getDate() == null) {
                logTransformation.logTransformation("E:\\java\\PracticalWork\\tasks\\src\\main\\resources\\task4\\log_error_users.log", userInfoList.get(i).toString());
                userInfoList.remove(i);
            }
        }
        return model;
    }
}
