package com.aiyuns;

import com.github.housepower.jdbc.BalancedClickhouseDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class FlinkClickHouse {

    public static  void main(String[] args){
        DataSource dualDataSource = new BalancedClickhouseDataSource("jdbc:clickhouse://192.168.1.7:9001,127.0.0.1:9000");
        try {
            Connection conn1 = dualDataSource.getConnection();
            conn1.createStatement().execute("CREATE DATABASE IF NOT EXISTS test");
            Connection conn2 = dualDataSource.getConnection();
            conn2.createStatement().execute("DROP TABLE IF EXISTS test.insert_test");
            conn2.createStatement().execute("CREATE TABLE IF NOT EXISTS test.insert_test (i Int32, s String) ENGINE = TinyLog");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
