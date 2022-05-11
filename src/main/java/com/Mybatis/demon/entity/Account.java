package com.Mybatis.demon.entity;

import java.io.Serializable;

/**
 * Created：Jeffrey
 * date   ：2020/7/7 22:17
 */
public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private double money;
    private User user;

    public Account() {
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUuid() {
        return uid;
    }

    public void setUuid(Integer uuid) {
        this.uid = uuid;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" + user.toString() +
                "id=" + id +
                ", uuid=" + uid +
                ", money=" + money +
                '}';
    }
}
