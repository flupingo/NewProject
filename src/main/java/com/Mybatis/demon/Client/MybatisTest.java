package com.Mybatis.demon.Client;

import com.Mybatis.demon.Dao.UserDao;
import com.Mybatis.demon.entity.User;
import com.Mybatis.demon.entity.UserVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Mybatis的执行原理
 * Created：Jeffrey
 * date   ：2020/7/6 10:56
 */
public class MybatisTest {
    private static InputStream in;
    private static SqlSession sqlSession;
    private static UserDao userDao;

    public static void main(String[] args) {
        try {
            init();
            //1.查询
            List<User> list = userDao.findAll();
            for (User user : list) {
                System.out.println(user.toString());
            }
            //2.保存
//            User user=new User("小儿",new Date(),"苏州","男");
//            List<User>list=new ArrayList<User>();
//            list.add(user);
//            userDao.saveUser(user);
            //3.修改
//            User user1=new User("赵六",new Date(),"苏州","男");
//            userDao.update(user1);
            //4.删除
//            userDao.delete(5);
            //5.根据Id查询用户
//            User user2=userDao.findUserById(1);
//            System.out.println(user2.toString());
            //6.模糊匹配
            List<User> list1 = userDao.findUserByName("%张%");
//            System.out.println(list1);
            //7.查询条数
//            System.out.println(userDao.findCountById(7));
            //8.查询插入的最后一条数据的Id
            User user = new User("三六", new Date(), "广州", "女");
//            System.out.println("lastId:"+userDao.selectLastId(user));

            //9 if标签
//            List<User> conditionUser = userDao.findByCondition("赵六");
//            System.out.println(conditionUser.toString());

            //10.forEach
            List<String> userList = new ArrayList<String>();
            userList.add("李美丽");
            userList.add("赵六");
//            System.out.println(userDao.findByIn(userList));

            //11.包装实体对象传参
            User userr = new User();
            userr.setName("%张%");
            List<User> listt = userDao.findUserByUserVo(new UserVo(userr));
            System.out.println(listt);

            destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void init() {
        try {
            //1.配置文件写入流
            in = Resources.getResourceAsStream("conf/sqlMap/sqlMap.xml");
            //2.创建SqlSessionFactory工厂
            /* XmlConfiguration理解为封装了数据库配置+mapper对象(namespace.sqlId+sql+类名)
             */
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);//读取流的数据库连接信息  (构建者模式？？？)

            //3.SqlSession对象(工厂模式生产)！！！=======> mysql连接对象connection，
            sqlSession = sqlSessionFactory.openSession(false); //设置transaction自动提交false/true
            // sqlSession.selectList("");

            //4.使用SqlSession创建Dao接口的代理对象！！！
            userDao = sqlSession.getMapper(UserDao.class);  //mybatis给@Mapper注解的接口的生成代理对象


            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema0409");
                String sql = "select *from cinema where cid= ? ";
                PreparedStatement preparedStatement = connection.prepareStatement("sql"); //预执行sql
                preparedStatement.setString(1,"1"); //指定第一个位置参数值
                ResultSet resultSet = preparedStatement.executeQuery(); //执行sql


                Statement statement = connection.createStatement();
                statement.execute("");


            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //释放资源
    static void destroy() {
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
