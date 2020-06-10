package com.hy.tt.mysql;



import java.sql.*;

/**
 * @author thy
 * @date 2020/4/16
 */
public class InsertData {


    public static void main(String[] args) throws SQLException {
        String sql = "insert into employees (birth_date, first_name, last_name,gender,hire_date) values ( ?, ?, ?,?, ?)";
        Conn conn = new Conn();
        Connection connection = conn.getConnection();
        // 将连接的自动提交关闭，数据在传送到数据库的过程中相当耗时
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try{
            long start = System.currentTimeMillis();
            for (int i = 1; i < 11; i++) {
                long start2 = System.currentTimeMillis();
                for (int j = 1; j < 100001; j++) {
                    int a = (i-1)*1000 + j;
                    preparedStatement.setDate(1,  new Date(System.currentTimeMillis()));
                    preparedStatement.setString(2,"tt"+a);
                    preparedStatement.setString(3,"yy"+a);
                    preparedStatement.setString(4,"M");
                    preparedStatement.setDate(5, new Date(System.currentTimeMillis()));
                    //加入批处理
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
                connection.commit();
                long end2 = System.currentTimeMillis();
                // 批量执行一次批量打印执行依次的时间
                System.out.print("inner"+i+": ");
                System.out.println(end2 - start2);
            }
            long end = System.currentTimeMillis();
            System.out.print("total: ");
            System.out.println(end - start);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.freeConnection(connection);
        }


    }


}
