package com.springXml.demon.Service;

import java.util.Date;

/**
 * Created：Jeffrey
 * date   ：2020/7/1 16:37
 */
public class IOCSetUserServiceImpl {
    private String name;
    private Integer age;
    private Date date;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "IOCSetUserServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
