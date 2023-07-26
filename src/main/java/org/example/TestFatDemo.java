package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @作者：龙
 * @日期 2023/7/24
 */
public class TestFatDemo {
    public static void main(String[] args) throws Exception{
        // 创建链接
        String url = "jdbc:phoenix:192.168.30.129:2181";
        Connection connection = DriverManager.getConnection(url);
        // 获取Statement
        // PreparedStatement 比 Statement 更加安全，可以有效方式sql注入的风险
        PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
        // sql语句的执行
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("addr"));
        }
        // 关闭连接等
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
