package ru.practicalwork.task4.operations;

import org.springframework.stereotype.Component;
import ru.practicalwork.task4.repo.*;
import ru.practicalwork.task4.model.Model;
import ru.practicalwork.task4.model.UserInfo;

import java.sql.SQLException;
import java.util.function.Consumer;

@Component
public class DataWriter implements Consumer<Model> {
    @Override
    public void accept(Model model) {
        int i = 0;
        for (UserInfo userInfo : model.getListModel()) {
            User user = new User(null, userInfo.getLogin(), userInfo.getLastName() + " " + userInfo.getName() + " " + userInfo.getSurName());
            Login login = new Login(null, userInfo.getDate(), userInfo.getApp());
            i++;
            try {
                UserDTO.save(user, i);
                LoginDTO.save(login, i);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
