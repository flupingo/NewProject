package com.springXml.demon.Factory;

import com.springXml.demon.DAO.UserDao;
import com.springXml.demon.DAOImpl.UserDaoImpl;

/**
 * Created：Jeffrey
 * date   ：2020/7/1 14:54
 */
public class SimpleFactory {
    UserDao createUserDao() {
        return new UserDaoImpl();
    }
    void init(){

    }
    void destroy(){
        System.out.println("销毁！！！");
    }


}
