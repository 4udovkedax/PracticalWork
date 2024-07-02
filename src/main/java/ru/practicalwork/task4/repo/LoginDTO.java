package ru.practicalwork.task4.repo;

import java.sql.*;

public class LoginDTO {
    private static String sql = "insert into logins values(?, ?, ?, ?)";
    public static void save(Login login, int id) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "new_pasword");
        Timestamp timestamp = new Timestamp(login.getDate().getTime());
        System.out.println(login.getDate());
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setTimestamp(2, timestamp);
            ps.setInt(3, id);
            ps.setString(4, login.getApp());
            ps.execute();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
