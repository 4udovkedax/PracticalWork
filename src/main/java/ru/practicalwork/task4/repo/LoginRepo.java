package ru.practicalwork.task4.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login, Long> {
}
