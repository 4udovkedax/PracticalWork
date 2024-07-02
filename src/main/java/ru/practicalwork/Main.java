package ru.practicalwork;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.practicalwork.task4.model.Model;
import ru.practicalwork.task4.model.ReadFiles;
import ru.practicalwork.task4.operations.OperationCheckDate;
import ru.practicalwork.task4.operations.OperationCheckFIO;
import ru.practicalwork.task4.operations.OperationsMake;
import ru.practicalwork.task4.repo.User;
import ru.practicalwork.task4.repo.UserRepo;

import java.io.File;
import java.sql.*;

@SpringBootApplication(scanBasePackages = "ru.practicalwork.task4")
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ApplicationContext context = new AnnotationConfigApplicationContext("ru.practicalwork.task4");
        context.getBean("operationsMake", OperationsMake.class).make();


//        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "new_pasword");
//        Statement stat = con.createStatement();
//        stat.executeQuery("insert into users values(1, 'test', 'test2')");

//        System.out.println(con);

//        ApplicationContext context = SpringApplication.run(Main.class);
//        UserRepo ur = context.getBean(UserRepo.class);
//        User u = new User();
////        u.setId(null);
//        ur.save(new User(null, "testtt", "testtttt"));
        //SpringApplication.run(Main.class, args);

//        context.getBean("operationsMake", OperationsMake.class).make();
//        UserRepo repo = context.getBean(UserRepo.class);
//        Connection conn = null;
//        Class.forName("org.postgresql.Driver");
//        conn = DriverManager.getConnection("http://localhost:5432/", "postgres", "new_pasword");
        //SpringApplication.run(Main.class, args);

        //UserRepository repo = context.getBean(UserRepository.class);
//        DataSource ds = context.getBean(DataSource.class);
//        System.out.println(ds);
        //UserRepo ur = context.getBean(UserRepo.class);

        //SpringApplication.run(Main.class, args);
//
//        ReadFiles readFiles = new ReadFiles();
//        List<String> str = readFiles.readingFromDir(new File("E:\\java\\PracticalWork\\tasks\\src\\main\\resources\\task4\\files"));
//        for (String s : str) {
//            System.out.println(s);
//        }
//
//        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "new_pasword");
//        System.out.println(con);


        //E:\java\PracticalWork\tasks\src\main\resources\task4\files

//        String str = "user1 ванов ван Иванович 25.01.2024 web";
//        for (String s : str.split(" ")) {
//          String c = s.substring(0,1).toUpperCase();
//            System.out.println(s.substring(0,1).toUpperCase() + s.substring(1));
//        }
//        System.out.println(str);

//        Date date = new Date();
//        String date = "21.05.2024w 21:12";
//        DateFormat dateFormat = new SimpleDateFormat(date);
//        System.out.println(date + " " + dateFormat.toString());

//        Connection con = DriverManager.getConnection("http://localhost:5432/", "postgres", "new_pasword");
//        System.out.println("test: " + con);


//        ApplicationContext context = new AnnotationConfigApplicationContext("ru.practicalwork.spring.solid");
//        context.getBean("hello", Hello.class).printHello();
//
//        System.out.println(context.getBean("begin", Begin.class).getDate());


        //System.out.println(context.getBean("test", Test.class).getStr());


//        new AnnotationConfigApplicationContext("ru.practicalwork.spring.solid")
//                .getBean("operationMaker", OperationMaker.class)
//                .make();

//        int z = new ObjectComposer("ru.practicalwork.spring.solid")
//                .getObjectByNameAndType("+", PlusOperation.class).apply(3,4);
//        System.out.println(z);

//                .getObjectByNameAndType("OperationMaker", OperationMaker.class)
//                .make();



//        OperationMaker operationMaker = new OperationMaker();
//        operationMaker.datareader = new DataReader();
//        operationMaker.operations.put("+", new PlusOperation());
//        operationMaker.operations.put("-", new MinusOperation());
//        operationMaker.printer = new Printer();
//        operationMaker.make();



//        Scanner sc = new Scanner(System.in);
//        String operation = sc.next();
//
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        int res = 0;
//
//        switch (operation) {
//            case "+":
//                res = x + y;
//                break;
//            case "-":
//                res = x - y;
//                break;
//            case "*":
//                res = x * y;
//                break;
//            case "/":
//                res = x / y;
//                break;
//        }
//        System.out.println(x + operation + y + " = " + res);

    }
//    @Bean
//    CommandLineRunner runner(UserRepo repository) {
//        return args -> {
//
//            User person = new User();
//            person.setUserName("test");
//            person.setFio("test2");
//
//            System.out.println("начало");
//            repository.save(person);
//            Object NoSuchElementException;
//            User saved = repository.findById(person.getId()).get();
//            //System.out.println("что-то выполнили" + saved);
//            System.out.println("конец");
//        };
//    }
}
