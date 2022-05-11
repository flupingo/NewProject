package com.springXml.demon.Factory;

import com.springXml.demon.DAO.UserDao;
import com.springXml.demon.DAOImpl.UserDaoImpl;

/**
 * Created：Jeffrey
 * date   ：2020/7/1 15:00
 */
public class StaticSimpleFactory {
    static UserDao staticCreateUserDao() {
        return new UserDaoImpl();
    }
}
