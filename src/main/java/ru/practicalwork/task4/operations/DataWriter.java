package ru.practicalwork.task4.operations;

import org.springframework.stereotype.Component;
import ru.practicalwork.task4.repo.User;
import ru.practicalwork.task4.model.Model;
import ru.practicalwork.task4.model.UserInfo;
import ru.practicalwork.task4.repo.UserRepo;

import java.util.function.Consumer;

@Component
public class DataWriter implements Consumer<Model> {
//    private final UserRepo userRepository;
//
//    public DataWriter(UserRepo userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public void accept(Model model) {
        for (UserInfo userInfo : model.getListModel()) {
            User user = new User(1L, userInfo.getLogin(), userInfo.getLastName() + " " + userInfo.getName() + " " + userInfo.getSurName());
            //userRepository.save(user);
//            User user = saveAndGetUser(fl.getLogin(), fl.getLastName(), fl.getFirstName(), fl.getSurName());
//            addLogin(user, fl.getDateIn(), fl.getModule());
//        }
//
//        for (User u: usersToUpdate) {
//            uRepo.save(u);
        }
    }
}
