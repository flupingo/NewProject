package com.springXml.demon.Service;

import java.util.Date;

/**
 * Created：Jeffrey
 * date   ：2020/7/1 16:07
 */
public class IOCUserServiceImpl {
    private String name;
    private Integer age;
    private Date date;

    public IOCUserServiceImpl(String name, Integer age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

//    public IOCUserServiceImpl() {
//    }
}
