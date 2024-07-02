package ru.practicalwork.task4.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepo extends CrudRepository<User, Long> {

}
