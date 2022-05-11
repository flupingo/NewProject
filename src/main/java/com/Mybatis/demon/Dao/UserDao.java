package com.Mybatis.demon.Dao;

import com.Mybatis.demon.entity.User;
import com.Mybatis.demon.entity.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    void saveUser(User user);

    void update(User user);

    void delete(Integer integer);

    User findUserById(Integer integer);

    List<User> findUserByName(String name);

    int findCountById(Integer id);

    int selectLastId(User user);

    List<User> findByCondition(@Param("name") String name);

    List<User>findByIn(@Param("list") List<String>list);

    List<User> findUserByUserVo(UserVo userVo);








}
