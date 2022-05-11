package com.Mybatis.demon.Dao;

import com.Mybatis.demon.entity.AccountUser;
import com.Mybatis.demon.entity.Account;
import com.Mybatis.demon.entity.UserAccountInfo;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();
    List<AccountUser>findAccountUserInfo();
    List<UserAccountInfo>findUserAccountInfo();
}
