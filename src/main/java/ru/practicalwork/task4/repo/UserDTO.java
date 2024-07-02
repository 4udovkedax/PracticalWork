package ru.practicalwork.task4.repo;

import org.springframework.stereotype.Component;

import java.sql.*;

public class UserDTO {
    private static String sql = "insert into users values(?, ?, ?)";
    public static void save(User user, int id) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "new_pasword");

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getFio());
            ps.execute();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
