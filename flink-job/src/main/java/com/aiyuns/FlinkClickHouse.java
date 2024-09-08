package com.aiyuns;

import com.github.housepower.jdbc.BalancedClickhouseDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlinkClickHouse {

    public static  void main(String[] args){
        DataSource dualDataSource = new BalancedClickhouseDataSource("jdbc:clickhouse://192.168.1.7:9001,127.0.0.1:9000/default");
        try {
            Connection conn = dualDataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("select * from test");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // 假设表中有id和name字段
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
