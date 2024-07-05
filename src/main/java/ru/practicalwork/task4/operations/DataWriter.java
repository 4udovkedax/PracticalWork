package ru.practicalwork.task4.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.practicalwork.task4.repo.*;
import ru.practicalwork.task4.model.Model;
import ru.practicalwork.task4.model.UserInfo;

import java.sql.SQLException;
import java.util.function.Consumer;

@Component
public class DataWriter implements Consumer<Model> {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private LoginRepo loginRepo;

    @Override
    public void accept(Model model) {
        //int i = 0;
        for (UserInfo userInfo : model.getListModel()) {
            User user = new User(null, userInfo.getLogin(), userInfo.getLastName() + " " + userInfo.getName() + " " + userInfo.getSurName());
            //i++;
            userRepo.save(user);
            Login login = new Login(null, userInfo.getDate(), user.getId(), userInfo.getApp());
            loginRepo.save(login);
//            try {
//                UserDTO.save(user, i);
//                LoginDTO.save(login, i);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}
