package com.klj.konglearn.demo.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

    public static String JDBC_URL, JDBC_USER, JDBC_PASSWORD;

    static {
        JDBC_URL = "jdbc:mysql://localhost:3306/db_test?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
        JDBC_USER = "root";
        JDBC_PASSWORD = "root";
    }

    public static void main(String[] args) {
        try (
                Connection connection = DriverManager
                        .getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                Statement stmt = connection.createStatement()
        ) {
            connection.setAutoCommit(false);
            String sql = "update tb_user set age = age+1 where id = 1";
            String sql2 = "update tb_user1 set age =age+1 where id = 2";
            stmt.execute(sql);
            stmt.execute(sql2);
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
