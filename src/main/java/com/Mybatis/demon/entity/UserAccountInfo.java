package com.Mybatis.demon.entity;

import java.util.Date;
import java.util.List;

/**
 * Created：Jeffrey
 * date   ：2020/7/8 10:14
 */
public class UserAccountInfo {
    private Integer id;
    private String name;
    private Date birthday;
    private String address;
    private String sex;
    private List<Account>accountList;

    @Override
    public String toString() {
        return "UserAccountInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", accountList=" + accountList +
                '}';
    }

    public UserAccountInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
