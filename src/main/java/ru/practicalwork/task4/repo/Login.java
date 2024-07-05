package ru.practicalwork.task4.repo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Setter
@Getter
@Table(name = "logins")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "access_date")
    private Date date;

    @Column(name = "user_id")
    private Long user_id;

    @Column
    private String app;

    public Login() {
    }

    public Login(Long id, Date date, Long user_id, String app) {
        this.id = id;
        this.date = date;
        this.user_id = user_id;
        this.app = app;
    }
}
