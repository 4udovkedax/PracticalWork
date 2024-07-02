package ru.practicalwork.task4.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface UserRepo extends JpaRepository<User, Long> {

}
