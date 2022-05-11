package com.springXml.demon.Service;

import Fundation.Dog;
import com.springXml.demon.Factory.BeanFactory;
import com.springXml.demon.DAO.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created：Jeffrey
 * date   ：2020/7/1 9:38
 */
public class UserServiceImpl {
    @Autowired
    Dog  dog;

    //    private UserDao userDao = new UserDaoImpl();
    private UserDao userDao = (UserDao) BeanFactory.getBean("userDao");

    public void add() {
        userDao.add();
    }

    public UserServiceImpl() {
    }

}
