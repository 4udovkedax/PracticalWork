package ru.practicalwork.task4.repo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "users")
public class User {
    @Id
    private Long id;
    @Column(name = "username")
    private String userName;
    @Column(name = "fio")
    private String fio;

    public User() {
    }

    public User(Long id, String userName, String fio) {
        this.id = id;
        this.userName = userName;
        this.fio = fio;
    }

}
