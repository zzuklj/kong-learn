package com.klj.konglearn.ioc.annotation;


import com.klj.konglearn.ioc.AbstractUserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.klj.konglearn.demo.transaction.JdbcDemo.*;

@Component
//@Service
//@Controller
//@Repository
public class ComponentUserService extends AbstractUserService {
    @Override
    public void hello(){
        System.out.println("i am from annotation @Component!");
    }

    @Transactional(rollbackFor = Exception.class)
    public void testTransaction(){
        try (
                Connection connection = DriverManager
                        .getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                Statement stmt = connection.createStatement()
        ) {
           // connection.setAutoCommit(false);
            String sql = "update tb_user set age = age+1 where id = 1";
            String sql2 = "update tb_user1 set age =age+1 where id = 2";
            stmt.execute(sql);
            stmt.execute(sql2);
            //connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}
