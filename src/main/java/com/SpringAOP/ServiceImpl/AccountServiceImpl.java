package com.SpringAOP.ServiceImpl;

import com.SpringAOP.Service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created：Jeffrey
 * date   ：2020/7/2 22:30
 */
@Transactional
@Service(value = "accountServiceImpl")
public class AccountServiceImpl implements AccountService {
    public void saveAccount() {
        System.out.println("保存");
    }

    public void updateAccount(int i) {
        System.out.println("修改");
    }

    public int deleteAccount() {
        int i=1/0;
        System.out.println("删除");
        return 0;
    }
}
