package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) {
        Connection c = null;
        Statement s = null;

        try {

            // 初始化jar包
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库加载成功");

            // 连接本地数据库
            c = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                    "root", "li720333");
            System.out.println("链接成功，获取对象： " + c);

            //创建statement对象，用于执行SQL语句
            s = c.createStatement();
            System.out.println("获取Statement对象： " + s);

            // 插入语句
            for (int i = 0; i <=100; i++) {
                String hero = "英雄" + i;
                String sql = "insert into hero values(null," + "'英雄"+i+"'" + "," + 313.0f + "," + 50 + ")";
                s.execute(sql);
            }
                System.out.println("执行插入语句成功");


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        } finally {
            // 关闭连接
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
