package com.jin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

@SpringBootTest
public class DataApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        Connection conn = dataSource.getConnection();
        System.out.println(dataSource.getClass());
        conn.close();
    }
}
