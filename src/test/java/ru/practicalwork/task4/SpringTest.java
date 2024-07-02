package ru.practicalwork.task4;

import org.junit.Test;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import ru.practicalwork.Main;
import ru.practicalwork.task4.model.Model;
import ru.practicalwork.task4.model.ReadFiles;
import ru.practicalwork.task4.model.UserInfo;
import ru.practicalwork.task4.operations.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SpringTest {
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine");

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Test
    @DisplayName("Проверка запука")
    public void test() {
        System.out.println("Ok");
    }

    @Test
    @DisplayName("Проверка заругзки файла")
    public void LoadFile() {
        ReadFiles readFiles = new ReadFiles();

        List<String> list1 = readFiles.readingFromDir(new File("E:\\java\\PracticalWork\\tasks\\src\\main\\resources\\task4\\files"));
        Assertions.assertEquals(list1.stream().count(), 6);

        List<String> list2 = readFiles.readingFromDir(new File("E:\\test"));
        Assertions.assertEquals(list2.stream().count(), 0);
    }

    @Autowired
    OperationCheckFIO operationCheckFIO;
    @Test
    @DisplayName("Проверка наличия даты")
    public void CheckFIO() {
        Model model = new Model();
        List<String> lst = new ArrayList<>();
        lst.add("User3 ретрова анна владимирона 21.03.2024 desktop_app");
        model.addModel(lst);

        model = operationCheckDate.apply(model);
        for (UserInfo user : model.getListModel()) {
            Assertions.assertEquals(user.getLastName(), "Р");
            Assertions.assertEquals(user.getName(), "А");
            Assertions.assertEquals(user.getSurName(), "В");
        }
    }

    @Autowired
    OperationCheckDate operationCheckDate;
    @Test
    @DisplayName("Проверка наличия даты")
    public void CheckDate() {
        Model model = new Model();
        ReadFiles readFiles = new ReadFiles();
        model.addModel(readFiles.readingFromDir(new File("E:\\java\\PracticalWork\\tasks\\src\\main\\resources\\task4\\files")));

        model = operationCheckDate.apply(model);
        Assertions.assertEquals(model.getListModel().size(), 5);
    }

    @Autowired
    DataWriter dataWriter;
    @Test
    @DisplayName("Проверка записи в БД")
    public void SaveBD() {
        Model model = new Model();
        ReadFiles readFiles = new ReadFiles();
        model.addModel(readFiles.readingFromDir(new File("E:\\java\\PracticalWork\\tasks\\src\\main\\resources\\task4\\files")));

        dataWriter.accept(model);
    }
}
