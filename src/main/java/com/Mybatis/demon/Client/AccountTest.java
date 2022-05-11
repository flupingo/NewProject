package com.Mybatis.demon.Client;

import com.Mybatis.demon.Dao.AccountDao;
import com.Mybatis.demon.entity.UserAccountInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created：Jeffrey
 * date   ：2020/7/7 22:23
 */
public class AccountTest {
    private static InputStream in;
    private static SqlSession sqlSession;
    private static AccountDao accountDao;


    public static void main(String[] args) {
        //1.初始化
        init();


//        List<AccountUser> list = accountDao.findAccountUserInfo();
//        for (AccountUser accountUser : list) {
//            System.out.println(accountUser.toString());
//        }

//        List<Account> list1 = accountDao.findAll();//一对一
//        for (Account account : list1) {
//            System.out.println(account.toString());
//        }

//        List<UserAccountInfo> list=accountDao.findUserAccountInfo();
//        for (UserAccountInfo userAccountInfo:list){
//            System.out.println(userAccountInfo.toString());
//        }

        //2.业务逻辑
        AccountDao accountDao = (AccountDao) getMapper(sqlSession, AccountDao.class);
        List<UserAccountInfo> list = accountDao.findUserAccountInfo();

        sqlSession.clearCache();
        List<UserAccountInfo> list1 = accountDao.findUserAccountInfo();
        System.out.println(list == list1);

        //3.销毁会话
        destroy();
    }

    static SqlSession init() {
        try {
            //1.配置文件 (mysql数据库连接信息及mapper文件位置！！！) 写入流
            in = Resources.getResourceAsStream("conf/sqlMap/sqlMap.xml");
            //2.创建SqlSessionFactory工厂
            /* XmlConfiguration理解为封装了数据库配置+mapper对象(namespace.sqlId+sql+类名)
             */
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);//读取流的数据库连接信息  (构建者模式)
            //3.使用工厂生产SqlSession对象  (工厂模式)
            sqlSession = sqlSessionFactory.openSession(false); //设置transaction自动提交false/true
            // sqlSession.selectList("");


            //4.使用SqlSession创建Dao接口的代理对象！！！
//            accountDao = sqlSession.getMapper(AccountDao.class);
//            List<UserAccountInfo> list=accountDao.findUserAccountInfo();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
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

    //获取接口的mapper
    public static Object getMapper(SqlSession sqlSession, Class cla) {
        return sqlSession.getMapper(cla);

    }


}
