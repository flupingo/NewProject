package com.Mybatis.demon.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created：Jeffrey
 * date   ：2020/6/30 20:44
 */
public class User implements Serializable {
    private Integer id;
    private String name;
    private Date birthday;
    private String address;
    private String sex;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public User() {
    }

    public User(String name, Date birthday, String address, String sex) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.sex = sex;
    }

    public User(Integer id, String name, Date birthday, String address, String sex) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
