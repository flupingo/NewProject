package com.Mybatis.demon.Client;

import Fundation.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created：Jeffrey
 * date   ：2020/7/6 10:13
 */
public class JDBCConnect {
    public static void main(String[] args) {
        try {
            //====创建java-mysql连接====《数据库连接池》
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.================建立mysql的连接对象(和其他大数据等服务一样)！！！！=================
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema0409","root","123456");

            //====通过连接对象执行查询任务====《JdbcTemplate》
            //3.执行sql
            PreparedStatement pre = connection.prepareStatement("select * from cinema where cid=?");
            pre.setString(1,"'1 or 1=1'");

            //4.结果集
            ResultSet resultSet = pre.executeQuery();
            //5.遍历结果集
            List<User> userList = new ArrayList<User>();
            while (resultSet.next()) {
                User obj = (User) Class.forName("com.Mybatis.demon.entity.User").newInstance();//根据User.xml里namespace
                //resultSet值通过反射赋给obj
                userList.add(obj);
            }
            //6.返回List

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
