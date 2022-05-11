package com.Mybatis.demon.entity;

/**
 * Created：Jeffrey
 * date   ：2020/7/7 22:36
 */
public class AccountUser extends Account {
    private  String userName;
    private  String address;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AccountUser{" +super.toString()+
                "userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
