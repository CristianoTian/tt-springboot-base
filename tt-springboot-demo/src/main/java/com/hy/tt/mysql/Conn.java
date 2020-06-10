package com.hy.tt.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author thy
 * @date 2020/4/16
 */
public class Conn {

    private static final String URL = "jdbc:mysql://dev-test-01.db.internal.forwardx.com:3306/dev_ovis_cluster_system?useUnicode=true&characterEncoding=utf8&useSSL=false";
    private static final String USERNAME = "dev_ovis";
    private static final String PASSWORD = "SK0XOylSMZvxjdXJ";
    Connection connection;

    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("connect success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void freeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
